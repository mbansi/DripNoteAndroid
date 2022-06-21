package com.example.dripnote.allnotes

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

//data class NoteModel(
//    @PrimaryKey var id: String,
//    @Required var title: String,
//    @Required var detail: String,
//    var favorite: Boolean
//) : RealmObject()

open class NoteModel (
    @PrimaryKey var id: Int? = null,
    var title: String? = null,
    var detail: String? = null
): RealmObject()