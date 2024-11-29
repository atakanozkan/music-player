package org.hyperskill.musicplayer.data.db

import org.hyperskill.musicplayer.domain.entity.PlaylistEntry

interface MusicPlayerDatabase {
    fun addPlaylist(playlistName: String, songIds: List<Long>)
    fun removePlaylist(playlistName: String)
    fun getPlaylist(playlistName: String): List<PlaylistEntry>
    fun getAllPlaylistsGrouped(): Map<String, List<Long>>
}