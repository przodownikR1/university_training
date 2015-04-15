package pl.java.scalatech.test.domain.lombok;

import org.junit.Test;

import pl.java.scalatech.domain._new.PersonNew;

public class PersonLombokTest {
    @Test(expected = NullPointerException.class)
    public void shouldNotNullWork() {
        String name = null;
        PersonNew p = new PersonNew(name, "test");

    }

    @Test
    public void shouldNotNullFieldWork() {
        String name = "slawek";
        PersonNew p = new PersonNew(name, "test");
        p.getName();
    }

    @Test(expected = NullPointerException.class)
    public void shouldNotNullSetter() {
        String login = "slawek";
        String name = null;
        PersonNew p = new PersonNew(login, "something");
        p.setName(name);
        // p.getName();
    }
}
