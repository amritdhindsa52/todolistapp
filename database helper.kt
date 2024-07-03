package com.example.todolist

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_NAME = "todo.db"
        const val DATABASE_VERSION = 1

        const val TABLE_NAME = "todos"
        const val COLUMN_ID = "id"
        const val COLUMN_TASK = "task"
        const val COLUMN_COMPLETED = "completed"

        private const val SQL_CREATE_ENTRIES =
            "CREATE TABLE $TABLE_NAME (" +
                    "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "$COLUMN_TASK TEXT," +
                    "$COLUMN_COMPLETED INTEGER)"

        private const val SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS $TABLE_NAME"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }
}
