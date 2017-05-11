package com.example.myexercise4.data;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.myexercise4.model.Contact;
import com.example.myexercise4.util.Utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by nicoleang on 10.05.17.
 */

public class ContentResolverContactRepo implements ContactRepo{

    private final ContentResolver contentResolver;

    public ContentResolverContactRepo(Context context) {
        this.contentResolver = context.getContentResolver();
    }

    @Override
    public void findAllWithBirthday(@NonNull final OnDataLoadCallback<List<Contact>> callback) {

        new AsyncTask<Void, Void, List<Contact>>(){

            private Exception exception = null;

            @Override
            protected List<Contact> doInBackground(Void...params){
                List<Contact> contactList = new ArrayList<>();
                Uri uri = ContactsContract.Data.CONTENT_URI;

                String[] projection = new String[]{
                        ContactsContract.Contacts.DISPLAY_NAME,
                        ContactsContract.CommonDataKinds.Event.CONTACT_ID,
                        ContactsContract.CommonDataKinds.Event.START_DATE
                };

                String where = ContactsContract.Data.MIMETYPE + "= ? AND "
                        + ContactsContract.CommonDataKinds.Event.TYPE + "="
                        + ContactsContract.CommonDataKinds.Event.TYPE_BIRTHDAY;

                String[] selectionArgs = new String[] { ContactsContract.CommonDataKinds.Event.CONTENT_ITEM_TYPE};

                String sortOrder = null;

                try (Cursor cursor = contentResolver.query(uri, projection, where, selectionArgs, sortOrder)) {
                    if (cursor != null) {
                        int nameColumn = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
                        int idColumn = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Event.CONTACT_ID);
                        int birthday = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Event.START_DATE);

                        while (cursor.moveToNext()) {
                            long id = cursor.getLong(idColumn);
                            String name = cursor.getString(nameColumn);
                            Date date = Utils.parseDate(cursor.getString(birthday));

                            if (name != null && date != null) {
                                contactList.add(Contact.create(id, name, date));
                            } else {
                                Log.i("ContactRepo", "Could not parse birthday of contact \"" + name + "\" (ID: " + id + ")");
                            }
                        }
                    }
                    return contactList;
                }catch(Exception e){
                    exception = e;
                    return null;
                }

            }

            @Override
            protected void onPostExecute(List<Contact> contactList){
                if(exception != null){
                    callback.onDataLoadError(exception);
                }else {
                    callback.onDataLoaded(contactList);
                }
            }
        }.execute();
    }
}
