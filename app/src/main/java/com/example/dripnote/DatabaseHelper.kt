package com.example.dripnote

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class DatabaseHelper: Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val configuration = RealmConfiguration.Builder()
            .name("DripNote.db")
            .schemaVersion(0)
            .build()

        Realm.setDefaultConfiguration(configuration)
    }
}