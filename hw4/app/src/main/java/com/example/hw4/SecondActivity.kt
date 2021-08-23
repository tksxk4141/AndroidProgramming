package com.example.hw4

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.hw4.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    val TAG = "Lifecycle-Second"

    private lateinit var viewModel: MyVeiwModel
    private lateinit var secondbinding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        secondbinding= ActivitySecondBinding.inflate(layoutInflater)
        setContentView(secondbinding.root)

        Log.d(TAG,"onCreate")

        val v = intent?.getStringExtra("key")
        val tv=findViewById<TextView>(R.id.textView2)
        tv.text= v
        var num= (tv.text as String?)?.toInt()


        viewModel = ViewModelProvider(this).get(MyVeiwModel::class.java)
        viewModel.countLivedata.value=num
        secondbinding.button3.setOnClickListener {
            viewModel.increaseCount()
            secondbinding.textView2.text=(viewModel.countLivedata.value.toString())
        }
        secondbinding.button4.setOnClickListener {
            viewModel.decreaseCount()
            secondbinding.textView2.text=(viewModel.countLivedata.value.toString())
        }

    }

    override fun onBackPressed() {
        val tv = findViewById<TextView>(R.id.textView2)
        val resultIntent = Intent()
        resultIntent.putExtra("return", tv.text.toString())
        setResult(RESULT_OK, resultIntent)
        super.onBackPressed()
    }

     override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy")
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart")
    }
    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop")
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG,"onResume")
    }
    override fun onPause() {
        super.onPause()
        Log.d(TAG,"onPause")
    }
}