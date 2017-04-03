package com.example.mylecture3;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by nicoleang on 03.04.17.
 */

public class ContactViewHolder extends RecyclerView.ViewHolder{

    private CardView cardView;
    private TextView contacts;

    public ContactViewHolder(View itemView) {
        super(itemView);

        cardView = (CardView) itemView.findViewById(R.id.card_view);
        contacts = (TextView) itemView.findViewById(R.id.name);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(cardView, contacts.getText() + "Kontakt hinzugefügt", Snackbar.LENGTH_LONG).show();
            }
        });
    }

        public void update (String contactName){
            contacts.setText(contactName);
        }


}

