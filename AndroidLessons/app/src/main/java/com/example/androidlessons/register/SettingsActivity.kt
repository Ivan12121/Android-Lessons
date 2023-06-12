package com.example.androidlessons.register

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.androidlessons.databinding.ActivitySettingsBinding
import com.example.androidlessons.makeText
import com.example.androidlessons.realm.datahelpers.RegisterRealmManager
import com.example.androidlessons.realm.models.UsersModel
import kotlin.math.log

class SettingsActivity : AppCompatActivity() {
    lateinit var binding: ActivitySettingsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val userManager = RegisterRealmManager()

        val extras: Bundle? = getIntent().getExtras()
        val id = extras?.getString("id").toString()

        val user = userManager.getUser(id)

        binding.btnChangePassword.setOnClickListener {
            if(binding.inputOldPassword.text.toString().toInt() != user?.pass) {
                makeText("Пароль неверен", applicationContext)
            }
            else {
                val newUser = UsersModel(id, user.name, binding.inputNewPassword.text.toString().toInt(), user.login, user.email)
                userManager.addUser(newUser)
                finish()
            }
        }

        binding.btnDeleteAcc.setOnClickListener {
            userManager.deleteUser(id)
            makeText("Аккаунт успешно удален", applicationContext)
            startActivity(Intent(applicationContext, EnterActivity::class.java))
        }

        binding.btnChangeAll.setOnClickListener {
            val name = binding.inputNewName.text.toString()
            val email = binding.inputNewEmail.text.toString()
            val login = binding.inputNewLogin.text.toString()

            if(!name.isEmpty() && !email.isEmpty() && !login.isEmpty() ) {
                val newUser = user?.pass?.let { it1 -> UsersModel(id, name, it1, login, email) }
                if (newUser != null) {
                    userManager.addUser(newUser)
                }
                finish()
            }
            else if(name.isEmpty() && !email.isEmpty() && !login.isEmpty()) {
                val newUser = user?.let { it1 -> UsersModel(id, it1.name, user.pass, login, email) }
                if (newUser != null) {
                    userManager.addUser(newUser)
                }
                finish()
            }
            else if(name.isEmpty() && email.isEmpty() && !login.isEmpty()) {
                val newUser = user?.let { it1 -> UsersModel(id, it1.name, user.pass, login, user.email) }
                if (newUser != null) {
                    userManager.addUser(newUser)
                }
                finish()
            }
            else if(name.isEmpty() && !email.isEmpty() && login.isEmpty()) {
                val newUser = user?.let { it1 -> UsersModel(id, it1.name, user.pass, user.login, email) }
                if (newUser != null) {
                    userManager.addUser(newUser)
                }
                finish()
            }
            else if(!name.isEmpty() && email.isEmpty() && login.isEmpty()) {
                val newUser = user?.let { it1 -> UsersModel(id, name, user.pass, it1.login, user.email) }
                if (newUser != null) {
                    userManager.addUser(newUser)
                }
                finish()
            }
            else if(!name.isEmpty() && email.isEmpty() && !login.isEmpty()) {
                val newUser = user?.let { it1 -> UsersModel(id, name, it1.pass, login, user.email) }
                if (newUser != null) {
                    userManager.addUser(newUser)
                }
                finish()
            }
            else if(!name.isEmpty() && !email.isEmpty() && login.isEmpty()) {
                val newUser = user?.let { it1 -> UsersModel(id, name, it1.pass, user.login, email) }
                if (newUser != null) {
                    userManager.addUser(newUser)
                }
                finish()
            }
        }
    }
}