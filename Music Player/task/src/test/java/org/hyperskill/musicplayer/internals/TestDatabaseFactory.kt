package org.hyperskill.musicplayer.internals

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// version 2.0
/**
 * Use this class to get a testing database.
 *
 * example use-cases:
 * TestDatabaseFactory().writableDatabase.use {...}, for setting up a state before launching
 * the activity to test restoring of existing data by this activity.
 *
 * TestDatabaseFactory().readableDatabase.use {...}, for testing if data is is being saved
 *
 */
class TestDatabaseFactory(
    context: Context?,
    name: String? = "musicPlayerDatabase.db",
    factory: SQLiteDatabase.CursorFactory? = null,
    version: Int = 1
) : SQLiteOpenHelper(context, name, factory, version) {
    var onCreateCalled = false
    var onUpgradeCalled = false
    var onOpenCalled = false

    override fun onCreate(database: SQLiteDatabase) {
        onCreateCalled = true
    }

    override fun onUpgrade(database: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgradeCalled = true
    }

    override fun onOpen(database: SQLiteDatabase) {
        onOpenCalled = true
    }

    @Synchronized
    override fun close() {
        onCreateCalled = false
        onUpgradeCalled = false
        onOpenCalled = false
        super.close()
    }
}