package org.hyperskill.musicplayer

import android.Manifest
import android.content.ContentValues
import androidx.core.database.sqlite.transaction
import org.hyperskill.musicplayer.internals.AddPlaylistScreen
import org.hyperskill.musicplayer.internals.CustomMediaPlayerShadow
import org.hyperskill.musicplayer.internals.CustomShadowAsyncDifferConfig
import org.hyperskill.musicplayer.internals.CustomShadowCountDownTimer
import org.hyperskill.musicplayer.internals.MusicPlayerBaseScreen.Companion.ID_MAIN_BUTTON_SEARCH
import org.hyperskill.musicplayer.internals.MusicPlayerBaseScreen.Companion.mainMenuItemIdAddPlaylist
import org.hyperskill.musicplayer.internals.MusicPlayerBaseScreen.Companion.mainMenuItemIdLoadPlaylist
import org.hyperskill.musicplayer.internals.MusicPlayerUnitTests
import org.hyperskill.musicplayer.internals.PlayMusicScreen
import org.hyperskill.musicplayer.internals.TestDatabaseFactory
import org.hyperskill.musicplayer.ui.MainActivity
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.time.Duration

// version 2.0
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Config(shadows = [CustomMediaPlayerShadow::class, CustomShadowCountDownTimer::class, CustomShadowAsyncDifferConfig::class])
@RunWith(RobolectricTestRunner::class)
class Stage5UnitTest : MusicPlayerUnitTests<MainActivity>(MainActivity::class.java) {


    companion object {
        const val tableName = "playlist"
        const val columnSongId = "songId"
        const val columnPlaylistName = "playlistName"
        const val createQuery = "CREATE TABLE IF NOT EXISTS $tableName(" +
                "$columnPlaylistName TEXT, " +
                "$columnSongId INTEGER, " +
                "PRIMARY KEY($columnPlaylistName, $columnSongId));"

        const val ALL_SONGS = "All Songs"
    }

    @Before
    fun setUp() {
        setupContentProvider(SongFakeRepository.fakeSongData)
        shadowActivity.grantPermissions(Manifest.permission.READ_EXTERNAL_STORAGE)
        CustomMediaPlayerShadow.setFakeSong(SongFakeRepository.fakeSongData[0])
        CustomMediaPlayerShadow.acceptRawWisdom = false
    }

    @Test
    fun test00_checkDatabaseDataAfterPlaylistSave() = testActivity {
        PlayMusicScreen(this).apply {
            mainButtonSearch

            mainButtonSearch.clickAndRun()

            val playlistName = "cool songs"
            val selectedItemsIndex = listOf(2, 5, 6)
            val expectedDatabaseData = selectedItemsIndex.map {
                playlistName to SongFakeRepository.fakeSongData[it].id
            }

            activity.clickMenuItemAndRun(mainMenuItemIdAddPlaylist)
            addPlaylist(
                playlistName = playlistName,
                selectedItemsIndex = selectedItemsIndex,
                songListView = mainSongList,
                fragmentContainer = mainFragmentContainer,
            )

            shadowLooper.idleFor(Duration.ofSeconds(3))

            TestDatabaseFactory(activity).readableDatabase.use { readableDatabase ->
                val cursor = readableDatabase.query(
                    tableName, null, null,
                    null, null, null, null
                )

                val columnSongIdIndex = cursor.getColumnIndex(columnSongId)
                val columnPlaylistNameIndex = cursor.getColumnIndex(columnPlaylistName)

                val actualDatabaseData = generateSequence {
                    cursor.moveToNext().let { hasNext ->
                        if (hasNext) {
                            val playlistName = cursor.getString(columnPlaylistNameIndex)
                            val songId = cursor.getInt(columnSongIdIndex)

                            playlistName to songId
                        } else {
                            cursor.close()
                            null
                        }
                    }
                }.toList()

                assertEquals(
                    "The number of rows in table $tableName is incorrect,",
                    expectedDatabaseData.size,
                    actualDatabaseData.size
                )

                expectedDatabaseData.forEachIndexed { i, expectedData ->
                    val actualData = actualDatabaseData[i]


                    val messageWrongData =
                        "Incorrect data stored in table $tableName,"
                    assertEquals(messageWrongData, expectedData, actualData)
                }
            }
        }
        Unit
    }

    @Test
    fun test01_checkSamePlaylistSaveTwiceNoDuplicatesOnDatabase() = testActivity {
        val playlistName = "cool songs"
        val selectedItemsIndex = listOf(2, 5, 6)
        val expectedDatabaseData = selectedItemsIndex.map {
            playlistName to SongFakeRepository.fakeSongData[it].id
        }
        PlayMusicScreen(this).apply {
            mainButtonSearch.clickAndRun()
            activity.clickMenuItemAndRun(mainMenuItemIdAddPlaylist)
        }
        AddPlaylistScreen(this).apply {
            addPlaylist(
                playlistName = playlistName,
                selectedItemsIndex = selectedItemsIndex,
                songListView = mainSongList,
                fragmentContainer = mainFragmentContainer,
            )
        }
        PlayMusicScreen(this).apply {

            shadowLooper.idleFor(Duration.ofSeconds(3))

            activity.clickMenuItemAndRun(mainMenuItemIdAddPlaylist)
        }
        AddPlaylistScreen(this).apply {
            addPlaylist(
                playlistName = playlistName,
                selectedItemsIndex = selectedItemsIndex,
                songListView = mainSongList,
                fragmentContainer = mainFragmentContainer,
            )
        }
        PlayMusicScreen(this).apply {

            shadowLooper.idleFor(Duration.ofSeconds(3))
            TestDatabaseFactory(activity).readableDatabase.use { readableDatabase ->
                val cursor = readableDatabase.query(
                    tableName, null, null,
                    null, null, null, null
                )

                val columnSongIdIndex = cursor.getColumnIndex(columnSongId)
                val columnPlaylistNameIndex = cursor.getColumnIndex(columnPlaylistName)

                val actualDatabaseData = generateSequence {
                    cursor.moveToNext().let { hasNext ->
                        if (hasNext) {
                            val playlistName = cursor.getString(columnPlaylistNameIndex)
                            val songId = cursor.getInt(columnSongIdIndex)

                            playlistName to songId
                        } else {
                            cursor.close()
                            null
                        }
                    }
                }.toList()

                assertEquals(
                    "The number of rows in table $tableName is incorrect,",
                    expectedDatabaseData.size,
                    actualDatabaseData.size
                )

                expectedDatabaseData.forEachIndexed { i, expectedData ->
                    val actualData = actualDatabaseData[i]


                    val messageWrongData =
                        "Incorrect data stored in table $tableName,"
                    assertEquals(messageWrongData, expectedData, actualData)
                }
            }
        }
        Unit
    }

    @Test
    fun test02_checkDatabaseDataAfterPlaylistSaveWithExistingPlaylistNameAndDifferentSongs() = testActivity {
        val playlistName = "cool songs"
        val selectedOldItemsIndex = listOf(2, 5, 6)
        val selectedNewItemsIndex = listOf(1, 5, 7, 8)
        val expectedDatabaseData = selectedNewItemsIndex.map {
            playlistName to SongFakeRepository.fakeSongData[it].id
        }

        PlayMusicScreen(this).apply {
            mainButtonSearch.clickAndRun()
            activity.clickMenuItemAndRun(mainMenuItemIdAddPlaylist)
        }
        AddPlaylistScreen(this).apply {
            addPlaylist(
                playlistName = playlistName,
                selectedItemsIndex = selectedOldItemsIndex,
                songListView = mainSongList,
                fragmentContainer = mainFragmentContainer,
            )
        }
        PlayMusicScreen(this).apply {
            shadowLooper.idleFor(Duration.ofSeconds(3))
            activity.clickMenuItemAndRun(mainMenuItemIdAddPlaylist)
        }
        AddPlaylistScreen(this).apply {
            addPlaylist(
                playlistName = playlistName,
                selectedItemsIndex = selectedNewItemsIndex,
                songListView = mainSongList,
                fragmentContainer = mainFragmentContainer,
            )
        }
        PlayMusicScreen(this).apply {
            shadowLooper.idleFor(Duration.ofSeconds(3))

            TestDatabaseFactory(activity).readableDatabase.use { readableDatabase ->
                val cursor = readableDatabase.query(
                    tableName, null, null,
                    null, null, null, null
                )

                val columnSongIdIndex = cursor.getColumnIndex(columnSongId)
                val columnPlaylistNameIndex = cursor.getColumnIndex(columnPlaylistName)

                val actualDatabaseData = generateSequence {
                    cursor.moveToNext().let { hasNext ->
                        if (hasNext) {
                            val playlistName = cursor.getString(columnPlaylistNameIndex)
                            val songId = cursor.getInt(columnSongIdIndex)

                            playlistName to songId
                        } else {
                            cursor.close()
                            null
                        }
                    }
                }.toList()

                assertEquals(
                    "The number of rows in table $tableName is incorrect,",
                    expectedDatabaseData.size,
                    actualDatabaseData.size
                )

                expectedDatabaseData.forEachIndexed { i, expectedData ->
                    val actualData = actualDatabaseData[i]

                    val messageWrongData =
                        "Incorrect data stored in table $tableName,"
                    assertEquals(messageWrongData, expectedData, actualData)
                }
            }
        }
        Unit
    }

    @Test
    fun test03_checkDatabaseDifferentPlaylistSaves() = testActivity {
        val playlistNameA = "cool songs"
        val playlistNameB = "ok songs"
        val selectedPlaylistAItemsIndex = listOf(2, 5, 6)
        val selectedPlaylistBItemsIndex = listOf(3, 4, 7, 8)

        val expectedDatabaseData = selectedPlaylistAItemsIndex.map {
            playlistNameA to SongFakeRepository.fakeSongData[it].id
        } + selectedPlaylistBItemsIndex.map {
            playlistNameB to SongFakeRepository.fakeSongData[it].id
        }

        PlayMusicScreen(this).apply {
            mainButtonSearch.clickAndRun()
            activity.clickMenuItemAndRun(mainMenuItemIdAddPlaylist)
        }
        AddPlaylistScreen(this).apply {
            addPlaylist(
                playlistName = playlistNameA,
                selectedItemsIndex = selectedPlaylistAItemsIndex,
                songListView = mainSongList,
                fragmentContainer = mainFragmentContainer,
            )
        }
        PlayMusicScreen(this).apply {
            shadowLooper.idleFor(Duration.ofSeconds(3))

            activity.clickMenuItemAndRun(mainMenuItemIdAddPlaylist)
        }
        AddPlaylistScreen(this).apply {
            addPlaylist(
                playlistName = playlistNameB,
                selectedItemsIndex = selectedPlaylistBItemsIndex,
                songListView = mainSongList,
                fragmentContainer = mainFragmentContainer,
            )
        }
        PlayMusicScreen(this).apply {

            shadowLooper.idleFor(Duration.ofSeconds(3))

            TestDatabaseFactory(activity).readableDatabase.use { readableDatabase ->
                val cursor = readableDatabase.query(
                    tableName, null, null,
                    null, null, null, null
                )

                val columnSongIdIndex = cursor.getColumnIndex(columnSongId)
                val columnPlaylistNameIndex = cursor.getColumnIndex(columnPlaylistName)

                val actualDatabaseData = generateSequence {
                    cursor.moveToNext().let { hasNext ->
                        if (hasNext) {
                            val playlistName = cursor.getString(columnPlaylistNameIndex)
                            val songId = cursor.getInt(columnSongIdIndex)

                            playlistName to songId
                        } else {
                            cursor.close()
                            null
                        }
                    }
                }.toList()

                assertEquals(
                    "The number of rows in table $tableName is incorrect,",
                    expectedDatabaseData.size,
                    actualDatabaseData.size
                )

                expectedDatabaseData.forEachIndexed { i, expectedData ->
                    val actualData = actualDatabaseData[i]

                    val messageWrongData =
                        "Incorrect data stored in table $tableName,"
                    assertEquals(messageWrongData, expectedData, actualData)
                }
            }
        }
        Unit
    }

    @Test
    fun test04_checkLoadPlaylistFromDatabase() {
        val playlistName = "fake songs"
        val fakeData = listOf(9, 10, 11).map { index ->
            playlistName to index
        }

        TestDatabaseFactory(activity).writableDatabase.use { writableDatabase ->
            writableDatabase.execSQL(createQuery)

            writableDatabase.transaction {
                fakeData.forEach { (playlistName, index) ->
                    val values = ContentValues()
                    values.put(columnPlaylistName, playlistName)
                    values.put(columnSongId, index + 1)

                    insert(tableName, null, values)
                }
            }
        }

        testActivity {
            PlayMusicScreen(this).apply {

                mainButtonSearch.clickAndRun()

                val expectedItems = fakeData.map { SongFakeRepository.fakeSongData[it.second] }
                CustomMediaPlayerShadow.setFakeSong(expectedItems.first())

                loadPlaylist(
                    menuItemIdLoadPlaylist = mainMenuItemIdLoadPlaylist,
                    expectedPlaylistNameList = listOf(ALL_SONGS, playlistName),
                    playlistToLoadIndex = 1
                )

                mainSongList.assertListItems(expectedItems) { itemViewSupplier, position, song ->
                    assertSongItem(
                        "Incorrect item after loading a list from database",
                        itemViewSupplier(),
                        song
                    )
                }
            }
        }
    }

    @Test
    fun test05_checkAutomaticSearchOnPlaylistLoad() {
        val playlistName = "Party Songs"
        val fakeData = listOf(3, 12, 13).map { index ->
            playlistName to index
        }

        TestDatabaseFactory(activity).writableDatabase.use { writableDatabase ->
            writableDatabase.execSQL(createQuery)

            writableDatabase.transaction {
                fakeData.forEach { (playlistName, index) ->
                    val values = ContentValues()
                    values.put(columnPlaylistName, playlistName)
                    values.put(columnSongId, index + 1)

                    insert(tableName, null, values)
                }
            }
        }

        testActivity {
            PlayMusicScreen(this).apply {
                val expectedItems = fakeData.map { SongFakeRepository.fakeSongData[it.second] }
                CustomMediaPlayerShadow.setFakeSong(expectedItems.first())

                loadPlaylist(
                    menuItemIdLoadPlaylist = mainMenuItemIdLoadPlaylist,
                    expectedPlaylistNameList = listOf(ALL_SONGS, playlistName),
                    playlistToLoadIndex = 1
                )

                mainSongList.assertListItems(expectedItems) { itemViewSupplier, position, song ->
                    assertSongItem(
                        "If a list is loaded before $ID_MAIN_BUTTON_SEARCH is clicked " +
                                "then the search should be done automatically before loading the list",
                        itemViewSupplier(),
                        song
                    )
                }
            }
        }
    }
}