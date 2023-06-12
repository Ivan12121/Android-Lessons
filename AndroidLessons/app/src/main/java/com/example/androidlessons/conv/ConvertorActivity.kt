package com.example.androidlessons.conv

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.androidlessons.R
import com.example.androidlessons.databinding.ActivityConvertorBinding

class ConvertorActivity : AppCompatActivity() {
    lateinit var binding: ActivityConvertorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityConvertorBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.radioGroup.setOnCheckedChangeListener { _, chekedId ->
            when(chekedId) {
                R.id.rbtn_meters -> {
                    binding.inputMeters.text = binding.inputContent.text.toString()
                    binding.inputInch.text = (binding.inputContent.text.toString().toDouble() * 39).toString()
                    binding.inputMeel.text = (binding.inputContent.text.toString().toDouble() / 1609).toString()
                    binding.inputFoot.text = (binding.inputContent.text.toString().toInt() * 3).toString()
                }
                R.id.rbtn_foot -> {
                    binding.inputMeters.text = (binding.inputContent.text.toString().toDouble() / 3).toString()
                    binding.inputInch.text = (binding.inputContent.text.toString().toDouble() * 12).toString()
                    binding.inputMeel.text = (binding.inputContent.text.toString().toDouble() / 5280).toString()
                    binding.inputFoot.text = binding.inputContent.text.toString()
                }
                R.id.rbtn_meel -> {
                    binding.inputMeters.text = (binding.inputContent.text.toString().toDouble() * 1609).toString()
                    binding.inputInch.text = (binding.inputContent.text.toString().toDouble() * 63360).toString()
                    binding.inputMeel.text = binding.inputContent.text.toString()
                    binding.inputFoot.text = (binding.inputContent.text.toString().toDouble() * 5280).toString()
                }
                R.id.rbtn_inch -> {
                    binding.inputMeters.text = (binding.inputContent.text.toString().toDouble() / 39).toString()
                    binding.inputInch.text = binding.inputContent.text.toString()
                    binding.inputMeel.text = (binding.inputContent.text.toString().toDouble() / 63360).toString()
                    binding.inputFoot.text = (binding.inputContent.text.toString().toDouble() / 12).toString()
                }
            }
        }
    }
}