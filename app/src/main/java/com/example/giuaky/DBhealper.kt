package com.example.giuaky

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DBhealper(context: Context):SQLiteOpenHelper(context, "Userdata",null,1) {

    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("create table Userdata (email text primary key ,username text, password text )")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table if exists Userdata")
    }

    fun insertData(email: String, username: String, password: String): Boolean {
        val p0 = this.writableDatabase
        val cv = ContentValues()
        cv.put("email", email)
        cv.put("username", username)
        cv.put("password", password)
        val result = p0.insert("Userdata", null, cv)
        if (result == -1.toLong()) {
            return false
        }
        return true
    }

    fun checkuserpass(email: String, username: String, password: String): Boolean {
    val p0 = this.writableDatabase
        val query = "select * from Userdata where email = '$email' and username = '$username' and password ='$password' "
        val cursor = p0.rawQuery(query,null)
        if (cursor.count<=0){
            cursor.close()
            return false
        }
        cursor.close()
        return true
    }
    }