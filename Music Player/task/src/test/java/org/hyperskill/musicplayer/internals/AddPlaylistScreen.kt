package org.hyperskill.musicplayer.internals

import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import org.hyperskill.musicplayer.ui.MainActivity
import org.junit.Assert.assertEquals

// version 2.0
class AddPlaylistScreen(
    private val test: MusicPlayerUnitTests<MainActivity>,
) : MusicPlayerBaseScreen(test) {
    companion object {
        const val ID_SONG_SELECTOR_ITEM_TV_TITLE = "songSelectorItemTvTitle"
        const val ID_SONG_SELECTOR_ITEM_TV_ARTIST = "songSelectorItemTvArtist"
        const val ID_SONG_SELECTOR_ITEM_TV_DURATION = "songSelectorItemTvDuration"
        const val ID_SONG_SELECTOR_ITEM_CHECKBOX = "songSelectorItemCheckBox"
        const val ID_ADD_PLAYLIST_BTN_OK = "addPlaylistBtnOk"
        const val ID_ADD_PLAYLIST_ET_PLAYLIST_NAME = "addPlaylistEtPlaylistName"
        const val ID_ADD_PLAYLIST_BTN_CANCEL = "addPlaylistBtnCancel"
    }

    val addPlaylistButtonOk by lazy {
        with(test){
            mainFragmentContainer
                .findViewByString<Button>(ID_ADD_PLAYLIST_BTN_OK)
                .also { addPlaylistBtnOk ->
                    assertEquals(
                        "Wrong text for $ID_ADD_PLAYLIST_BTN_OK",
                        "ok",
                        addPlaylistBtnOk.text.toString().lowercase()
                    )
                }
        }
    }
    val addPlaylistEtPlaylistName by lazy {
        with(test){
            mainFragmentContainer
                .findViewByString<EditText>(ID_ADD_PLAYLIST_ET_PLAYLIST_NAME)
                .also { addPlaylistEtPlaylistName ->
                    assertEquals(
                        "Wrong hint for $ID_ADD_PLAYLIST_ET_PLAYLIST_NAME",
                        "playlist name",
                        addPlaylistEtPlaylistName.hint.toString().lowercase()
                    )
                }
        }
    }
    val addPlaylistBtnCancel by lazy {
        with(test){
            mainFragmentContainer
                .findViewByString<Button>(ID_ADD_PLAYLIST_BTN_CANCEL)
                .also { addPlaylistBtnCancel ->
                    assertEquals(
                        "Wrong text for $ID_ADD_PLAYLIST_BTN_CANCEL",
                        "cancel",
                        addPlaylistBtnCancel.text.toString().lowercase()
                    )
                }
        }
    }



    inner class SongSelectorItemBindings(itemViewSupplier: () -> View) {
        val itemView = itemViewSupplier()

        val songSelectorItemTvTitle: TextView = with(test) {
            itemView.findViewByString(ID_SONG_SELECTOR_ITEM_TV_TITLE)
        }
        val songSelectorItemTvArtist: TextView = with(test) {
            itemView.findViewByString(ID_SONG_SELECTOR_ITEM_TV_ARTIST)
        }
        val songSelectorItemTvDuration: TextView = with(test) {
            itemView.findViewByString(ID_SONG_SELECTOR_ITEM_TV_DURATION)
        }
        val songSelectorItemCheckBox: CheckBox = with(test) {
            itemView.findViewByString(ID_SONG_SELECTOR_ITEM_CHECKBOX)
        }

        fun assertSongSelectorInfo(caseDescription: String, song: SongFake) = with(test) {
            val actualArtist = songSelectorItemTvArtist.text.toString().lowercase()
            val actualTitle = songSelectorItemTvTitle.text.toString().lowercase()
            val actualDuration = songSelectorItemTvDuration.text.toString().lowercase()
            assertEquals(
                "$caseDescription, wrong text on $ID_SONG_SELECTOR_ITEM_TV_ARTIST",
                song.artist, actualArtist
            )
            assertEquals(
                "$caseDescription, wrong text on $ID_SONG_SELECTOR_ITEM_TV_TITLE",
                song.title, actualTitle
            )
            assertEquals(
                "$caseDescription, wrong text on $ID_SONG_SELECTOR_ITEM_TV_DURATION",
                song.duration.timeString(), actualDuration
            )
        }
    }
}