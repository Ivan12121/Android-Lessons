package com.example.androidlessons.register

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.androidlessons.databinding.ActivityEnterBinding
import com.example.androidlessons.makeText
import com.example.androidlessons.mapUsers
import com.example.androidlessons.realm.datahelpers.RegisterRealmManager

class EnterActivity : AppCompatActivity() {
    lateinit var binding: ActivityEnterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityEnterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val usermanager = RegisterRealmManager()

        binding.btnReg.setOnClickListener {
            startActivity(Intent(applicationContext, RegisterActivity::class.java))
        }
        binding.btnEnter.setOnClickListener {
            usermanager.getAllUsers?.forEach {
                if(binding.inputLoginEnter.text.toString() == it.login && binding.inputPassEnter.text.toString().toInt() == it.pass) {
                    val intent = Intent(applicationContext, CabinetActivity::class.java)
                    intent.putExtra("id", it.id)
                    startActivity(intent)
                }
                else makeText("Такого пользователя нет", applicationContext)
            }
        }
    }
}