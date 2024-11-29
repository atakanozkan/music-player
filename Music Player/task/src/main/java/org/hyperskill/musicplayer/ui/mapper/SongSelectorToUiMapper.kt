package org.hyperskill.musicplayer.ui.mapper

import org.hyperskill.musicplayer.base.ui.mapper.Mapper
import org.hyperskill.musicplayer.presentation.model.SongSelectorPresentationModel
import org.hyperskill.musicplayer.ui.model.SongSelectorUiModel

class SongSelectorToUiMapper(
    private val mapper: SongToUiMapper
) : Mapper<SongSelectorPresentationModel, SongSelectorUiModel> {
    override fun map(input: SongSelectorPresentationModel): SongSelectorUiModel {
        return SongSelectorUiModel(
            mapper.map(input.song),
            input.isSelected
        )
    }
}