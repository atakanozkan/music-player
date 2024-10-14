package org.hyperskill.musicplayer.internals

import android.widget.Button
import androidx.fragment.app.FragmentContainerView
import androidx.recyclerview.widget.RecyclerView
import org.hyperskill.musicplayer.ui.MainActivity
import org.junit.Assert

// version 2.0
open class MusicPlayerBaseScreen(private val test: MusicPlayerUnitTests<MainActivity>) {
    companion object {
        const val ID_MAIN_BUTTON_SEARCH = "mainButtonSearch"
        const val ID_MAIN_SONG_LIST = "mainSongList"
        const val ID_MAIN_FRAGMENT_CONTAINER = "mainFragmentContainer"
        const val mainMenuItemIdAddPlaylist = "mainMenuAddPlaylist"
        const val mainMenuItemIdLoadPlaylist = "mainMenuLoadPlaylist"
        const val mainMenuItemIdDeletePlaylist = "mainMenuDeletePlaylist"
    }

    val mainButtonSearch by lazy {
        with(test) {
            val view = activity.findViewByString<Button>(ID_MAIN_BUTTON_SEARCH)

            val expectedText = "search"
            val actualText = view.text.toString().lowercase()
            Assert.assertEquals("wrong text for mainButtonSearch", expectedText, actualText)

            view
        }
    }

    val mainSongList by lazy {
        with(test) {
            activity.findViewByString<RecyclerView>(ID_MAIN_SONG_LIST)
        }
    }

    val mainFragmentContainer by lazy {
        with(test) {
            activity.findViewByString<FragmentContainerView>(ID_MAIN_FRAGMENT_CONTAINER)
        }
    }
}