package com.example.eastagile.themoviedatabase.presenter;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AuthenticatePresenterImpl implements AuthenticatePresenter {

    FirebaseAuth mAuth;

    public AuthenticatePresenterImpl() {
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void signIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
//                          // Todo update UI
                        } else {
                            // If sign in fails, display a message to the user.
                            // Todo show error
                        }

                        // ...
                    }
                });
    }

    @Override
    public void signUp(String email, String password) {
        if (null == mAuth.getCurrentUser()) {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign up success, update UI with the signed-in user's information
                                // Todo update UI...
                            } else {
                                // If sign up fails, display a message to the user.
                                // Todo display message
                            }
                        }
                    });
        }

    }

    @Override
    public void setNewPassword(String newPassword) {

    }
}
