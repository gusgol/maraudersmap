package com.monstershore.maraudersmap.view;

/**
 * Created by Gustavo on 5/29/16.
 */

public interface SignUpMvpView extends MvpView {
    void onSignUpSuccess();
    void onSignUpFailed(String message);
}
