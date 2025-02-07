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
                new Employee(4, 8000, "Marketing"),
                new Employee(5, 9000, "IT")
                
               
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
    sortedEmployees4.forEach(System.out::println);
    
    System.out.println("Sort by salary and then department in asceding");
    
    List<Employee> sortedEmployeesaddepartment = employees.stream()
            .sorted(Comparator.comparingDouble(Employee::getSalary)  // Sort by salary in ascending order
                    .thenComparing(Employee::getDepartment))      // Then sort by department in ascending order
            .collect(Collectors.toList());

    // Print sorted employees
    sortedEmployeesaddepartment.forEach(System.out::println);
    
    System.out.println("Employee in IT department");
    
    List<Employee> itEmployees = employees.stream()
            .filter(employee -> "IT".equals(employee.getDepartment()))  // Filter by IT department
            .collect(Collectors.toList());

    // Print employees in the IT department
    itEmployees.forEach(System.out::println);
    
    System.out.println("Slary by departmet");
    
    
    Map<String, Double> totalSalariesByDepartment = employees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment, // Group by department
                    Collectors.summingDouble(Employee::getSalary)));  // Sum salaries for each department

    // Print the total salary for each department
    totalSalariesByDepartment.forEach((department, totalSalary) -> 
        System.out.println("Department: " + department + ", Total Salary: " + totalSalary)
    );
    
    System.out.println("Salary Bonus of IT Employee 10 %");
    
    employees.stream()
    .filter(employee -> "IT".equals(employee.getDepartment()))  // Filter by IT department
    .forEach(employee -> {
        double bonus = employee.getSalary() * 0.10;  // Calculate 10% bonus
        employee.setSalary(employee.getSalary() + bonus);  // Update salary with bonus
    });

// Print only IT employees with the updated salary
employees.stream()
    .filter(employee -> "IT".equals(employee.getDepartment()))  // Filter by IT department
    .forEach(System.out::println);  // Print IT employees with updated salary

    System.out.println("Salary bonus to HR by 25%");
    
    // Apply the 25% salary bonus for HR employees and update their salary
    employees.stream()
            .filter(employee -> "HR".equals(employee.getDepartment()))  // Filter by HR department
            .forEach(employee -> {
                double bonus = employee.getSalary() * 0.25;  // Calculate 25% bonus
                employee.setSalary(employee.getSalary() + bonus);  // Update salary with bonus
            });

    // Print only IT employees with the updated salary (no change for IT employees)
    employees.stream()
            .filter(employee -> "IT".equals(employee.getDepartment()))  // Filter by IT department
            .forEach(System.out::println);  // Print IT employees with updated salary
    
    System.out.println("Employee with the highest salry amongst all departmet");
    

    // Find the employee with the highest salary
    Employee highestPaidEmployee = employees.stream()
            .max(Comparator.comparingDouble(Employee::getSalary))  // Compare by salary
            .orElseThrow(() -> new NoSuchElementException("No employee found")); // Handle case where no employee exists

    // Print the employee with the highest salary
    System.out.println("Employee with the highest salary: " + highestPaidEmployee);
    
    
    System.out.println("Salary of employees in each department");
    
    
    // Group employees by department and sum their salaries
    Map<String, Double> totalSalaryByDepartment = employees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment, // Group by department
                    Collectors.summingDouble(Employee::getSalary)));  // Sum salaries for each department

    // Print total salary for each department
    totalSalaryByDepartment.forEach((department, totalSalary) -> 
        System.out.println("Department: " + department + ", Total Salary: " + totalSalary));
    
    
    System.out.println("Employee with salry greater then 6000");
    
    

    // Filter employees with salary greater than 6000
    employees.stream()
            .filter(employee -> employee.getSalary() > 6000)  // Filter condition
            .forEach(System.out::println);  // Print each employee meeting the conditio
    
    
    System.out.println("Department with highest sveare salry");
    
    
    // Calculate the average salary for each department
    Map<String, Double> averageSalaryByDepartment = employees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment, // Group by department
                    Collectors.averagingDouble(Employee::getSalary)));  // Calculate average salary for each department

    // Find the department with the highest average salary
    Map.Entry<String, Double> highestAvgSalaryDepartment = averageSalaryByDepartment.entrySet().stream()
            .max(Map.Entry.comparingByValue())  // Find the entry with the highest average salary
            .orElseThrow(() -> new NoSuchElementException("No department found"));

    // Print the department with the highest average salary
    System.out.println("Department with the highest average salary: " + highestAvgSalaryDepartment.getKey() +
            " with average salary: " + highestAvgSalaryDepartment.getValue());}}
    
   
