package com.example.eastagile.themoviedatabase.presenter

import com.google.firebase.auth.FirebaseAuth

class AuthenticatePresenterImpl : AuthenticatePresenter {

    private var mAuth: FirebaseAuth

    init {
        mAuth = FirebaseAuth.getInstance()
    }

    override fun signIn(email: String, password: String) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        // Todo update UI
                    } else {
                        // If sign in fails, display a message to the user.
                        // Todo show error
                    }

                    // ...
                }
    }

    override fun signUp(email: String, password: String) {
        if (null == mAuth.currentUser) {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            // Sign up success, update UI with the signed-in user's information
                            // Todo update UI...
                        } else {
                            // If sign up fails, display a message to the user.
                            // Todo display message
                        }
                    }
        }

    }

    override fun setNewPassword(newPassword: String) {

    }

    override fun sendPasswordResetEmail(emailAdress: String) {
        mAuth.sendPasswordResetEmail(emailAdress)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Todo when complete send
                    }
                }
    }

}
