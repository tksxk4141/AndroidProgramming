package com.example.hw9

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import com.example.hw9.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonDoService.isEnabled=false
        binding.buttonUnBind.isEnabled=false
        binding.buttonBind.isEnabled=true

        binding.buttonBind.setOnClickListener{
            Intent(this,MyService::class.java).also{
                bindService(it,serviceConnection, BIND_AUTO_CREATE)
            }
        }

        binding.buttonDoService.setOnClickListener{
            myService?.doService("Hello")
        }

        binding.buttonUnBind.setOnClickListener{
            unbindService(serviceConnection)
            myService=null
            binding.buttonDoService.isEnabled=false
            binding.buttonUnBind.isEnabled=false
            binding.buttonBind.isEnabled=true
        }
    }

    private var myService: MyService?=null

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
           myService=(service as MyService.LocalBinder).getService()
            binding.buttonDoService.isEnabled=true
            binding.buttonUnBind.isEnabled=true
            binding.buttonBind.isEnabled=false
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            myService=null
        }
    }

}