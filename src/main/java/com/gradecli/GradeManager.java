package com.gradecli;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Manages the grades of a class using lists
 */

public class GradeManager {
    private ArrayList<Student> roster;
    /**
     * creates an empty roster / (class)
     */

    public GradeManager() {
        this.roster = new ArrayList<>();
    }

    /**
     * Adds a new student if their name isn't in the roster list
     * @param name name of the student
     */
    public void addStudent(String name) {
        if (getStudent(name) != null) {
            System.out.printf("Error: %s is already in the class.\n", name);
        } else {
            roster.add(new Student(name));
            System.out.printf("Student added: %s\n", name);
        }
    }

    /**
     * Searches for a student by name (ignores capitals)
     * @param name name of the student
     * @return student object
     */
    public Student getStudent(String name) {
        for (Student s : roster) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }

    /**
     * Prints all the students and their averages, in a class. Or if its empty, dispaly it is empty.
     */
    public void printRoster() {
        if (roster.isEmpty()) {
            System.out.println("The roster is currently empty");
        return;
        }

        System.out.println("\n\t--== Current Roster ==--");
        for (Student s : roster) {
            System.out.println(s);
        }
        System.out.println("----------------------------------------");
    }

    
    /**
     * Export the current roster and respective averages to a csv
     * @param filename name of the file
     */
    public void exportToCSV(String filename) {
        try (PrintWriter writer = new PrintWriter(new File(filename))) {
            writer.println("Student ID, Name, Average Grade");

            for (Student s : roster) {
                writer.printf("%s, %.2f%n", s.getName(), s.calculateAverage());
            }
            System.out.println("Exported succesfully to " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("Error: Couldn't create file.");
        }
    }
}
