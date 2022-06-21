package com.example.dripnote.allnotes

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dripnote.databinding.RowAllNotesBinding
import io.realm.RealmResults

class AllNotesAdapter(private val notesList: RealmResults<NoteModel>): RecyclerView.Adapter<AllNotesAdapter.ViewHolder>() {

    private lateinit var context: Context
    class ViewHolder(val binding: RowAllNotesBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val binding = RowAllNotesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(notesList[position]) {
                binding.tvNoteTitle.text = this?.title ?: "No title"
                binding.tvNoteDetail.text = this?.detail ?: "No detail"
            }
        }
    }

    override fun getItemCount(): Int {
        return notesList.size
    }
}