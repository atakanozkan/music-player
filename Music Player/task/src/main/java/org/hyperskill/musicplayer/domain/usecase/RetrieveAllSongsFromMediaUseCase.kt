package org.hyperskill.musicplayer.domain.usecase

import android.content.Context
import android.database.Cursor
import android.provider.MediaStore
import android.util.Log
import com.videochat.architecture.domain.usecase.UseCase
import org.hyperskill.musicplayer.domain.model.SongDomainModel

class RetrieveAllSongsFromMediaUseCase(
    private val context: Context
) : UseCase<Unit, Result<MutableList<SongDomainModel>>> {

    override suspend fun execute(input: Unit): Result<MutableList<SongDomainModel>>{
        val projection = arrayOf(
            MediaStore.Audio.Media._ID,
            MediaStore.Audio.Media.ARTIST,
            MediaStore.Audio.Media.TITLE,
            MediaStore.Audio.Media.DURATION
        )

        val songList = mutableListOf<SongDomainModel>()
        try {
            context.contentResolver.query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                projection,
                null,
                null,
                null
            ).use { cursor: Cursor? ->
                if (cursor != null) {
                    val idCol = cursor.getColumnIndex(MediaStore.Audio.Media._ID)
                    val artistCol = cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST)
                    val titleCol = cursor.getColumnIndex(MediaStore.Audio.Media.TITLE)
                    val durationCol = cursor.getColumnIndex(MediaStore.Audio.Media.DURATION)
                    while (cursor.moveToNext()) {
                        val id = cursor.getLong(idCol)
                        val artist = cursor.getString(artistCol)
                        val title = cursor.getString(titleCol)
                        val duration = cursor.getLong(durationCol)
                        songList.add(
                            SongDomainModel(
                                id = id,
                                title = title,
                                artist = artist,
                                duration = duration
                            )
                        )
                    }
                }
            }
        } catch (e: Exception) {
            Log.e("Error retrieving songs", "${e.message}")
            return Result.failure(e)
        }
        return Result.success(songList)
    }
}