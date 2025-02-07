package com.streamdeepak;

import java.util.*;
import java.util.stream.*;


class Employee {
    int id;
    double salary;
    String department;

    public Employee(int id, double salary, String department) {
        this.id = id;
        this.salary = salary;
        this.department = department;
    }
    

    public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	@Override
    public String toString() {
        return "Employee{id=" + id + ", salary=" + salary + ", department='" + department + "'}";
    }
}

public class Employeedata {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, 5000, "HR"),
                new Employee(2, 7000, "IT"),
                new Employee(3, 6000, "Finance"),
                new Employee(4, 8000, "Marketing")
               
        );

        // Sort employees by salary in ascending order using Stream API
        System.out.println("Sort by salary in ascending order");
        List<Employee> sortedEmployees = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary)) // Sorting by salary in ascending order
                .collect(Collectors.toList());

        // Print sorted employees
        sortedEmployees.forEach(System.out::println);
        
        System.out.println("Sorting Salary in decending order");
        // Sort employees by salary in descending order using Stream API
        List<Employee> sortedEmployees2 = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed()) // Sorting by salary in descending order
                .collect(Collectors.toList());

        // Print sorted employees
        sortedEmployees.forEach(System.out::println);
        
       

    
    System.out.println("Sort by department in ascending order");
    
    List<Employee> sortedEmployees9 = employees.stream()
            .sorted(Comparator.comparing(Employee::getDepartment)) // Sorting by department in ascending order
            .collect(Collectors.toList());

    // Print sorted employees
    sortedEmployees9.forEach(System.out::println);

    System.out.println("Sort department in decending order");
    
    // Sort employees by department in descending order
    List<Employee> sortedEmployees4 = employees.stream()
            .sorted(Comparator.comparing(Employee::getDepartment).reversed()) // Sorting by department in descending order
            .collect(Collectors.toList());

    // Print sorted employees
    sortedEmployees.forEach(System.out::println);
    }}
    
   
