package com.example.androidlessons.realm.models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class UsersModel(@PrimaryKey var id: String = "", var name: String = "", var pass: Int = 0, var login: String = "", var email: String = ""): RealmObject() {
}