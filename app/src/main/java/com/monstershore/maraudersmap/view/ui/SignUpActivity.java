package com.monstershore.maraudersmap.view.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.monstershore.maraudersmap.R;
import com.monstershore.maraudersmap.presenter.SignUpPresenter;
import com.monstershore.maraudersmap.view.SignUpMvpView;

public class SignUpActivity extends AppCompatActivity implements SignUpMvpView{

    private EditText mName;
    private EditText mEmail;
    private EditText mPassword;
    private Button mRegister;
    private ProgressBar mProgress;
    private Toolbar mToolbar;

    private SignUpPresenter mSignUpPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mName = (EditText) findViewById(R.id.name);
        mEmail = (EditText) findViewById(R.id.email);
        mPassword = (EditText) findViewById(R.id.password);
        mRegister = (Button) findViewById(R.id.register);
        mProgress = (ProgressBar) findViewById(R.id.progress);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);

        // Toolbar settings
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        mSignUpPresenter = new SignUpPresenter(getContext());
        mSignUpPresenter.attachView(this);

        mRegister.setOnClickListener(mOnRegisterClick);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSignUpPresenter.detachView();
    }

    private View.OnClickListener mOnRegisterClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(mSignUpPresenter != null) {
                mProgress.setVisibility(View.VISIBLE);
                mSignUpPresenter.register(mName.getText().toString(), mEmail.getText().toString(), mPassword.getText().toString());
            }
        }
    };

    @Override
    public void onSignUpSuccess() {
        mProgress.setVisibility(View.INVISIBLE);
        Intent intent = new Intent(getContext(), MenuActivity.class);
        startActivity(intent);
    }

    @Override
    public void onSignUpFailed(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public Context getContext() {
        return this;
    }
}
