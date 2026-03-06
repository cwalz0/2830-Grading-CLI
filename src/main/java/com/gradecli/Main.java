package com.gradecli;
import java.util.Scanner;

/**
 * handles cli logic, and handles input capture.
 */

public class Main {
    public static void main(String[] args) {
        GradeManager manager = new GradeManager();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        System.out.println("\n--== Grading CLI ==--\n");
        while(isRunning) {
            System.out.println("\nOptions: [add] [grade] [list] [export] [exit]");
            System.out.print("> ");
            String command = scanner.nextLine().toLowerCase().trim();

            switch (command) {
                case "add":
                    System.out.println("Enter name: ");
                    System.out.print("> ");
                    String name = scanner.nextLine();
                    manager.addStudent(name);
                    break;

                case "grade":
                    System.out.println("Enter Student Name: ");
                    System.out.print("> ");
                    String studentName = scanner.nextLine();
                    System.out.println("Assignment Name: ");
                    System.out.print("> ");
                    String assignment = scanner.nextLine();
                    System.out.println("Score: ");
                    System.out.print("> ");
                    double score = Double.parseDouble(scanner.nextLine());

                    Student s = manager.getStudent(studentName);
                    if (s != null) {
                        s.addGrade(assignment, score);
                    } else {
                        System.out.println("Student not found.\n");
                    }
                    break;

                case "list":
                    manager.printRoster();
                    break;

                case "export":
                    manager.exportToCSV("class_report.csv");
                    break;
                
                case "exit":
                    isRunning = false;
                    System.out.println("Goodbye.\n");
                    break;

                default:
                    System.out.println("Invalid command.\n");
            }
        }
        scanner.close();
    }
}