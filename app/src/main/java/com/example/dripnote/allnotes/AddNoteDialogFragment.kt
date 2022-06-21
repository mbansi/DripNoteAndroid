package com.example.dripnote.allnotes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dripnote.R
import com.example.dripnote.databinding.ActivityAllNotesBinding
import com.example.dripnote.databinding.BottomSheetAddNoteBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AddNoteDialogFragment: BottomSheetDialogFragment() {

    private lateinit var binding: BottomSheetAddNoteBinding
    private lateinit var viewModel: AllNoteViewModel

    companion object {
        const val TAG = "AddNoteDialog"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BottomSheetAddNoteBinding.inflate(inflater, container, false)
        viewModel = AllNoteViewModel()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivSaveNote.setOnClickListener {
            Log.d("DripNote","Added")

            viewModel.addNote(binding.etNote.text.toString(),binding.etNote.text.toString())
        }
    }
}