package com.example.androidlessons

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.androidlessons.calc.CalculateActivity
import com.example.androidlessons.conv.ConvertorActivity
import com.example.androidlessons.databinding.ActivityMainBinding
import com.example.androidlessons.register.EnterActivity
import com.example.androidlessons.students.AddStudentActivity
import com.example.androidlessons.students.BasicStudentsActivity
import com.example.androidlessons.textredact.TextActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnToCalc.setOnClickListener {
            startActivity(Intent(applicationContext, CalculateActivity::class.java))
        }

        binding.btnToReg.setOnClickListener {
            startActivity(Intent(applicationContext, EnterActivity::class.java))
        }

        binding.btnToConv.setOnClickListener {
            startActivity(Intent(applicationContext, ConvertorActivity::class.java))
        }

        binding.btnToRed.setOnClickListener {
            startActivity(Intent(applicationContext, TextActivity::class.java))
        }

        binding.btnToStud.setOnClickListener {
            startActivity(Intent(applicationContext, BasicStudentsActivity::class.java))
        }
    }
}