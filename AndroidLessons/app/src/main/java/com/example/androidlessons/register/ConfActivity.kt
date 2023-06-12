package com.example.androidlessons.register

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.androidlessons.databinding.ActivityConfBinding
import com.example.androidlessons.realm.datahelpers.RegisterRealmManager

class ConfActivity : AppCompatActivity() {
    lateinit var binding: ActivityConfBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityConfBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val userManager = RegisterRealmManager()

        val extras: Bundle? = getIntent().getExtras()
        val id = extras?.getString("id").toString()

        val user = userManager.getUser(id)

        binding.textLogin.setText(user?.login)
        binding.textPassword.setText(user?.pass.toString())

        binding.btnExitConf.setOnClickListener {
            val intent = Intent(applicationContext, CabinetActivity::class.java)
            intent.putExtra("id", id)
            startActivity(intent)
        }


    }
}