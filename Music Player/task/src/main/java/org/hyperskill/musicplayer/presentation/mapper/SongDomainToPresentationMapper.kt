package org.hyperskill.musicplayer.presentation.mapper

import org.hyperskill.musicplayer.base.presentation.mapper.Mapper
import org.hyperskill.musicplayer.domain.model.SongDomainModel
import org.hyperskill.musicplayer.presentation.model.SongPresentationModel

class SongDomainToPresentationMapper : Mapper<SongDomainModel, SongPresentationModel> {
    override fun map(input: SongDomainModel): SongPresentationModel {
        return SongPresentationModel(
            id = input.id,
            title = input.title,
            artist = input.artist,
            duration = input.duration
        )
    }
}