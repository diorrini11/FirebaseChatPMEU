package com.example.firebasechatpmeu.service

import com.google.firebase.auth.FirebaseAuth
import com.example.firebasechatpmeu.util.FirestoreUtil
import com.google.firebase.installations.FirebaseInstallations
import com.google.firebase.messaging.FirebaseMessaging


class MyFirebaseInstanceIDService : FirebaseInstallations() {

    fun onTokenRefresh() {
        val newRegistrationToken = FirebaseMessaging.getInstance().token

        if (FirebaseAuth.getInstance().currentUser != null)
            addTokenToFirestore(newRegistrationToken.toString())
    }

    companion object {
        fun addTokenToFirestore(newRegistrationToken: String?) {
            if (newRegistrationToken == null) throw NullPointerException("FCM token is null.")

            FirestoreUtil.getFCMRegistrationTokens { tokens ->
                if (tokens.contains(newRegistrationToken))
                    return@getFCMRegistrationTokens

                tokens.add(newRegistrationToken)
                FirestoreUtil.setFCMRegistrationTokens(tokens)
            }
        }
    }
}