package com.monstershore.maraudersmap.view;

/**
 * Created by Gustavo on 5/29/16.
 */

public interface LoginMvpView extends MvpView {
    void onLoginSuccess();
    void onLoginFailed(String errorMessage);
}
