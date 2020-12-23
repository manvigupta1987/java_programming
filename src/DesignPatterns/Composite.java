package DesignPatterns;

// Structural Design Pattern
// Composite pattern composes objects in term of a tree structure. This pattern creates a class that contains group of its own objects.
//Composite design patten allows you to have a tree structure and ask each node in the tree structure to perform a task.

import java.util.ArrayList;
import java.util.List;

public class Composite {
    public static void main(String[] args) {
        Employee CEO = new Employee("John","CEO", 30000);

        Employee headSales = new Employee("Robert","Head Sales", 20000);

        Employee headMarketing = new Employee("Michel","Head Marketing", 20000);

        Employee clerk1 = new Employee("Laura","Marketing", 10000);
        Employee clerk2 = new Employee("Bob","Marketing", 10000);

        Employee salesExecutive1 = new Employee("Richard","Sales", 10000);
        Employee salesExecutive2 = new Employee("Rob","Sales", 10000);

        CEO.addEmployee(headSales);
        CEO.addEmployee(headMarketing);

        headSales.addEmployee(salesExecutive1);
        headSales.addEmployee(salesExecutive2);

        headMarketing.addEmployee(clerk1);
        headMarketing.addEmployee(clerk2);

        //print all employees of the organization
        CEO.printEmployees();
    }

}


class Employee {
    private String name;
    private String dept;
    private int salary;

    private List<Employee> employees;

    Employee(String name, String dept, int salary) {
        this.salary = salary;
        this.name = name;
        this.dept = dept;
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void remove(Employee employee) {
        employee.remove(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                ", employees=" + employees +
                '}';
    }

    void printEmployees() {
        for (Employee employee: getEmployees()) {
            System.out.println(employee);
        }
    }
}


