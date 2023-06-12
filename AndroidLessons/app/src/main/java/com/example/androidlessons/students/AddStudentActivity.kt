package com.example.androidlessons.students

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.androidlessons.databinding.ActivityAddStudentBinding
import com.example.androidlessons.students

class AddStudentActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddStudentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAddStudentBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.btnAddStud.setOnClickListener {
            val student = Students(binding.inputId.text.toString().toInt(), binding.inputNameStud.text.toString(), binding.inputSurnameStud.text.toString(), binding.inputClassStud.text.toString().toInt(), binding.inputAgeStud.text.toString().toInt())
            students.add(student)
        }
        binding.btnCheckStud.setOnClickListener {
            binding.viewStudents.setText(students.size.toString())
        }

        binding.btnToHome.setOnClickListener {
            startActivity(Intent(applicationContext, BasicStudentsActivity::class.java))
        }

    }
}