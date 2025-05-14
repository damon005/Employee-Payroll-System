package EmployeePayrollSystem;

import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private String name;
    private int id;
    private double hoursWorked;
    private double payRate;

    // Constructor
    public Employee(int id, String name, double hoursWorked, double payRate) {
        this.id = id;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    // Calculate salary
    public double calculateSalary() {
        return hoursWorked * payRate;
    }

    // Display employee details
    public void displayEmployee() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Pay Rate: $" + payRate);
        System.out.println("Salary: $" + calculateSalary());
        System.out.println("-----------------------------");
    }
}

public class PayrollSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();

        while (true) {
            System.out.println("\nEmployee Payroll System");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Hours Worked: ");
                    double hoursWorked = scanner.nextDouble();
                    System.out.print("Enter Pay Rate: ");
                    double payRate = scanner.nextDouble();

                    Employee emp = new Employee(id, name, hoursWorked, payRate);
                    employees.add(emp);
                    System.out.println("Employee added successfully!");
                    break;

                case 2:
                    if (employees.isEmpty()) {
                        System.out.println("No employees found!");
                    } else {
                        System.out.println("\nEmployee Details:");
                        for (Employee employee : employees) {
                            employee.displayEmployee();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting the system...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}