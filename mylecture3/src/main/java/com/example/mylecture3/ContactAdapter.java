package com.example.mylecture3;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

/**
 * Created by nicoleang on 03.04.17.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder>{

    private List<String> contact = Collections.emptyList();

    public void setContactList(List<String> contact){
        this.contact = contact;
        notifyDataSetChanged();
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        holder.update(contact.get(position));
    }

    //zeigt Kontakte, die in MainActivity gespeichert sind
    @Override
    public int getItemCount() {
        return contact.size();
    }
}
