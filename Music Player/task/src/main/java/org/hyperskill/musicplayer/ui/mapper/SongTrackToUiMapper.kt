package org.hyperskill.musicplayer.ui.mapper

import org.hyperskill.musicplayer.base.ui.mapper.Mapper
import org.hyperskill.musicplayer.presentation.model.SongTrackPresentationModel
import org.hyperskill.musicplayer.ui.model.SongTrackUiModel

class SongTrackToUiMapper(
    private val mapper: SongToUiMapper
): Mapper<SongTrackPresentationModel, SongTrackUiModel> {
    override fun map(input: SongTrackPresentationModel): SongTrackUiModel {
        return SongTrackUiModel(
            mapper.map(input.song),
            input.songPlayMode
        )
    }
}