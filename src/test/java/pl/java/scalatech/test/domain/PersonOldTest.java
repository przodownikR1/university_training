package pl.java.scalatech.test.domain;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import pl.java.scalatech.domain._new.PersonNew;
import pl.java.scalatech.domain.old.Person;
import pl.java.scalatech.domain.type.Sex;

/**
 * @author Sławomir Borowiec
 *         Module name : university_training
 *         Creating time : 14 kwi 2015 23:40:03
 */

public class PersonOldTest {
    @Test
    public void shouldCreatePerson() {
        Person person = new Person("przodownik", new BigDecimal("23"), 36, Sex.MALE);
        System.out.println(person);
    }

    @Test
    public void shouldCreatePersonByBuilder() {
        // given
        Person person = new Person.PersonBuilder("przodownik").salary(new BigDecimal("23")).age(36).sex(Sex.MALE).build();
        Person person2 = new Person("przodownik", new BigDecimal("23"), 36, Sex.MALE);
        // then
        Assert.assertEquals(person2, person);

    }

    
}
