package com.example.analayzermobile.data.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

object LocationSqliteContract {
    object LocationEntry : BaseColumns {
        const val TABLE_NAME = "location"
        const val COLUMN_NAME_LOCATION = "location_name"
        const val COLUMN_NAME_DESCRIPTION = "location_description"
        const val COLUMN_NAME_IMAGE = "location_image"
        const val COLUMN_NAME_PRICE = "price"
    }
}

private const val DATABASE_NAME = "Location.db"
private const val DATABASE_VERSION = 1

class LocationDbHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    companion object {
        private const val DATABASE_NAME = "Location.db"
        private const val DATABASE_VERSION = 1
        private const val SQL_CREATE_ENTRIES =
            "CREATE TABLE ${LocationSqliteContract.LocationEntry.TABLE_NAME} (" +
                    "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                    "${LocationSqliteContract.LocationEntry.COLUMN_NAME_LOCATION} TEXT," +
                    "${LocationSqliteContract.LocationEntry.COLUMN_NAME_DESCRIPTION} TEXT," +
                    "${LocationSqliteContract.LocationEntry.COLUMN_NAME_IMAGE} INTEGER," +
                    "${LocationSqliteContract.LocationEntry.COLUMN_NAME_PRICE} INTEGER)"
        private const val SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS ${LocationSqliteContract.LocationEntry.TABLE_NAME}"
    }
}