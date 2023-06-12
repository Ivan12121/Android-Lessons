package com.example.androidlessons.students

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.androidlessons.databinding.ActivityAddGradesStudentBinding
import com.example.androidlessons.databinding.ActivityBasicStudentsBinding
import com.example.androidlessons.students

class AddGradesStudentActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddGradesStudentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAddGradesStudentBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnToHomeGrade.setOnClickListener {
            startActivity(
                Intent(applicationContext, BasicStudentsActivity::class.java)
            )
        }

        binding.btnAddGradeStud.setOnClickListener {
            val subject = binding.inputStudentSubject.text.toString()
            students.forEach {
                if(it.id == binding.inputStudentId.text.toString().toInt()) {
                    when(subject) {
                        "GEO" -> {
                            it.gradesGeo.add(binding.inputGrade.text.toString().toInt())
                        }
                        "MATH" -> {
                            it.gradesMath.add(binding.inputGrade.text.toString().toInt())
                        }
                        "RUS" -> {
                            it.gradesRus.add(binding.inputGrade.text.toString().toInt())
                        }
                    }
                }
            }
        }

        binding.btnCheckAvg.setOnClickListener {
            var avg: Double
            var avgGeo = 0
            var avgMath = 0
            var avgRus = 0
            students.forEach {
                if(it.id == binding.inputStudentId.text.toString().toInt()) {
                    it.gradesGeo.forEach {
                        avgGeo += it
                    }
                    it.gradesMath.forEach {
                        avgMath += it
                    }
                    it.gradesRus.forEach {
                        avgRus += it
                    }
                }
                if(it.gradesGeo.size != 0) {
                    avgGeo /= it.gradesGeo.size
                }
                else if(it.gradesMath.size != 0) {
                    avgMath /= it.gradesMath.size
                }
                else if(it.gradesRus.size != 0) {
                    avgRus /= it.gradesRus.size
                }
            }
            avg = ((avgGeo + avgMath + avgRus) / 3).toDouble()
            binding.textAvg.setText(avg.toString())
        }


        binding.btnAvgGeo.setOnClickListener {
            var avg: Double = 0.0
            students.forEach {
                if(it.id == binding.inputStudentId.text.toString().toInt()) {
                    it.gradesGeo.forEach {
                        avg += it
                    }
                    avg /= it.gradesGeo.size
                }
            }
            binding.textAvg.setText(avg.toString())
        }

        binding.btnAvgMath.setOnClickListener {
            var avg: Double = 0.0
            students.forEach {
                if(it.id == binding.inputStudentId.text.toString().toInt()) {
                    it.gradesMath.forEach {
                        avg += it
                    }
                    avg /= it.gradesMath.size
                }
            }
            binding.textAvg.setText(avg.toString())
        }

        binding.btnAvgRus.setOnClickListener {
            var avg: Double = 0.0
            students.forEach {
                if(it.id == binding.inputStudentId.text.toString().toInt()) {
                    it.gradesRus.forEach {
                        avg += it
                    }
                    avg /= it.gradesRus.size
                }
            }
            binding.textAvg.setText(avg.toString())
        }
    }
}