package com.example.hw9

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import kotlinx.coroutines.*

class MyService : Service() {
    private val binder = LocalBinder()

    inner class LocalBinder : Binder() {
        fun getService()=this@MyService
    }

    override fun onBind(intent: Intent): IBinder {
        println("Service onCreate")
        return binder
    }

    fun doService(param: String){
      println("do service $param")
    }

    override fun onDestroy() {
        println("Service onDestroy")
        super.onDestroy()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }
}