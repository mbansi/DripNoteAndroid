package com.example.dripnote.login

import android.os.Bundle
import com.example.dripnote.BaseActivity
import com.example.dripnote.databinding.ActivityLoginBinding

class LoginActivity: BaseActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.hide()
    }
}