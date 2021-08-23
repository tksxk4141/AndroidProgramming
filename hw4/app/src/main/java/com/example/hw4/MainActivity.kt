package com.example.hw4

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.hw4.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    open class Parent(val name: String){
        open fun hello()=""
    }
    class Child: Parent(""){
        override fun hello()="hello"
    }
    fun main(){
        val c=Child()
        c.hello()
    }

    val TAG = "Lifecycle-Main"

    private lateinit var viewModel: MyVeiwModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG,"onCreate")
        val et = findViewById<TextView>(R.id.editTextNumber)

        binding.button.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("key","${et.text}")
            startActivityForResult(intent,1)
        }

        binding.button2.setOnClickListener {
            val implicitIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:114"))
            startActivity(implicitIntent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==1){
            val msg = data?.getStringExtra("return") ?: ""
            Snackbar.make(binding.root,"ActivityResult:$resultCode $msg",Snackbar.LENGTH_SHORT).show()
        }
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