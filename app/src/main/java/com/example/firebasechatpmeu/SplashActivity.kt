package com.example.firebasechatpmeu

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var intent: Intent

        if (FirebaseAuth.getInstance().currentUser != null) {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        else {
            intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
        finish()
    }
}