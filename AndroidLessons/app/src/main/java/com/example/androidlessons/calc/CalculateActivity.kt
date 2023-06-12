package com.example.androidlessons.calc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.androidlessons.databinding.ActivityCalculateBinding

class CalculateActivity : AppCompatActivity() {
    lateinit var binding: ActivityCalculateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCalculateBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var text = ""
        var result = 0
        var currentSymbol = ' '

        binding.btn1.setOnClickListener {
            text += "1"
            binding.mainText.setText(text)
        }
        binding.btn2.setOnClickListener {
            text += "2"
            binding.mainText.setText(text)
        }
        binding.btn3.setOnClickListener {
            text += "3"
            binding.mainText.setText(text)
        }
        binding.btn4.setOnClickListener {
            text += "4"
            binding.mainText.setText(text)
        }
        binding.btn5.setOnClickListener {
            text += "5"
            binding.mainText.setText(text)
        }
        binding.btn6.setOnClickListener {
            text += "6"
            binding.mainText.setText(text)
        }
        binding.btn7.setOnClickListener {
            text += "7"
            binding.mainText.setText(text)
        }
        binding.btn8.setOnClickListener {
            text += "8"
            binding.mainText.setText(text)
        }
        binding.btn9.setOnClickListener {
            text += "9"
            binding.mainText.setText(text)
        }
        binding.btn0.setOnClickListener {
            text += "0"
            binding.mainText.setText(text)
        }
        binding.btnClear.setOnClickListener {
            text = ""
            currentSymbol = ' '
            result = 0
            binding.mainText.setText("")
        }
        binding.btnPlus.setOnClickListener {
            if(text.isEmpty()) else result = text.toInt()
            currentSymbol = '+'
            text = ""
            binding.mainText.setText(text)
        }
        binding.btnMinus.setOnClickListener {
            if(text.isEmpty()) else result = text.toInt()
            currentSymbol = '-'
            text = ""
            binding.mainText.setText(text)
        }
        binding.btnMult.setOnClickListener {
            if(text.isEmpty()) else result = text.toInt()
            currentSymbol = '*'
            text = ""
            binding.mainText.setText(text)
        }
        binding.btnDel.setOnClickListener {
            if(text.isEmpty()) else result = text.toInt()
            currentSymbol = '/'
            text = ""
            binding.mainText.setText(text)
        }
        binding.btnPow.setOnClickListener {
            result = Math.pow(result.toDouble(), 2.0).toInt()
            binding.mainText.setText(result.toString())
        }
        binding.btnChangeSign.setOnClickListener {
            result *= -1
            binding.mainText.setText(result.toString())
        }
        binding.btnEq.setOnClickListener {

            binding.mainText.setText("")
            when(currentSymbol) {
                '+' -> {
                    result += text.toInt()
                }
                '-' -> {
                    result -= text.toInt()
                }
                '*' -> {
                    result *= text.toInt()
                }
                '/' -> {
                    result /= text.toInt()
                }
            }
            text = ""
            binding.mainText.setText(result.toString())
        }
    }
}