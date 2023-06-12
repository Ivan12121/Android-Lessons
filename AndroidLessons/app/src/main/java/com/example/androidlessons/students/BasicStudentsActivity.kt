package com.example.androidlessons.students

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.androidlessons.databinding.ActivityBasicStudentsBinding

class BasicStudentsActivity : AppCompatActivity() {
    lateinit var binding: ActivityBasicStudentsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityBasicStudentsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnToAddStudent.setOnClickListener {
            startActivity(Intent(applicationContext, AddStudentActivity::class.java))
        }

        binding.btnToCheckAllStudents.setOnClickListener {
            startActivity(Intent(applicationContext, AllStudentsActivity::class.java))
        }

        binding.btnToAddGradeStud.setOnClickListener {
            startActivity(Intent(applicationContext, AddGradesStudentActivity::class.java))
        }
    }
}