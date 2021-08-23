package com.example.hw8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.Settings.Global.putString
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.edit
import androidx.preference.PreferenceManager
import org.w3c.dom.Text
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val s = pref.getString("signature","")
        println(s)

        val pref2 = getSharedPreferences("MyPref",0)
        val n = pref2.getString("name","")
        println(n)

        val f = File(filesDir,"test.txt")
        println(f.absolutePath)
        val r = f.readText()
        println(r)
        if(Environment.getExternalStorageState()==Environment.MEDIA_MOUNTED) {
            val f2 = File(getExternalFilesDir(null), "test.txt")
            println(f2.absolutePath)
            val r2 = f2.readText()
            println(r2)
        }
        */

        displaySettings()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       when(item.itemId){
           R.id.settings->startActivity(Intent(this,SettingsActivity::class.java))
           else->super.onOptionsItemSelected(item)
       }
        return true
    }

    private fun displaySettings() {
        val settings = PreferenceManager.getDefaultSharedPreferences(this)
        val signature = settings.getString("signature", "")
        val reply = settings.getString("reply", "")
        val sync = settings.getBoolean("sync", false)
        val attachment = settings.getBoolean("attachment", false)
        val str = """signature: $signature
                     reply: $reply
                     sync: $sync
                     attachment: $attachment"""
        var tv = findViewById<TextView>(R.id.textview)
        tv.text=str
    }
}

