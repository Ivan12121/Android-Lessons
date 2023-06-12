package com.example.androidlessons.register

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.androidlessons.databinding.ActivityRegisterBinding
import com.example.androidlessons.makeText
import com.example.androidlessons.realm.datahelpers.RegisterRealmManager
import com.example.androidlessons.realm.models.UsersModel

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var userManager = RegisterRealmManager()

        binding.btnLogin.setOnClickListener {
            if(binding.inputPassword.text.toString().toInt() != binding.confirmPassword.text.toString().toInt()) {
                makeText("Пароли не совпадают", applicationContext)
                binding.inputPassword.setText("")
                binding.confirmPassword.setText("")
            }
            else {
                var user = UsersModel(System.currentTimeMillis().toString(), binding.inputName.text.toString(), binding.inputPassword.text
                    .toString().toInt(), binding.inputLogin.text.toString(), binding.inputEmail.text
                    .toString())

                userManager.addUser(user)
                finish()

                val intent = Intent(applicationContext, CabinetActivity::class.java)
                intent.putExtra("id", user.id)
                startActivity(intent)
            }
        }
    }
}