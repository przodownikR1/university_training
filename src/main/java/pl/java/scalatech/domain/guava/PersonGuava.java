package pl.java.scalatech.domain.guava;

import org.joda.money.Money;

import pl.java.scalatech.domain.type.Sex;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

public class PersonGuava implements Comparable<PersonGuava> {

    private String name;
    private Money salary;
    private int age;
    private Sex sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Money getSalary() {
        return salary;
    }

    public void setSalary(Money salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public PersonGuava() {
        super();
    }

    public PersonGuava(String name, Money salary, int age, Sex sex) {
        super();
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, salary, age, sex);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PersonGuava other = (PersonGuava) obj;
        return Objects.equal(name, other.name) && Objects.equal(salary, other.salary) && Objects.equal(age, other.age) && Objects.equal(sex, other.sex);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(PersonGuava.class).add("name", name).add("salary", salary).add("sex", sex).omitNullValues().toString();
        // return Objects.toStringHelper(getClass()).add("firstName", firstName).add("lastName", lastName).add("age", age).omitNullValues().toString();
    }

    @Override
    public int compareTo(PersonGuava other) {
        return ComparisonChain.start().compare(name, other.name).compare(salary, other.salary).compare(age, other.age).result();
    }
}