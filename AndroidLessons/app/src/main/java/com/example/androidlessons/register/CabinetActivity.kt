package com.example.androidlessons.register

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.androidlessons.databinding.ActivityCabinetBinding
import com.example.androidlessons.realm.datahelpers.RegisterRealmManager

class CabinetActivity : AppCompatActivity() {
    lateinit var binding: ActivityCabinetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCabinetBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val userManager = RegisterRealmManager()

        val extras: Bundle? = getIntent().getExtras()
        val id = extras?.getString("id").toString()

        val user = userManager.getUser(id)

        binding.textNameUser.setText(user?.name)
        binding.textEmailUser.setText(user?.email)

        binding.btnExit.setOnClickListener {
            startActivity(Intent(applicationContext, EnterActivity::class.java))
        }
        binding.btnSettings.setOnClickListener {
            val intent = Intent(applicationContext, SettingsActivity::class.java)
            intent.putExtra("id", id)
            startActivity(intent)
        }
        binding.btnConf.setOnClickListener {
            val intent = Intent(applicationContext, ConfActivity::class.java)
            intent.putExtra("id", id)
            startActivity(intent)
        }
    }
}