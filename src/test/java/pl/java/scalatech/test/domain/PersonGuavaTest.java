package pl.java.scalatech.test.domain;

import java.math.BigDecimal;
import java.util.Locale;

import org.fest.assertions.Assertions;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Test;

import pl.java.scalatech.domain.guava.PersonGuava;
import pl.java.scalatech.domain.old.Person;
import pl.java.scalatech.domain.type.Sex;

public class PersonGuavaTest {
    @Test
    public void shouldCreatePerson() {
        //given
        Person person = new Person("przodownik", Money.of(CurrencyUnit.getInstance(Locale.getDefault()), new BigDecimal("23")), 36, Sex.MALE);
        PersonGuava personGuava = new PersonGuava("przodownik", Money.of(CurrencyUnit.getInstance(Locale.getDefault()), new BigDecimal("23")), 36, Sex.MALE);
        // then
        System.out.println(personGuava);
        System.out.println(person);
        Assertions.assertThat(personGuava).isNotNull();
        Assertions.assertThat(personGuava.getAge()).isEqualTo(person.getAge());
        Assertions.assertThat(personGuava.getSalary()).isEqualTo(person.getSalary());
        
    }

}
