package com.example.dripnote.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dripnote.databinding.RowHomeBinding

class HomeAdapter(private val homeData: ArrayList<HomeModel>): RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    class ViewHolder(val binding: RowHomeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
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
                        Log.d("DripNote","Notes")
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return homeData.size
    }
}