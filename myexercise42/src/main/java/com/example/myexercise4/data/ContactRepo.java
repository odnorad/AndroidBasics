package com.example.myexercise4.data;

import android.support.annotation.NonNull;

import com.example.myexercise4.model.Contact;

import java.util.List;

/**
 * Created by nicoleang on 10.05.17.
 */

public interface ContactRepo {

    void findAllWithBirthday(@NonNull
                             OnDataLoadCallback<List<Contact>> callback);
}

