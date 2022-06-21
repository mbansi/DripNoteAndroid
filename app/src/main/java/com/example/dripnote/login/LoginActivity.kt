package com.example.dripnote.login

import android.content.Intent
import android.os.Bundle
import com.example.dripnote.BaseActivity
import com.example.dripnote.databinding.ActivityLoginBinding
import com.example.dripnote.home.HomeActivity

class LoginActivity: BaseActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        clickListeners()
        supportActionBar?.hide()
    }

    private fun clickListeners() {
        binding.btnLogin.setOnClickListener {
            val homeIntent = Intent(this,HomeActivity::class.java)
            startActivity(homeIntent)
            finish()
        }
    }
}