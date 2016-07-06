package com.monstershore.maraudersmap.presenter;

/**
 * Created by Gustavo on 5/29/16.
 */

public interface Presenter<V> {
    void attachView(V view);
    void detachView();
}
