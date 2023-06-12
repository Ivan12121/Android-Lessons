package com.example.androidlessons.textredact

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.EditText
import android.widget.TextView
import com.example.androidlessons.databinding.ActivityTextBinding

class TextActivity : AppCompatActivity() {
    lateinit var binding: ActivityTextBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityTextBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        updateTextView()

        var memory = ""
        binding.btnSave.setOnClickListener {
            memory = binding.inputText.text.toString()
        }
        binding.btnLoad.setOnClickListener {
            binding.inputText.setText(memory)
        }
        binding.btnTextClear.setOnClickListener {
            binding.inputText.setText("")
        }
        binding.btnMemoryClear.setOnClickListener {
            memory = ""
        }
    }

    private fun updateTextView() {
        object : CountDownTimer(100, 100) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                val list = binding.inputText.text.toString().split(' ')
                binding.textSymbol.setText(binding.inputText.text.toString().length.toString())
                binding.textWords.setText(list.size.toString())
                start()
            }
        }.start()
    }
}