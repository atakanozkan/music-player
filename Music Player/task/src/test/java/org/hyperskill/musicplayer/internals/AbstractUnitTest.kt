package org.hyperskill.musicplayer.internals

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.SeekBar
import androidx.recyclerview.widget.RecyclerView
import org.junit.Assert
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.robolectric.Robolectric
import org.robolectric.Shadows.shadowOf
import org.robolectric.android.controller.ActivityController
import org.robolectric.shadow.api.Shadow
import org.robolectric.shadows.ShadowActivity
import org.robolectric.shadows.ShadowAlertDialog
import org.robolectric.shadows.ShadowLooper
import org.robolectric.shadows.ShadowToast
import java.time.Duration
import java.util.concurrent.TimeUnit

// version 2.0
abstract class AbstractUnitTest<T : Activity>(clazz: Class<T>) {

    /**
     * Setup and control activities and their lifecycle
     */
    val activityController: ActivityController<T> by lazy {
        Robolectric.buildActivity(clazz)
    }

    /**
     * The activity being tested.
     *
     * It is the @RealObject of the shadowActivity
     */
    val activity : Activity by lazy {
        activityController.get()
    }

    /**
     * A Roboletric shadow object of the Activity class, contains helper methods to deal with
     * testing activities like setting permissions, peeking results of launched activities for result,
     * retrieving shown dialogs, intents and others.
     *
     * If you don't know what shadows are you can have a better understanding on that reading this
     * on roboletric documentation: http://robolectric.org/extending/
     *
     * Understanding Shadows is fundamental for Roboletric, things are not what they appear to be on
     * Roboletric because running a code on the jvm is not the same as running the code on a real/emulated device.
     * Code that expects to eventually talk to the machine won't have the machine they expect to have to talk to.
     * Shadow is how Roboletric makes things possible, they impersonate @RealObject and act when @RealObject is expected to act.
     *
     * Things in Roboletric are not what they appear to be.
     * It is possible to not notice it for the most part, but it will be essential for some other parts
     */
    val shadowActivity: ShadowActivity by lazy {
        Shadow.extract(activity)
    }

    /**
     * A Roboletric shadow object of the mainLooper. Handles enqueued runnables and also the passage of time.
     *
     * Usually used with .idleFor(someDurationValue) or .runToEndOfTasks()
     */
    val shadowLooper: ShadowLooper by lazy {
        shadowOf(activity.mainLooper)
    }

    /**
     * Sets up activity for tests and ensures better error messages displayed
     * when tests are run with check button and exceptions are thrown by user implementation.
     *
     * returns a value for convenience use, like in tests that involve navigation between Activities
     */
    fun <ReturnValue> testActivity(
        arguments: Intent = Intent(),
        savedInstanceState: Bundle? = null,
        testCodeBlock: (Activity) -> ReturnValue
    ): ReturnValue {
        try {
            activity.intent = arguments
            if (savedInstanceState == null) {
                activityController.setup()
            } else {
                activityController.setup(savedInstanceState)
            }
        } catch (ex: Exception) {
            throw AssertionError("Exception, test failed on activity creation with $ex\n${ex.stackTraceToString()}")
        }

        return try {
            testCodeBlock(activity)
        } catch (ex: Exception) {
            throw AssertionError("Exception. Test failed on activity execution with $ex\n${ex.stackTraceToString()}")
        }
    }

    /**
     * Use this method to find views.
     *
     * The view existence will be assert before being returned
     */
    inline fun <reified T> Activity.findViewByString(idString: String): T {
        val id = this.resources.getIdentifier(idString, "id", packageName)
        val maybeView: View? = this.findViewById(id)

        val (expectedClass, maybeActualClass) =
            if(T::class.java.simpleName == maybeView?.javaClass?.simpleName) {
                T::class.java.canonicalName to maybeView?.javaClass?.canonicalName
            } else {
                T::class.java.simpleName to maybeView?.javaClass?.simpleName
            }
        val idNotFoundMessage = "View with id \"$idString\" was not found"
        val wrongClassMessage = "View with id \"$idString\" is not from expected class. " +
                "Expected $expectedClass found $maybeActualClass"

        assertNotNull(idNotFoundMessage, maybeView)
        assertTrue(wrongClassMessage, maybeView is T)

        return maybeView as T
    }

    /**
     * Use this method to find views.
     *
     * The view existence will be assert before being returned
     */
    inline fun <reified T> View.findViewByString(idString: String): T {
        val id = this.resources.getIdentifier(idString, "id", context.packageName)
        val maybeView: View? = this.findViewById(id)

        val (expectedClass, maybeActualClass) =
            if(T::class.java.simpleName == maybeView?.javaClass?.simpleName) {
                T::class.java.canonicalName to maybeView?.javaClass?.canonicalName
            } else {
                T::class.java.simpleName to maybeView?.javaClass?.simpleName
            }
        val idNotFoundMessage = "View with id \"$idString\" was not found"
        val wrongClassMessage = "View with id \"$idString\" is not from expected class. " +
                "Expected $expectedClass found $maybeActualClass"

        assertNotNull(idNotFoundMessage, maybeView)
        assertTrue(wrongClassMessage, maybeView is T)

        return maybeView as T
    }

    /**
     * Use this method to find views.
     *
     * Returns null if view is not found or unexpected class
     */
    inline fun <reified T> View.findViewByStringOrNull(idString: String): T? {
        val id = this.resources.getIdentifier(idString, "id", context.packageName)
        val view: View? = this.findViewById(id)
        return view as T?
    }

    /**
     * Use this method to perform clicks. It will also advance the clock millis milliseconds and run
     * enqueued Runnable scheduled to run on main looper in that timeframe.
     * Default value for millis is 500.
     *
     * Internally it calls performClick(), which might or might not increase clock time by itself
     * depending on the actions performed during click. If possible the amount of millis will
     * be corrected on the call to shadowLooper.idleFor(millis), but it is not possible to idleFor
     * negative values, which means it is not always possible to increase 0 millis.
     *
     * Returns the actual amount increased to help keep track of time elapsed.
     *
     */
    fun View.clickAndRun(millis: Long = 500): Int {
        val timeBeforeClick = SystemClock.currentGnssTimeClock().millis()
        this.performClick()
        val timeAfterClick = SystemClock.currentGnssTimeClock().millis()
        shadowLooper.idleFor(Duration.ofMillis(millis - (timeAfterClick - timeBeforeClick)))
        val timeAfterIdle = SystemClock.currentGnssTimeClock().millis()
        return (timeAfterIdle - timeBeforeClick).toInt()
    }

    /**
     * Use this method to perform long clicks. It will also advance the clock millis milliseconds and run
     * enqueued Runnable scheduled to run on main looper in that timeframe.
     * Default value for millis is 500
     *
     * Internally it calls performLongClick(), which might or might not increase clock time by itself
     * depending on the actions performed during click. If possible the amount of millis will
     * be corrected on the call to shadowLooper.idleFor(millis), but it is not possible to idleFor
     * negative values, which means it is not always possible to increase 0 millis.
     *
     * Returns the actual amount increased to help keep track of time elapsed.
     */
    fun View.clickLongAndRun(millis: Long = 500): Int {
        val timeBeforeClick = SystemClock.currentGnssTimeClock().millis()
        this.performLongClick()
        val timeAfterClick = SystemClock.currentGnssTimeClock().millis()
        shadowLooper.idleFor(Duration.ofMillis(millis - (timeAfterClick - timeBeforeClick)))
        val timeAfterIdle = SystemClock.currentGnssTimeClock().millis()
        return (timeAfterIdle - timeBeforeClick).toInt()
    }

    /**
     * Asserts that the last message toasted is the expectedMessage.
     * Assertion fails if no toast is shown with null actualLastMessage value.
     */
    fun assertLastToastMessageEquals(errorMessage: String, expectedMessage: String,) {
        val actualLastMessage: String? = ShadowToast.getTextOfLatestToast()
        Assert.assertEquals(errorMessage, expectedMessage, actualLastMessage)
    }

    /**
     * Use this method to set the progress as a user.
     *
     * Will trigger attached listeners.
     *
     * First onStartTrackingTouch(), then onProgressChanged() as user, and finally onStopTrackingTouch()
     */
    fun SeekBar.setProgressAsUser(progress: Int) {
        val shadowSeekBar = shadowOf(this)
        assertNotNull("Expected seekbar to have a onSeekBarChangeListener", shadowSeekBar.onSeekBarChangeListener)

        shadowSeekBar.onSeekBarChangeListener.onStartTrackingTouch(this)

        // using java reflection to change progress without triggering listener
        var clazz: Class<*> = this::class.java  // may be subclass of SeekBar
        while(clazz.name != "android.widget.ProgressBar") {  // since SeekBar is a subclass of ProgressBar this should not be an infinite loop
            clazz = clazz.superclass as Class<*>
        }
        val progressBarClazz = clazz
        val progressField = progressBarClazz.getDeclaredField("mProgress")
        progressField.isAccessible = true
        progressField.setInt(this, progress)
        //

        shadowSeekBar.onSeekBarChangeListener.onProgressChanged(this, progress, true)
        shadowSeekBar.onSeekBarChangeListener.onStopTrackingTouch(this)
    }

    /**
     * Use this method to make assertions on requisition of permissions
     *
     * @param permissionsRequired list of requiredPermission, ex: listOf(Manifest.permission.READ_EXTERNAL_STORAGE)
     * @param expectedRequestCode requestCode that test expect implementation to use in their code
     */
    fun assertRequestPermissions(permissionsRequired: List<String>, expectedRequestCode: Int = 1){

        val messageAnyPermissionRequest = "Have you asked any permissions?"
        val permissionRequest = shadowActivity.lastRequestedPermission ?: throw java.lang.AssertionError(
            messageAnyPermissionRequest
        )

        permissionsRequired.forEach { permissionRequired: String ->

            val messagePermissionRequired = "Have you asked permission $permissionRequired"

            val hasRequestedPermission =
                permissionRequest.requestedPermissions.any { it == permissionRequired }
            assert(hasRequestedPermission) { messagePermissionRequired }

            val actualRequestCode = permissionRequest.requestCode
            val messageWrongRequestCode =
                "Did you use the requestCode stated on description while requiring permissions?"
            Assert.assertEquals(messageWrongRequestCode, expectedRequestCode, actualRequestCode)
        }
    }

    /**
     * Use this method to perform clicks on menu items.
     *
     * It will assert the existence of the identifier. If the identifier exists but is not
     * a menu item then the assertion will succeed, but no click will be performed.
     *
     * Will also advance the clock millis milliseconds and run
     * enqueued Runnable scheduled to run on main looper in that timeframe.
     * Default value for millis is 500
     *
     */
    fun Activity.clickMenuItemAndRun(idString: String, millis: Long = 500): Int {
        val clock = SystemClock.currentGnssTimeClock()
        val timeBeforeClick = clock.millis()
        val identifier = resources.getIdentifier(idString, "id", packageName)

        assertTrue(
            "The identifier with idString \"$idString\" was not found",
            identifier != 0
        )

        shadowActivity.clickMenuItem(identifier)
        val timeAfterClick = clock.millis()

        shadowLooper.idleFor(Duration.ofMillis(millis- (timeAfterClick - timeBeforeClick)))
        val timeAfterIdle = clock.millis()
        return (timeAfterIdle - timeBeforeClick).toInt()
    }

    /**
     *  Retrieve last shown AlertDialog.
     *
     *  Will only find android.app.AlertDialog and not androidx.appcompat.app.AlertDialog
     *
     *  Returns the AlertDialog instance paired with its shadow
     */
    fun getLastAlertDialogWithShadow(errorMessageNotFound: String) : Pair<AlertDialog, ShadowAlertDialog> {
        val latestDialog:  AlertDialog? = ShadowAlertDialog.getLatestAlertDialog()

        assertNotNull("$errorMessageNotFound$ Make sure you are using android.app.AlertDialog", latestDialog)

        return latestDialog!! to Shadow.extract(latestDialog)
    }

    /**
     *  Makes assertions on the contents of the RecyclerView.
     *
     *  Asserts that the size matches the size of fakeResultList and then
     *  calls assertItems for each item of the list with the itemViewSupplier
     *  so that it is possible to make assertions on that itemView.
     *
     *  Take attention to refresh references to views coming from itemView since RecyclerView
     *  can change the instance of View for a determinate list item after an update to the list.
     */
    fun <T> RecyclerView.assertListItems(
        fakeResultList: List<T>,
        caseDescription: String = "",
        assertItems: (itemViewSupplier: () -> View, position: Int, item: T) -> Unit
    ) : Unit {

        assertNotNull("$caseDescription Your recycler view adapter should not be null", this.adapter)

        val expectedSize = fakeResultList.size

        val actualSize = this.adapter!!.itemCount
        Assert.assertEquals("$caseDescription Incorrect number of list items", expectedSize, actualSize)

        if(expectedSize == 0) {
            return
        } else if(expectedSize > 0) {
            val maxItemWidth = (0 until expectedSize)
                .asSequence()
                .mapNotNull { this.findViewHolderForAdapterPosition(it)?.itemView?.width }
                .maxOrNull()
                ?: throw AssertionError("$caseDescription No item is being displayed on RecyclerView, is it big enough to display one item?")
            val listWidth = maxItemWidth * (expectedSize + 1)

            val maxItemHeight = (0 until actualSize)
                .asSequence()
                .mapNotNull { this.findViewHolderForAdapterPosition(it)?.itemView?.height }
                .maxOrNull()
                ?: throw AssertionError("$caseDescription No item is being displayed on RecyclerView, is it big enough to display one item?")
            val listHeight = maxItemHeight * (actualSize + 1)
            this.layout(0,0, listHeight, listWidth)  // may increase clock time

            for((i, song) in fakeResultList.withIndex()) {

                val itemViewSupplier = {
                    this.layout(0,0, listHeight, listWidth)  // may increase clock time
                    scrollToPosition(i)
                    shadowLooper.idleFor(500, TimeUnit.MILLISECONDS)
                    findViewHolderForAdapterPosition(i)?.itemView
                        ?: throw AssertionError("$caseDescription Could not find list item with index $i")
                }
                assertItems(itemViewSupplier, i, song)
            }
        } else {
            throw IllegalStateException("size assertion was not effective")
        }
    }

    /**
     *  Makes assertions on the contents of the RecyclerView.
     *
     *  Asserts that the size matches the size of fakeResultList and then
     *  calls assertItems for each item of the list with the itemViewSupplier
     *  so that it is possible to make assertions on that itemView.
     *
     *  Take attention to refresh references to views coming from itemView since RecyclerView
     *  can change the instance of View for a determinate list item after an update to the list.
     *
     *  This version also includes elapsedTime on the callBack to help keep track of time
     *  since the clock might advance
     */
    fun <T> RecyclerView.assertListItems(
        fakeResultList: List<T>,
        caseDescription: String = "",
        assertItems: (itemViewSupplier: () -> View, position: Int, item: T, elapsedTime: Int) -> Unit
    ) : Unit {

        assertNotNull("$caseDescription Your recycler view adapter should not be null", this.adapter)

        val expectedSize = fakeResultList.size

        val actualSize = this.adapter!!.itemCount
        Assert.assertEquals("$caseDescription Incorrect number of list items", expectedSize, actualSize)

        if(expectedSize == 0) {
            return
        } else if(expectedSize > 0) {
            val maxItemWidth = (0 until expectedSize)
                .asSequence()
                .mapNotNull { this.findViewHolderForAdapterPosition(it)?.itemView?.width }
                .maxOrNull()
                ?: throw AssertionError("$caseDescription No item is being displayed on RecyclerView, is it big enough to display one item?")
            val listWidth = maxItemWidth * (expectedSize + 1)

            val maxItemHeight = (0 until actualSize)
                .asSequence()
                .mapNotNull { this.findViewHolderForAdapterPosition(it)?.itemView?.height }
                .maxOrNull()
                ?: throw AssertionError("$caseDescription No item is being displayed on RecyclerView, is it big enough to display one item?")
            val listHeight = maxItemHeight * (actualSize + 1)
            this.layout(0,0, listHeight, listWidth)  // may increase clock time

            for((i, song) in fakeResultList.withIndex()) {
                val timeBefore = SystemClock.currentGnssTimeClock().millis()
                // setting height to ensure that all items are inflated. Height might change after assertItems, keep statement inside loop.
                val itemViewSupplier = {
                    this.layout(0,0, listHeight, listWidth)  // may increase clock time
                    scrollToPosition(i)
                    shadowLooper.idleFor(500, TimeUnit.MILLISECONDS)
                    findViewHolderForAdapterPosition(i)?.itemView
                        ?: throw AssertionError("$caseDescription Could not find list item with index $i")
                }
                val timeAfter = SystemClock.currentGnssTimeClock().millis()
                assertItems(itemViewSupplier, i, song, (timeAfter -  timeBefore).toInt())
            }

        } else {
            throw IllegalStateException("size assertion was not effective")
        }
    }

    /**
     *  Makes assertions on the contents of one item of the RecyclerView.
     *
     *  Asserts that the the size of the list is at least itemIndex + 1.
     *
     *  Calls assertItem with the itemViewSupplier so that it is possible to make assertions on that itemView.
     *  Take attention to refresh references to views coming from itemView since RecyclerView
     *  can change the instance of View for a determinate list item after an update to the list.
     */
    fun RecyclerView.assertSingleListItem(
        itemIndex: Int,
        caseDescription: String = "",
        action: (itemViewSupplier: () -> View) -> Unit) {

        assertNotNull("$caseDescription Your recycler view adapter should not be null", this.adapter)

        val expectedMinSize = itemIndex + 1

        val actualSize = this.adapter!!.itemCount
        assertTrue(
            "$caseDescription RecyclerView was expected to contain item with index $itemIndex, but its size was $actualSize",
            actualSize >= expectedMinSize
        )

        if(actualSize >= expectedMinSize) {
            val maxItemWidth = (0 until actualSize)
                .asSequence()
                .mapNotNull { this.findViewHolderForAdapterPosition(it)?.itemView?.width }
                .maxOrNull()
                ?: throw AssertionError("$caseDescription No item is being displayed on RecyclerView, is it big enough to display one item?")
            val listWidth = maxItemWidth * (actualSize + 1)

            val maxItemHeight = (0 until actualSize)
                .asSequence()
                .mapNotNull { this.findViewHolderForAdapterPosition(it)?.itemView?.height }
                .maxOrNull()
                ?: throw AssertionError("$caseDescription No item is being displayed on RecyclerView, is it big enough to display one item?")
            val listHeight = maxItemHeight * (actualSize + 1)
            this.layout(0,0, listHeight, listWidth)  // may increase clock time

            val itemViewSupplier = {
                this.layout(0, 0, listWidth, listHeight)  // may increase clock time
                this.scrollToPosition(itemIndex)
                shadowLooper.idleFor(500, TimeUnit.MILLISECONDS)
                val itemView = (this.findViewHolderForAdapterPosition(itemIndex)?.itemView
                    ?: throw AssertionError("$caseDescription Could not find list item with index $itemIndex"))
                itemView
            }

            action(itemViewSupplier)

        } else {
            throw IllegalStateException("size assertion was not effective")
        }
    }
}