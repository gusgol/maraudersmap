package com.monstershore.maraudersmap.presenter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.monstershore.maraudersmap.view.SignUpMvpView;

import static android.R.id.message;

/**
 * Created by Gustavo on 5/29/16.
 */

public class SignUpPresenter implements Presenter<SignUpMvpView> {

    private static final String TAG = SignUpPresenter.class.getSimpleName();

    private SignUpMvpView signUpMvpView;
    private Context context;
    private FirebaseAuth mAuth;

    public SignUpPresenter(Context context) {
        this.context = context;
        this.mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void attachView(SignUpMvpView view) {
        this.signUpMvpView = view;
    }

    @Override
    public void detachView() {
        signUpMvpView = null;
    }

    public void register(final String name, String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener((Activity) context, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    updateName(task.getResult().getUser(), name);
                } else {
                    signUpMvpView.onSignUpFailed(task.getException().getMessage());
                }

            }
        });
    }

    private void updateName(FirebaseUser user, String name) {
        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                .setDisplayName(name)
//                .setPhotoUri(Uri.parse("https://example.com/jane-q-user/profile.jpg"))
                .build();

        user.updateProfile(profileUpdates).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    signUpMvpView.onSignUpSuccess();
                } else {
                    signUpMvpView.onSignUpFailed(task.getException().getMessage());
                }
            }
        });
    }
}
