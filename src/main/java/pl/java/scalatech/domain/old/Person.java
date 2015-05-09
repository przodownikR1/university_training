package pl.java.scalatech.domain.old;

import java.math.BigDecimal;

import pl.java.scalatech.domain.type.Sex;

/**
 * @author Sławomir Borowiec 
 * Module name : university_training
 * Creating time :  14 kwi 2015 23:35:52
 
 */
public class Person {

    private String name;
    private BigDecimal salary;
    private int age;
    private Sex sex;
    
    
    public Person() {
        super();
    }
    public Person(String name, BigDecimal salary, int age, Sex sex) {
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
    public BigDecimal getSalary() {
        return salary;
    }
    public void setSalary(BigDecimal salary) {
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
    
    
    
}
