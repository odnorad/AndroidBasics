package com.example.mylecture6;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.mylecture6.data.Message;

public class MessageViewHolder extends RecyclerView.ViewHolder {

    private TextView titleTextView;
    private TextView messageTextView;

    public MessageViewHolder(View itemView) {
        super(itemView);

        titleTextView = (TextView) itemView.findViewById(R.id.title);
        messageTextView = (TextView) itemView.findViewById(R.id.message);
    }

    public void update(Message message) {
        titleTextView.setText(message.title());
        messageTextView.setText(message.message());
    }
}
