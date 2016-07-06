package com.monstershore.maraudersmap.presenter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.monstershore.maraudersmap.view.LoginMvpView;

import java.util.concurrent.Executor;

/**
 * Created by Gustavo on 5/29/16.
 */

public class LoginPresenter implements Presenter<LoginMvpView> {

    private static final String TAG =  LoginPresenter.class.getSimpleName();

    private LoginMvpView loginMvpView;
    private FirebaseAuth mAuth;
    private Context context;

    public LoginPresenter(Context context) {
        this.mAuth = FirebaseAuth.getInstance();
        this.context = context;
    }

    public void login(String email, String password) {
        if(loginMvpView != null && mAuth != null) {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener((Activity) context, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        Log.w(TAG, "signInWithEmail", task.getException());
                        loginMvpView.onLoginFailed(task.getException().getMessage());
                    } else {
                        Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());
                        loginMvpView.onLoginSuccess();
                    }
                }
            });
        }
    }

    @Override
    public void attachView(LoginMvpView view) {
        this.loginMvpView = view;
    }

    @Override
    public void detachView() {
        this.loginMvpView = null;
    }
}
