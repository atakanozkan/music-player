package org.hyperskill.musicplayer.domain.usecase

import android.content.Context
import android.provider.MediaStore
import com.videochat.architecture.domain.usecase.UseCase
import org.hyperskill.musicplayer.domain.model.SongDomainModel

class GetSongFromMediaByIdUseCase(
    private val context: Context
) :  UseCase<Long, Result<SongDomainModel>> {

    override suspend fun execute(input: Long): Result<SongDomainModel>{
        val uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        val projection = arrayOf(
            MediaStore.Audio.Media._ID,
            MediaStore.Audio.Media.ARTIST,
            MediaStore.Audio.Media.TITLE,
            MediaStore.Audio.Media.DURATION
        )

        val selection = "${MediaStore.Audio.Media._ID} = ?"
        val selectionArgs = arrayOf(input.toString())

        context.contentResolver.query(
            uri,
            projection,
            selection,
            selectionArgs,
            null
        ).use { cursor ->
            if (cursor != null && cursor.moveToFirst()) {
                val idCol = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media._ID)
                val artistCol = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST)
                val titleCol = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE)
                val durationCol = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION)

                val id = cursor.getLong(idCol)
                val artist = cursor.getString(artistCol)
                val title = cursor.getString(titleCol)
                val duration = cursor.getLong(durationCol)

                return Result.success(SongDomainModel(
                    id = id,
                    title = title,
                    artist = artist,
                    duration = duration
                ))
            }
        }
        return Result.failure(Exception("No media image found"))
    }
}