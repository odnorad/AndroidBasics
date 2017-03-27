package at.technikumwien.birthdaynotifier;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainFragment extends Fragment {

    private EditText message;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        message = (EditText) getView().findViewById(R.id.message);
        Button send_activity = (Button) getView().findViewById(R.id.send_activity);
        Button send_fragment = (Button) getView().findViewById(R.id.send_fragment);

        send_activity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(MessageActivity.getIntent(getContext(), getMessage()));
            }
        });

        send_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.container, MessageFragment.getFragment(getMessage()))
                        .addToBackStack(null)
                        .commit();
            }
        });
    };

    private String getMessage() {
        return message.getText().toString();
    }
}
