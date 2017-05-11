package com.example.myexercise4;

import android.app.Application;

import com.example.myexercise4.data.ContactRepo;
import com.example.myexercise4.data.ContentResolverContactRepo;
import com.example.myexercise4.model.Contact;

/**
 * Created by nicoleang on 10.05.17.
 */

public class MyApplication extends Application{

    private static ContactRepo contactRepo;

    public void onCreate(){
        super.onCreate();
        contactRepo = new ContentResolverContactRepo(this);
    }

    public static ContactRepo getContactRepo(){
        return contactRepo;
    }
}
