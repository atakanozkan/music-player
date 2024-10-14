package org.hyperskill.musicplayer

import android.Manifest
import android.content.pm.PackageManager
import org.hyperskill.musicplayer.internals.CustomMediaPlayerShadow
import org.hyperskill.musicplayer.internals.CustomShadowAsyncDifferConfig
import org.hyperskill.musicplayer.internals.CustomShadowCountDownTimer
import org.hyperskill.musicplayer.internals.FakeContentProvider
import org.hyperskill.musicplayer.internals.MusicPlayerUnitTests
import org.hyperskill.musicplayer.internals.PlayMusicScreen
import org.hyperskill.musicplayer.internals.SongFake
import org.hyperskill.musicplayer.ui.MainActivity
import org.junit.After
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
class Stage4UnitTest : MusicPlayerUnitTests<MainActivity>(MainActivity::class.java) {


    companion object {
        const val expectedRequestCode = 1
    }

    @Before
    fun setUp() {
        CustomMediaPlayerShadow.acceptRawWisdom = false
    }

    @Test
    fun test00_testPermissionRequestGranted() {
        val fakeSongResult = SongFakeRepository.fakeSongData.dropLast(3)

        setupContentProvider(fakeSongResult)
        CustomMediaPlayerShadow.setFakeSong(fakeSongResult.first())

        testActivity {
            PlayMusicScreen(this).apply {
                mainButtonSearch.clickAndRun()
                assertRequestPermissions(listOf(Manifest.permission.READ_EXTERNAL_STORAGE))

                // grant permissions and invoke listener
                shadowActivity.grantPermissions(Manifest.permission.READ_EXTERNAL_STORAGE)
                activity.onRequestPermissionsResult(
                    expectedRequestCode,
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    intArrayOf(PackageManager.PERMISSION_GRANTED)
                )
                shadowLooper.idleFor(Duration.ofSeconds(3))
                //

                mainSongList.assertListItems(fakeSongResult) { itemViewSupplier, position, song ->
                    assertSongItem(
                        "After permission granted the list should load with song files data.",
                        itemViewSupplier(), song
                    )
                }
            }
        }
    }

    @Test
    fun test01_testListStateOnPermissionRequestDenied() {
        val fakeSongResult = SongFakeRepository.fakeSongData
        setupContentProvider(fakeSongResult)

        testActivity {
            PlayMusicScreen(this).apply {
                FakeContentProvider.hasPermissionToReadExternalStorage = false
                mainButtonSearch.clickAndRun()

                assertRequestPermissions(listOf(Manifest.permission.READ_EXTERNAL_STORAGE))

                shadowActivity.denyPermissions(Manifest.permission.READ_EXTERNAL_STORAGE)
                activity.onRequestPermissionsResult(
                    expectedRequestCode,
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    intArrayOf(PackageManager.PERMISSION_DENIED)
                )
                shadowLooper.idleFor(Duration.ofSeconds(3))

                mainSongList.assertListItems(listOf<SongFake>()) { _, _, _ -> /*implicitSizeAssertion*/ }
            }
        }
    }


    @Test
    fun test02_testToastShowsOnPermissionRequestDenied() {
        val fakeSongResult = SongFakeRepository.fakeSongData
        setupContentProvider(fakeSongResult)

        testActivity {
            PlayMusicScreen(this).apply {

                FakeContentProvider.hasPermissionToReadExternalStorage = false
                mainButtonSearch.clickAndRun()

                assertRequestPermissions(listOf(Manifest.permission.READ_EXTERNAL_STORAGE))

                shadowActivity.denyPermissions(Manifest.permission.READ_EXTERNAL_STORAGE)
                activity.onRequestPermissionsResult(
                    expectedRequestCode,
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    intArrayOf(PackageManager.PERMISSION_DENIED)
                )
                shadowLooper.idleFor(Duration.ofSeconds(3))

                assertLastToastMessageEquals(
                    errorMessage = "On permission denial a Toast with warning message",
                    expectedMessage = "Songs cannot be loaded without permission"
                )
            }
        }
    }

    @Test
    fun test03_testPermissionRequestAgainGranted() {
        val fakeSongResult = SongFakeRepository.fakeSongData

        setupContentProvider(fakeSongResult)
        CustomMediaPlayerShadow.setFakeSong(fakeSongResult.first())

        testActivity {
            PlayMusicScreen(this).apply {

                FakeContentProvider.hasPermissionToReadExternalStorage = false
                mainButtonSearch.clickAndRun()

                assertRequestPermissions(listOf(Manifest.permission.READ_EXTERNAL_STORAGE))

                shadowActivity.denyPermissions(Manifest.permission.READ_EXTERNAL_STORAGE)
                activity.onRequestPermissionsResult(
                    expectedRequestCode,
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    intArrayOf(PackageManager.PERMISSION_DENIED)
                )
                shadowLooper.runToEndOfTasks()

                mainSongList.assertListItems(listOf<SongFake>()) { _, _, _ -> /*implicitSizeAssertion*/ }

                FakeContentProvider.hasPermissionToReadExternalStorage = true
                mainButtonSearch.clickAndRun()
                assertRequestPermissions(listOf(Manifest.permission.READ_EXTERNAL_STORAGE))
                shadowActivity.grantPermissions(Manifest.permission.READ_EXTERNAL_STORAGE)
                activity.onRequestPermissionsResult(
                    expectedRequestCode,
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    intArrayOf(PackageManager.PERMISSION_GRANTED)
                )
                shadowLooper.runToEndOfTasks()

                mainSongList.assertListItems(fakeSongResult) { itemViewSupplier, position, song ->
                    assertSongItem(
                        "After permission is granted songs should be loaded into mainSongList. Song",
                        itemViewSupplier(), song
                    )
                }
            }
        }
    }

    @Test
    fun test04_testMusicFilesRetrievalAllFiles() {
        shadowActivity.grantPermissions(Manifest.permission.READ_EXTERNAL_STORAGE)
        val fakeSongResult = SongFakeRepository.fakeSongData
        setupContentProvider(fakeSongResult)
        CustomMediaPlayerShadow.setFakeSong(fakeSongResult.first())

        testActivity {
            PlayMusicScreen(this).apply {
                mainButtonSearch.clickAndRun()
                mainSongList.assertListItems(fakeSongResult) { itemViewSupplier, position, song ->
                    assertSongItem(
                        "mainSongList content should be songs found on external storage. Song",
                        itemViewSupplier(), song
                    )
                }
            }
        }
    }

    @Test
    fun test05_testMusicFilesRetrievalNoFiles() {
        shadowActivity.grantPermissions(Manifest.permission.READ_EXTERNAL_STORAGE)
        val fakeSongResult = listOf<SongFake>()
        setupContentProvider(fakeSongResult)

        testActivity {
            PlayMusicScreen(this).apply {
                mainSongList.assertListItems(fakeSongResult) { _, _, _ -> /*implicitSizeAssertion*/ }
            }
        }
    }

    @After
    fun tearDown() {
        FakeContentProvider.hasPermissionToReadExternalStorage = true
    }
}