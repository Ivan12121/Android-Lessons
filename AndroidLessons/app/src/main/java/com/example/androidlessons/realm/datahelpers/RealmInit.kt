package com.example.androidlessons.realm.datahelpers

import android.app.Application
import io.realm.Realm

class RealmInit: Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}