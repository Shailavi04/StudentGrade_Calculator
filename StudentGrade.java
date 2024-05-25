package Grade;
import java.util.*;

public class StudentGrade {
    private Scanner obj;

    public StudentGrade() {
        obj = new Scanner(System.in);
    }

    public void calculateTotal() {
        System.out.println("Enter the number of subjects:");
        int numSubjects = obj.nextInt();
        obj.nextLine(); // Consume newline left-over

        String[] subjects = new String[numSubjects];
        double[] marks = new double[numSubjects];
        double total = 0;

        for (int i = 0; i < numSubjects; i++) {
            System.out.println("Enter the name of subject " + (i + 1) + ":");
            subjects[i] = obj.nextLine();
        }

        for (int i = 0; i < numSubjects; i++) {
            marks[i] = inputMarks(subjects[i]);
            total += marks[i];
        }

        System.out.println("Total marks = " + total);

        double averagePercentage = (total / numSubjects);
        System.out.println("Average Percentage: " + averagePercentage + "%");

        // Calculate and display grades for each subject
        for (int i = 0; i < numSubjects; i++) {
            String grade = calculateGrade(marks[i]);
            System.out.println("Grade in " + subjects[i] + ": " + grade);
        }

        // Calculate and display overall grade
        String overallGrade = calculateGrade(averagePercentage);
        System.out.println("Overall Grade: " + overallGrade);
    }

    double inputMarks(String subject) {
        System.out.println("Enter marks obtained in " + subject + " (out of 100):");
        double marks;
        while (true) {
            String input = obj.next();
            try {
                marks = Double.parseDouble(input);
                if (marks < 0 || marks > 100) {
                    System.out.println("Invalid input! Marks should be between 0 and 100.");
                    System.out.println("Please enter marks obtained in " + subject + " (out of 100):");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                System.out.println("Enter marks obtained in " + subject + " (out of 100):");
            }
        }
        return marks;
    }

    private static String calculateGrade(double marks) {
        if (marks >= 90) {
            return "A+";
        } else if (marks >= 80) {
            return "A";
        } else if (marks >= 70) {
            return "B";
        } else if (marks >= 60) {
            return "C";
        } else if (marks >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        StudentGrade marks = new StudentGrade();
        marks.calculateTotal();
    }
}