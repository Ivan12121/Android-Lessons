package com.example.androidlessons.students

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.androidlessons.R
import com.example.androidlessons.databinding.ActivityAllStudentsBinding
import com.example.androidlessons.students

class AllStudentsActivity : AppCompatActivity() {
    lateinit var binding: ActivityAllStudentsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAllStudentsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val listStudentsName = mutableListOf<String>()
        students.forEach {
            listStudentsName.add(it.name)
        }

        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listStudentsName)
        binding.listView.adapter = arrayAdapter
    }
}