package uz.umarov.sqliteproject1

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDbHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION),
    DbService {

    companion object {
        const val DB_NAME = "Register.db"
        const val DB_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val query =
            "CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT,username TEXT, password TEXT)"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
    }

    override fun insertUser(username: String, password: String) {
        val db = writableDatabase
        val cv = ContentValues()
        cv.put("username", username)
        cv.put("password", password)
        db.insert("users", null, cv)
        db.close()

    }

    override fun readUser(username: String, password: String): Boolean {
        val db = readableDatabase
        val columns = arrayOf("id")
        val selection = "username = ? AND password = ?"
        val selectionArgs = arrayOf(username, password)
        val cursor = db.query("users", columns, selection, selectionArgs, null, null, null)

        val userExists = cursor.moveToFirst()
        cursor.close()
        return userExists
    }
}