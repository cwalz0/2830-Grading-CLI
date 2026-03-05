package com.gradecli;
import java.util.HashMap;

public class Student {
    private String name;
    private HashMap<String, Double> assignmentGrades;

public Student(String name) {
    this.name = name;
    this.assignmentGrades = new HashMap<>();
    }

    public void addGrade(String assignment, double score){
        if (score < 0 || score > 100) {
            System.out.println("Warning: Invalid Score for " + name);
        }
        assignmentGrades.put(assignment, score);
    }


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

    @Override
    public String toString() {
        return String.format("%-20s | Average: %.2f", name, calculateAverage());
    }

    public String getName() {return name;}
    public HashMap<String, Double> getGrades() {return assignmentGrades;}

}
