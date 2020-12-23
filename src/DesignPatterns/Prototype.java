package DesignPatterns;

// Creational Design Pattern
//Prototype design pattern is used when the Object creation is a costly affair and requires a lot of time and resources and you have a similar object already existing.
//Prototype pattern provides a mechanism to copy the original object to a new object and then modify it according to our needs. Prototype design pattern uses java cloning
// to copy the object.

//It would be easy to understand prototype design pattern with an example. Suppose we have an Object that loads data from database. Now we need to modify this data
// in our program multiple times, so it’s not a good idea to create the Object using new keyword and load all the data again from database.
//The better approach would be to clone the existing object into a new object and then do the data manipulation

import java.util.ArrayList;
import java.util.List;

// Shallow cloning or deep cloning depends on the developer.
public class Prototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employees employee1 = new Employees();
        employee1.loadData();

        Employees employee2 = employee1.clone();
        List<String> employeesList2 = employee2.getEmployeeList();
        employeesList2.add("Pankaj");

        Employees employees3 = employee1.clone();
        List<String> employeesList3 = employees3.getEmployeeList();
        employeesList3.remove(1);

        System.out.println("employee1 List: "+employee1.getEmployeeList());
        System.out.println("employee2 List: "+ employeesList2);
        System.out.println("employee3 List: "+ employeesList3);

    }
}

class Employees implements Cloneable {
    private List<String> employeeList;

    public List<String> getEmployeeList() {
        return employeeList;
    }

    Employees() {
        employeeList = new ArrayList<>();
    }
    Employees(List<String> list) {
        this.employeeList = list;
    }

    void loadData() {
        //read data from database and add it to the list.
        for (int i = 0; i < 4; i++) {
            employeeList.add("Employee " + i);
        }
    }

    @Override
    public String toString() {
        return "Employees{" + "employeeList=" + employeeList + '}';
    }

    // Deep copying
    // If the object cloning was not provided, we will have to make database call to fetch the employee list every time. Then do the manipulations
    // that would have been resource and time consuming.
    @Override
    protected Employees clone() throws CloneNotSupportedException {
        List<String> temp = new ArrayList<>();
        for (String s: getEmployeeList()) {
            temp.add(s);
        }
        return new Employees(temp);
    }
}