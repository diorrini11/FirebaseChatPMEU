package com.example.firebasechatpmeu

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (FirebaseAuth.getInstance().currentUser != null) {
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        }
        else {
            startActivity(Intent(this@SplashActivity, SignInActivity::class.java))
        }
        finish()
    }
}