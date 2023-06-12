package com.example.androidlessons.realm.datahelpers

import com.example.androidlessons.realm.models.UsersModel
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmResults

class RegisterRealmManager {

    private val config: RealmConfiguration = RealmConfiguration.Builder().name("Registration.realm")
        .deleteRealmIfMigrationNeeded().schemaVersion(1).build()

    fun addUser(user: UsersModel) {
        val realm = Realm.getInstance(config)
        realm.beginTransaction()
        user.let { realm.insertOrUpdate(it) }
        realm.commitTransaction()
        realm.close()
    }

    val getAllUsers: RealmResults<UsersModel>?
        get() = Realm.getInstance(config).where(UsersModel::class.java).findAll()

    fun getUser(id: String): UsersModel? {
        return Realm.getInstance(config).where(UsersModel::class.java).equalTo("id", id).findFirst()
    }

    fun deleteUser(id: String) {
        val realm = Realm.getInstance(config)
        val itemRealmObject: UsersModel? = realm.where(UsersModel::class.java).equalTo("id", id).findFirst()
        if(itemRealmObject != null) {
            realm.beginTransaction()
            itemRealmObject.deleteFromRealm()
            realm.commitTransaction()
            realm.close()
        }
    }
}