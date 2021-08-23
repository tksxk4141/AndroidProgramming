package com.example.hw6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.example.hw6.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var appbarc: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nhf = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        val topDest = setOf(R.id.homeFragment, R.id.page1Fragment, R.id.page2Fragment, R.id.myDialogFragment)

        appbarc = AppBarConfiguration(topDest, binding.drawerlayout)
        setupActionBarWithNavController(nhf.navController, appbarc)
        //binding.navigationview.setupWithNavController(nhf.navController)

        binding.navigationview.setNavigationItemSelectedListener {
            binding.drawerlayout.close()
            when (it.itemId){
                R.id.myDialogFragment->{
                    startActivity(Intent().setAction(Intent.ACTION_DIAL))
                    true
            }
                else->{
                    it.onNavDestinationSelected(nhf.navController)
            }
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.fragment).navigateUp(appbarc) || super.onSupportNavigateUp()
    }
}