package com.example.firebasechatpmeu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<BottomNavigationView>(R.id.nav_view).setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_people -> {
                    //TODO: Show people fragment
                    true
                }
                R.id.navigation_my_account -> {
                    //TODO: Show my account fragment
                    true
                }
                else -> false
            }
        }
    }
}