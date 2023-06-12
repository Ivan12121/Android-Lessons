package com.example.androidlessons

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.androidlessons.students.Students

val mapUsers = mutableMapOf<Int, String>()
val students = mutableListOf<Students>()

fun makeText(str: String, context: Context) {
    Toast.makeText(context, str, Toast.LENGTH_SHORT).show()
}