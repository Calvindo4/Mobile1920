//PR: Language quiz or Choose Your Own Adventure (min: 2 endings, max: 4 endings)
package com.example.android.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout : DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        drawerLayout = binding.drawerLayout
        val navController = this.findNavController(R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        NavigationUI.setupWithNavController(binding.navView, navController)
        
        Timber.i("called onCreate")
    }
    
     override fun onDestroy() {
        super.onDestroy()

        Timber.i("called onDestroy")
    }

    override fun onStart() {
        super.onStart()

        Timber.i("called onStart")
    }

    override fun onRestart() {
        super.onRestart()

        Timber.i("called onRestart")
    }

    override fun onResume() {
        super.onResume()

        Timber.i("called onResume")
    }

    override fun onPause() {
        super.onPause()

        Timber.i("called onPause")
    }

    override fun onStop() {
        super.onStop()

        Timber.i("called onStop")
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host_fragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }
}
