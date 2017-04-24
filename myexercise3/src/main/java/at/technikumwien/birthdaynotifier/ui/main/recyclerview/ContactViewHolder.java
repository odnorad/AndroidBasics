package at.technikumwien.birthdaynotifier.ui.main.recyclerview;

import android.media.Image;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import at.technikumwien.birthdaynotifier.R;
import at.technikumwien.birthdaynotifier.ui.main.Contact;

/**
 * Please read the {@link RecyclerView.ViewHolder} java docs.
 */
class ContactViewHolder extends RecyclerView.ViewHolder {

    private CardView cardView;
    private TextView name;
    private ImageView cake;
    private TextView birthday;


    ContactViewHolder(View itemView) {
        super(itemView);

        // Find our views
        cardView = (CardView) itemView.findViewById(R.id.card_view);
        name = (TextView) itemView.findViewById(R.id.name);
        cake = (ImageView) itemView.findViewById(R.id.cake);
        birthday = (TextView) itemView.findViewById(R.id.birthday);

        // Show a Snackbar when the card view is clicked
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(cardView, name.getText() + " clicked", Snackbar.LENGTH_LONG).show();
            }
        });
    }

    // Here we set the new item model on our view holder and
    // update our views accordingly
    void update(Contact contactName) {
        cake.setImageResource(contactName.hasBirthday() ? R.drawable.ic_person_black : R.drawable.ic_cake_black_24dp);
        name.setText(contactName.name());
        birthday.setText(contactName.getFormattedBirthday());
    }
}
