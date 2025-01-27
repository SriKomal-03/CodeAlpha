import java.util.ArrayList;
import java.util.Scanner;

public class Task_1 {

    public static void main(String[] args) {
        // Create an ArrayList to store student grades
        ArrayList<Integer> studentGrades = new ArrayList<>();
        Scanner inputScanner = new Scanner(System.in);

        // Input student grades
        System.out.println("Enter student grades (-1 to stop):");
        while (true) {
            System.out.print("Enter grade: ");
            int currentGrade = inputScanner.nextInt();
            if (currentGrade == -1) {
                break; // Exit loop when -1 is entered
            } else if (currentGrade < 0 || currentGrade > 100) {
                System.out.println("Invalid grade. Please enter a value between 0 and 100.");
            } else {
                studentGrades.add(currentGrade);
            }
        }

        // Check if grades list is empty
        if (studentGrades.isEmpty()) {
            System.out.println("No grades were entered.");
        } else {
            // Compute and display average, highest, and lowest scores
            double averageGrade = calculateAverage(studentGrades);
            int highestGrade = findHighest(studentGrades);
            int lowestGrade = findLowest(studentGrades);

            System.out.println("\nResults:");
            System.out.println("Total students: " + studentGrades.size());
            System.out.println("Average grade: " + averageGrade);
            System.out.println("Highest grade: " + highestGrade);
            System.out.println("Lowest grade: " + lowestGrade);
        }

        inputScanner.close();
    }

    // Method to calculate the average grade
    public static double calculateAverage(ArrayList<Integer> gradesList) {
        int totalSum = 0;
        for (int grade : gradesList) {
            totalSum += grade;
        }
        return (double) totalSum / gradesList.size();
    }

    // Method to find the highest grade
    public static int findHighest(ArrayList<Integer> gradesList) {
        int highestGrade = gradesList.get(0);
        for (int grade : gradesList) {
            if (grade > highestGrade) {
                highestGrade = grade;
            }
        }
        return highestGrade;
    }

    // Method to find the lowest grade
    public static int findLowest(ArrayList<Integer> gradesList) {
        int lowestGrade = gradesList.get(0);
        for (int grade : gradesList) {
            if (grade < lowestGrade) {
                lowestGrade = grade;
            }
        }
        return lowestGrade;
    }
}
