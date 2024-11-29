package org.hyperskill.musicplayer.di

import org.hyperskill.musicplayer.data.db.MusicPlayerDatabase
import org.hyperskill.musicplayer.data.db.impl.MusicPlayerDatabaseImpl
import org.hyperskill.musicplayer.domain.usecase.GetSongFromMediaByIdUseCase
import org.hyperskill.musicplayer.domain.usecase.RetrieveAllSongsFromMediaUseCase
import org.hyperskill.musicplayer.presentation.mapper.SongDomainToPresentationMapper
import org.hyperskill.musicplayer.presentation.viewModel.MusicPlaylistViewModel
import org.hyperskill.musicplayer.presentation.viewModel.MusicPlayerViewModel
import org.hyperskill.musicplayer.presentation.viewModel.MusicSelectorViewModel
import org.hyperskill.musicplayer.ui.mapper.SongSelectorToUiMapper
import org.hyperskill.musicplayer.ui.mapper.SongToUiMapper
import org.hyperskill.musicplayer.ui.mapper.SongTrackToUiMapper
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { MusicPlayerDatabaseImpl(get()) as MusicPlayerDatabase }

    factory { RetrieveAllSongsFromMediaUseCase(get()) }
    factory { GetSongFromMediaByIdUseCase(get()) }

    single { SongDomainToPresentationMapper() }
    single { SongToUiMapper() }
    single { SongSelectorToUiMapper(get()) }
    single { SongTrackToUiMapper(get()) }

    viewModel { MusicPlaylistViewModel(get(), get(), get(), get()) }
    viewModel { MusicPlayerViewModel() }
    viewModel { MusicSelectorViewModel() }
}