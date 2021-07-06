package java8;

import javax.smartcardio.CommandAPDU;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class employee {
    int id;
    String name;
    int age;
    String gender;
    String department;
    int yearOfJoining;
    double salary;
    public employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Id : " + id
                + ", Name : " + name
                + ", age : " + age
                + ", Gender : " + gender
                + ", Department : " + department
                + ", Year Of Joining : " + yearOfJoining
                + ", Salary : " + salary;
    }

    public static void main(String[] args) {
        List<employee> employeeList = new ArrayList<>();

        employeeList.add(new employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        // How many male and female employees are there in the organization?
        Map<String, Long> noOfMaleAndFemaleEmployees = employeeList.stream().collect(Collectors.groupingBy(employee::getGender, Collectors.counting()));
        System.out.println(noOfMaleAndFemaleEmployees);

        // Print the name of all departments in the organization?
        List<String> departments = employeeList.stream().map(employee::getDepartment).distinct().collect(Collectors.toList());
        System.out.println(departments);

        //What is the average age of male and female employees?
        Map<String, Double> avgAge = employeeList.stream().collect(Collectors.groupingBy(employee::getGender, Collectors.averagingDouble(employee::getAge)));
        System.out.println(avgAge);

        // Get the details of highest paid employee in the organization?
        Optional<employee> employee1 = employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(employee::getSalary)));
        System.out.println(employee1);

        // Get the names of all employees who have joined after 2015?
        List<String> employees = employeeList.stream().filter(employee -> employee.getYearOfJoining() > 2015).map(employee::getName).collect(Collectors.toList());
        System.out.println(employees);

        // Count the number of employees in each department?
        Map<String, Long> employeeInEachDept = employeeList.stream().collect(Collectors.groupingBy(employee::getDepartment, Collectors.counting()));
        System.out.println(employeeInEachDept);

        //What is the average salary of each department?
        Map<String, Double> avgSalInEachDept = employeeList.stream().collect(Collectors.groupingBy(employee::getDepartment, Collectors.averagingDouble(employee::getSalary)));
        System.out.println(avgSalInEachDept);

        //Get the details of youngest male employee in the product development department?
        Optional<employee> youngestEmployee = employeeList.stream()
                .filter(employee -> employee.getGender() == "Male" && employee.getDepartment() == "Product Development")
                .collect(Collectors.minBy(Comparator.comparingInt(employee::getAge)));
        System.out.println(youngestEmployee.get());

        // Who has the most working experience in the organization?
        Optional<employee> LeastExpEmployee = employeeList.stream().collect(Collectors.minBy(Comparator.comparing(employee::getYearOfJoining)));
        System.out.println(LeastExpEmployee.get());

        // What is the average salary of male and female employees?
        Map<String, Double> avgSalry = employeeList.stream()
                                        .collect(Collectors.groupingBy(employee::getGender, Collectors.averagingDouble(employee::getSalary)));
        System.out.println(avgSalry);

        // What is the average salary and total salary of the whole organization?
        DoubleSummaryStatistics employeeStat = employeeList.stream().collect(Collectors.summarizingDouble(employee::getSalary));
        System.out.println(employeeStat.getAverage());
        System.out.println(employeeStat.getSum());

        // Name of the person whose age is max
        employee mostAgeEmployee = employeeList.stream().max(Comparator.comparing(employee::getAge)).get();
        System.out.println("Most aged person is = " + mostAgeEmployee.name);

        long count = employeeList.stream().filter(employee -> employee.getAge() == 25).count();
        System.out.println("Employees with age 25 = " + count);

    }
}
