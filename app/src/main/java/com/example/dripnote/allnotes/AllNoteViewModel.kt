package com.example.dripnote.allnotes

import android.util.Log
import androidx.lifecycle.ViewModel
import io.realm.Realm
import io.realm.RealmResults
import java.util.*

class AllNoteViewModel: ViewModel() {

    private var realm = Realm.getDefaultInstance()

    fun addNote(noteTitle: String, noteDetail: String) {

        try {
            realm.beginTransaction()
            val currentNoteId: Number? = realm.where(NoteModel::class.java).max("id")
            val nextNoteId: Int
            nextNoteId = if(currentNoteId == null) {
                1
            } else {
                currentNoteId.toInt() + 1
            }

            val note = NoteModel()
            note.id = nextNoteId
            note.title = noteTitle
            note.detail = noteDetail
            realm.copyToRealmOrUpdate(note)
            realm.commitTransaction()
        } catch (e: Exception) {
            Log.d("DripNote",e.toString())
        }
//        realm.executeTransaction { r: Realm ->
//            val note = r.createObject(NoteModel::class.java, UUID.randomUUID().toString())
//            note.title = noteTitle
//            note.detail = noteDetail
//            realm.insertOrUpdate(note)
//        }
    }
//
        fun getAllNotes(): RealmResults<NoteModel> {
            return realm.where(NoteModel::class.java).findAll()
        }
//    private fun getAllNotes(): MutableLiveData<List<NoteModel>> {
//        val list = MutableLiveData<List<NoteModel>>()
//        val notes = realm.where(NoteModel::class.java).findAll()
//        list.value = notes?.subList(0, notes.size)
//        return list
//    }
}