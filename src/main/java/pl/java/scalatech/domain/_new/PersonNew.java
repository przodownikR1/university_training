package pl.java.scalatech.domain._new;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sławomir Borowiec
 *         Module name : university_training
 *         Creating time : 14 kwi 2015 23:41:55
 */
@Data
@NoArgsConstructor
@Builder
public class PersonNew {
    String name;
    String age;

    public PersonNew(String name, String age) {
        // TODO Auto-generated constructor stub
    }

}
