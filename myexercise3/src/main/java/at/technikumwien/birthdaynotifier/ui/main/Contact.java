package at.technikumwien.birthdaynotifier.ui.main;

import com.google.auto.value.AutoValue;

import java.util.Date;

/**
 * Created by nicoleang on 23.04.17.
 */

@AutoValue
public abstract class Contact {

    public abstract long id();
    public abstract String name();
    public abstract Date birthday();

    public static Contact create(long id, String name, Date birthday){
        return new AutoValue_Contact(id, name, birthday);
    }

    public String getFormattedBirthday(){
      return Utils.formatBirthday(birthday());
    }

    public boolean hasBirthday(){
        return Utils.isToday(birthday());
    }
}