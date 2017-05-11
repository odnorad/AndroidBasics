package com.example.myexercise4.data;

/**
 * Created by nicoleang on 10.05.17.
 */

public interface OnDataLoadCallback<T> {

    void onDataLoaded(T data);
    void onDataLoadError(Exception exception);
}
