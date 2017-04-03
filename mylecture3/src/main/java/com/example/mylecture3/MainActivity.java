package com.example.mylecture3;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView myRecyclerView;
    private FloatingActionButton addButton;
    private TextView keineKontakte;

    private ContactAdapter adapter;

    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        addButton = (FloatingActionButton) findViewById(R.id.addButton);
        keineKontakte = (TextView) findViewById(R.id.keinKontakt);

        adapter  = new ContactAdapter();

        myRecyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(layoutManager);

        myRecyclerView.setAdapter(adapter);



        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(addButton, "Kontakte geladen", Snackbar.LENGTH_LONG).show();
                onContactsLoaded(Arrays.asList(
                        "Nicole Ang",
                        "Hot Potato"
                ));
            }
        });
    }

    public void onContactsLoaded(List<String> contacts){
        keineKontakte.setVisibility(contacts.isEmpty() ? View.VISIBLE : View.GONE);
        adapter.setContactList(contacts);
    }
}
