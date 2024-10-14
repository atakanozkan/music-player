package org.hyperskill.musicplayer.ui.mapper

import org.hyperskill.musicplayer.architecture.ui.mapper.Mapper
import org.hyperskill.musicplayer.presentation.model.SongPresentationModel
import org.hyperskill.musicplayer.ui.model.SongUiModel

class SongToUiMapper : Mapper<SongPresentationModel,SongUiModel> {
    override fun map(input: SongPresentationModel): SongUiModel {
        return SongUiModel(
            id = input.id,
            title = input.title,
            artist = input.artist,
            duration = input.duration
        )
    }
}