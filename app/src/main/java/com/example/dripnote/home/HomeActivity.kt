package com.example.dripnote.home

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dripnote.BaseActivity
import com.example.dripnote.databinding.ActivityHomeBinding

class HomeActivity: BaseActivity() {

   private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.hide()
        setAdapterData()
    }

    private fun setAdapterData() {
        val homeAdapter = HomeAdapter(getHomeData())
        val layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.rvHome.layoutManager = layoutManager
        binding.rvHome.adapter = homeAdapter
    }

    private fun getHomeData(): ArrayList<HomeModel> {
        val data = ArrayList<HomeModel>()
        data.add(HomeModel("NOTES","View and edit 64 notes here."))
        data.add(HomeModel("BUCKETS","View and edit 37 buckets here."))
        data.add(HomeModel("FOLDERS","View and edit 11 folders here."))
        return data
    }
}