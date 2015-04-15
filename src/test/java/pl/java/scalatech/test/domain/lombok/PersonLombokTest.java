package pl.java.scalatech.test.domain.lombok;

import org.junit.Test;

import pl.java.scalatech.domain._new.PersonNew;

public class PersonLombokTest {
    @Test(expected=NullPointerException.class)
    public void shouldNotNullWork() {
        String name = null;
        PersonNew p = new PersonNew(name);
        

    }
}
