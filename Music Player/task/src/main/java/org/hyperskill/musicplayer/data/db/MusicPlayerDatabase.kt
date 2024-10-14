package org.hyperskill.musicplayer.data.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import org.hyperskill.musicplayer.domain.entity.PlaylistEntry

class MusicPlayerDatabase(context: Context) : SQLiteOpenHelper(context, "musicPlayerDatabase.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("""
            CREATE TABLE IF NOT EXISTS playlist (
                playlistName TEXT,
                songId INTEGER,
                PRIMARY KEY (playlistName, songId)
            )
        """.trimIndent())
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        if (db != null) {
            db.execSQL("DROP TABLE IF EXISTS playlist")
            onCreate(db)
        }
    }

    fun addPlaylist(playlistName: String, songIds: List<Long>) {
        val db = writableDatabase
        db.beginTransaction()
        try {
            db.delete("playlist", "playlistName = ?", arrayOf(playlistName))

            val stmt = db.compileStatement("INSERT INTO playlist (playlistName, songId) VALUES (?, ?)")
            for (songId in songIds) {
                stmt.bindString(1, playlistName)
                stmt.bindLong(2, songId)
                stmt.executeInsert()
            }
            db.setTransactionSuccessful()
        } finally {
            db.endTransaction()
        }
    }

    fun removePlaylist(playlistName: String) {
        writableDatabase.delete("playlist", "playlistName = ?", arrayOf(playlistName))
    }

    fun getPlaylist(playlistName: String): List<PlaylistEntry> {
        val db = readableDatabase
        val cursor = db.query(
            "playlist",
            arrayOf("playlistName", "songId"),
            "playlistName = ?",
            arrayOf(playlistName),
            null, null, null
        )

        val playlistEntries = mutableListOf<PlaylistEntry>()
        while (cursor.moveToNext()) {
            val name = cursor.getString(cursor.getColumnIndexOrThrow("playlistName"))
            val songId = cursor.getLong(cursor.getColumnIndexOrThrow("songId"))
            playlistEntries.add(PlaylistEntry(name, songId))
        }
        cursor.close()
        return playlistEntries
    }

    fun getAllPlaylistsGrouped(): Map<String, List<Long>> {
        val db = readableDatabase
        val cursor = db.query(
            "playlist",
            arrayOf("playlistName", "songId"),
            null,
            null,
            null,
            null,
            null
        )

        val playlists = mutableMapOf<String, MutableList<Long>>()
        while (cursor.moveToNext()) {
            val playlistName = cursor.getString(cursor.getColumnIndexOrThrow("playlistName"))
            val songId = cursor.getLong(cursor.getColumnIndexOrThrow("songId"))
            playlists.getOrPut(playlistName) { mutableListOf() }.add(songId)
        }
        cursor.close()
        return playlists
    }
}
