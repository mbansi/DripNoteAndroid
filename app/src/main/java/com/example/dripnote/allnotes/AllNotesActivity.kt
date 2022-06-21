package com.example.dripnote.allnotes

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dripnote.BaseActivity
import com.example.dripnote.R
import com.example.dripnote.databinding.ActivityAllNotesBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class AllNotesActivity: BaseActivity() {

    private lateinit var binding: ActivityAllNotesBinding
    private lateinit var viewModel: AllNoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAllNotesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        viewModel = AllNoteViewModel()
        supportActionBar?.hide()
        setTabLayout()
        clickListeners()
    }

    private fun clickListeners() {
        binding.fabAdd.setOnClickListener {
            AddNoteDialogFragment().apply {
                show(supportFragmentManager,AddNoteDialogFragment.TAG)
            }
        }
    }

    private fun setTabLayout() {
        val allNotesAdapter = AllNotesAdapter(viewModel.getAllNotes())
        binding.rvNotes.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        binding.rvNotes.adapter = allNotesAdapter
    }

}