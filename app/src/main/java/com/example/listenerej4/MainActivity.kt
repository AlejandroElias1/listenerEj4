package com.example.listenerej4

import android.app.Activity
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.annotation.RequiresApi
import com.example.listenerej4.databinding.ActivityMainBinding
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var contador= 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mas.setOnClickListener {
            suma()
            binding.textView.text = contador.toString()
        }
        binding.menos.setOnClickListener {
            resta()
            binding.textView.text = contador.toString()
        }
        num()
        cambiarColor()
    }

    fun cambiarColor() {
        super.onResume()
        binding.editTextNumber.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                binding.mas.setBackgroundColor(Color.parseColor("#FF0000"))
                binding.menos.setBackgroundColor(Color.parseColor("#FF0000"))
            } else {
                binding.mas.setBackgroundColor(Color.parseColor("#0f3ec4"))
                binding.menos.setBackgroundColor(Color.parseColor("#0f3ec4"))
            }
        }
    }
    fun suma(){
        contador++
        binding.textView.text = contador.toString()
    }
    fun resta(){
        if (contador > 0){
            contador--
            binding.textView.text = contador.toString()
        }
    }
    fun num(){
        binding.editTextNumber.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                binding.textView.text = binding.editTextNumber.text
                if (binding.textView.text.length==0){
                    binding.textView.text = "0"
                }

            }
        })
    }
}