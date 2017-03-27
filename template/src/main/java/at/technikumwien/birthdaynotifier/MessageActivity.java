package at.technikumwien.birthdaynotifier;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MessageActivity extends AppCompatActivity {

    private static final String EXTRA_MESSAGE = "message";

    public static Intent getIntent(Context context, String message){
        Intent intent = new Intent(context, MessageActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String message = getIntent().getStringExtra(EXTRA_MESSAGE);
        TextView textView = (TextView) findViewById(R.id.message);
    }
}
