package com.example.eastagile.themoviedatabase.presenter;

public interface AuthenticatePresenter {

    void signIn(String email, String password);
    void signUp(String email, String password);
    void setNewPassword(String newPassword);

}
