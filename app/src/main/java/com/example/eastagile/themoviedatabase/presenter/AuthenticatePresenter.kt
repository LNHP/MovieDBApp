package com.example.eastagile.themoviedatabase.presenter

interface AuthenticatePresenter {

    fun signIn(email: String, password: String)
    fun signUp(email: String, password: String)
    fun setNewPassword(newPassword: String)
    fun sendPasswordResetEmail(emailAdress: String)

}
