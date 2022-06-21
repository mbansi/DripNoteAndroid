package com.example.dripnote.home

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.dripnote.allnotes.AllNotesActivity
import com.example.dripnote.databinding.RowHomeBinding

class HomeAdapter(private val homeData: ArrayList<HomeModel>): RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    private lateinit var context: Context

    class ViewHolder(val binding: RowHomeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val binding =
            RowHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(homeData[position]) {
                binding.tvHomeTitle.text = title
                binding.tvHomeDescription.text = description

                binding.cvHome.setOnClickListener {
                    if (position == 0) {
                       val allNotesIntent = Intent(context,AllNotesActivity::class.java)
                        context.startActivity(allNotesIntent)
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return homeData.size
    }
}