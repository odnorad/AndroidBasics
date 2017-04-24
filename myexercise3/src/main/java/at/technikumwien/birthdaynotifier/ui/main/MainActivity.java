package at.technikumwien.birthdaynotifier.ui.main;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.jar.Manifest;

import at.technikumwien.birthdaynotifier.R;
import at.technikumwien.birthdaynotifier.ui.main.recyclerview.ContactAdapter;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_PERMISSION_READ_CONTACTS = 345;

    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    private TextView emptyText;

    private ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        emptyText = (TextView) findViewById(R.id.no_contacts);

        adapter = new ContactAdapter();

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkContactsPermission();
            }
        });
    }

    private void checkContactsPermission(){
        if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED){
            onContactsPermissionGranted();
        }else{
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.READ_CONTACTS},REQUEST_CODE_PERMISSION_READ_CONTACTS );
        };
    }


    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permission ,@NonNull int[] grantResults){
        super.onRequestPermissionsResult(requestCode, permission, grantResults);
        if(requestCode == REQUEST_CODE_PERMISSION_READ_CONTACTS){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                onContactsPermissionGranted();
            }else{
                onContactsPermissionDenied();
            }
        }
    }

    private void onContactsPermissionDenied(){
        Snackbar.make(recyclerView, "Premission needed to show birthdays", Snackbar.LENGTH_INDEFINITE)
                .setAction("Retry", new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        checkContactsPermission();
                    }
                }).show();
    }

    private void onContactsPermissionGranted(){
        Snackbar.make(recyclerView, "Permission granted", Snackbar.LENGTH_LONG).show();

        onContactsLoaded(Arrays.asList(
                Contact.create(0, "Hot Potato", Utils.parseDate("1993.12.12")),
                Contact.create(1, "Sleve McDichael", new Date()),
                Contact.create(2, "Willie Dustice", Utils.parseDate("1992.02.22")),
                Contact.create(3, "Scott Dourque", Utils.parseDate("1995.05.23")),
                Contact.create(4, "Mike Truk", Utils.parseDate("1993.06.02")),
                Contact.create(5, "Tim Sandaele", Utils.parseDate("1993.08.11")),
                Contact.create(6, "Bobson Dugnutt", Utils.parseDate("1996.03.30")),
                Contact.create(7, "Gleneallen Mixon", Utils.parseDate("1997.04.28"))
        ));
    }

    private void onContactsLoaded(List<Contact> contactList) {
        emptyText.setVisibility(contactList.isEmpty() ? View.VISIBLE : View.GONE);
        adapter.setContactList(contactList);
    }


}
