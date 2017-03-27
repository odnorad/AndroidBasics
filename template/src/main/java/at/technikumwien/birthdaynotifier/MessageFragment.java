package at.technikumwien.birthdaynotifier;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MessageFragment extends Fragment {

    private static final String EXTRA_MESSAGE="message";

    public static Fragment getFragment(String message) {
        MessageFragment fragment = new MessageFragment();

        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_MESSAGE, message);
        fragment.setArguments(bundle);

        return fragment;
    }
}
