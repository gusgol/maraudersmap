package com.monstershore.maraudersmap.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.monstershore.maraudersmap.R;
import com.monstershore.maraudersmap.presenter.LoginPresenter;
import com.monstershore.maraudersmap.view.ui.MenuActivity;
import com.monstershore.maraudersmap.view.ui.SignUpActivity;

public class LoginActivity extends AppCompatActivity implements LoginMvpView {

    private EditText mUser;
    private EditText mPassword;
    private Button mSignIn;
    private TextView mRegister;

    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUser = (EditText) findViewById(R.id.user);
        mPassword = (EditText) findViewById(R.id.password);
        mSignIn = (Button) findViewById(R.id.signIn);
        mRegister = (TextView) findViewById(R.id.register);

        mLoginPresenter = new LoginPresenter(this);
        mLoginPresenter.attachView(this);

        mSignIn.setOnClickListener(mOnSignInClick);
        mRegister.setOnClickListener(mOnRegisterClick);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            startMenuActivity();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mLoginPresenter != null) {
            mLoginPresenter.detachView();
        }
    }

    private View.OnClickListener mOnSignInClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String user = mUser.getText().toString();
            String password = mPassword.getText().toString();
            mLoginPresenter.login(user, password);
        }
    };

    private View.OnClickListener mOnRegisterClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getContext(), SignUpActivity.class);
            startActivity(intent);
        }
    };


    @Override
    public void onLoginSuccess() {
        Toast.makeText(getContext(), "Login successful", Toast.LENGTH_LONG).show();
        startMenuActivity();
    }

    @Override
    public void onLoginFailed(String errorMessage) {
        Toast.makeText(getContext(), "Login failed", Toast.LENGTH_LONG).show();
    }

    @Override
    public Context getContext() {
        return this;
    }

    private void startMenuActivity() {
        Intent intent = new Intent(getContext(), MenuActivity.class);
        startActivity(intent);
        finish();
    }
}
