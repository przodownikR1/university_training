package pl.java.scalatech.domain._new;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @author Sławomir Borowiec
 *         Module name : university_training
 *         Creating time : 14 kwi 2015 23:41:55
 */

public class PersonNew {
    @Getter
    private String login;

    private String name;

    public PersonNew(@NonNull String login) {

        this.login = login;
    }

}
