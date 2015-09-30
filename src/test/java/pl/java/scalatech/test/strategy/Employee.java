package pl.java.scalatech.test.strategy;

public class Employee {
    private double salary;

    public Employee(double s) {
        salary = s;
    }

    public double getPayAmount() {
        return salary;
    }
}