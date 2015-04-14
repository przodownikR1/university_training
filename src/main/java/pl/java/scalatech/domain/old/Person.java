package pl.java.scalatech.domain.old;

import org.joda.money.Money;

import pl.java.scalatech.domain.type.Sex;

/**
 * @author Sławomir Borowiec
 *         Module name : university_training
 *         Creating time : 14 kwi 2015 23:35:52
 */
public class Person {

    private String name;
    private Money salary;
    private int age;
    private Sex sex;

    public Person() {
        super();
    }

    public Person(String name, Money salary, int age, Sex sex) {
        super();
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.sex = sex;
    }

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

   

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((salary == null) ? 0 : salary.hashCode());
        result = prime * result + ((sex == null) ? 0 : sex.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (age != other.age)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (salary == null) {
            if (other.salary != null)
                return false;
        } else if (!salary.equals(other.salary))
            return false;
        if (sex != other.sex)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("name -> ").append(name).append(",");
        sb.append("salary -> ").append(salary).append(",");
        sb.append("sex -> ").append(sex.name());
        return sb.toString();
    }

    public Person(PersonBuilder personBuilder) {
        this.name = personBuilder.name;
        this.age = personBuilder.age;
        this.sex = personBuilder.sex;
        this.salary = personBuilder.salary;
    }

    public static class PersonBuilder {

        private static final long serialVersionUID = 6868681866154038647L;
        private final String name;
        private Money salary;
        private int age;
        private Sex sex;

        public PersonBuilder(String name) {
            this.name = name;

        }

        public PersonBuilder salary(Money salary) {
            this.salary = salary;
            return this;
        }

        public PersonBuilder age(int age) {
            this.age = age;
            return this;
        }

        public PersonBuilder sex(Sex sex) {
            this.sex = sex;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

}
