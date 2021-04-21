package com.tda.facsitio.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.tda.facsitio.R
import com.tda.facsitio.ui.MainActivity
import com.tda.facsitio.utils.MyPreferencesUtil
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var preferences: MyPreferencesUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        preferences = MyPreferencesUtil(this)
        if(preferences.loadDarkModeState())
            setTheme(R.style.DarkTheme)
        else
            setTheme(R.style.Theme_Facsitio)
        setContentView(R.layout.activity_login)

        this.supportActionBar?.hide()

        btnLogin.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}