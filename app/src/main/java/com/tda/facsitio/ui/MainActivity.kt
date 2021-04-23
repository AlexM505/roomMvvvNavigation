package com.tda.facsitio.ui

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.tda.facsitio.R
import com.tda.facsitio.utils.MyPreferencesUtil
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var preferences: MyPreferencesUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        preferences = MyPreferencesUtil(this)
        if(preferences.loadDarkModeState())
            setTheme(R.style.DarkTheme)
        else
            setTheme(R.style.Theme_Facsitio)
        setContentView(R.layout.activity_main)

        //supportActionBar?.hide()
        
        navController = findNavController(R.id.nav_host_fragment)

        val appBarConfiguration = AppBarConfiguration(setOf(R.id.navigation_workItinerary, R.id.navigation_setting))
        setupActionBarWithNavController(navController, appBarConfiguration)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_bottom_bar,menu)
        bottomNavView.setupWithNavController(menu!!,navController)
        return false
    }

    override fun onSupportNavigateUp(): Boolean {
        navController.navigateUp()
        return true
    }
}