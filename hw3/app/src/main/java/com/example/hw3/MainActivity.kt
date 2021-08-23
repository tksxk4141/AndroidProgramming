package com.example.hw3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hw3.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            binding.textView2.text=binding.editTextTextPersonName.text
            val dog: String = getString(R.string.Dog)
            val cat: String = getString(R.string.Cat)
            val pet = "$dog: ${binding.radioDog.isChecked},$cat:${binding.radioCat.isChecked}"

            Snackbar.make(it,pet,Snackbar.LENGTH_SHORT).show()

            when (binding.radioGroup.checkedRadioButtonId){
                R.id.radioDog->println("Dog checked")
                R.id.radioCat->println("Cat checked")
            }
        }
    }
}