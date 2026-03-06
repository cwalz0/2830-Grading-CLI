package com.gradecli;
import java.util.HashMap;


/**
 * represents a student
 */
public class Student {
    private String name;
    /**
     * map where the key is the assignments title and the value is the grade
     */
    private HashMap<String, Double> assignmentGrades;

/**
 * Creates a new student with the name and an empty assignment map
 * @param name of the student
 */
public Student(String name) {
    this.name = name;
    this.assignmentGrades = new HashMap<>();
    }

    /**
     * stores the score for an assignment
     * @param assignment assignment name
     * @param score the grade given
     */

    public void addGrade(String assignment, double score){
        if (score < 0 || score > 100) {
            System.out.println("Warning: Invalid Score for " + name);
        }
        assignmentGrades.put(assignment, score);
    }

    /**
     * the average of all grades in the map
     * @return
     */
    public double calculateAverage() {
        if (assignmentGrades.isEmpty()) {
            return 0.0;
        }

        double total = 0;
        for (double score : assignmentGrades.values()){
            total += score;
        }
        return total / assignmentGrades.size();

    }
    /**
     * returns a formatted summary with the student's name and avg
     * @return formatted string
     */
    @Override
    public String toString() {
        return String.format("%-20s | Average: %.2f", name, calculateAverage());
    }

    /**
     * @return students name
     */
    public String getName() {return name;}

    /**
     * @return hashmap with all the assignments and their grade
     */
    public HashMap<String, Double> getGrades() {return assignmentGrades;}

}