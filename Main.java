import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // ArrayList to dynamically manage student records
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.util.in);

    public static void main(String[] args) {
        int choice;

        System.out.println("================================================");
        System.out.println("  Welcome to Student Grade Management System");
        System.out.println("================================================");

        do {
            // Interactive UI Menu
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Add a Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search for a Student by ID");
            System.out.println("4. Calculate & Display Average Mark");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            // Read safely from console
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input! Please enter a number between 1 and 5: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear scanner buffer

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    searchStudentById();
                    break;
                case 4:
                    calculateAverageMark();
                    break;
                case 5:
                    System.out.println("\nExiting system. Thank you for using the program!");
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    // Function 1: Add a student
    private static void addStudent() {
        System.out.println("\n--- Add New Student Record ---");
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine().trim();

        // Optional check to ensure IDs remain unique
        for (Student s : studentList) {
            if (s.getStudentId().equalsIgnoreCase(id)) {
                System.out.println("Error: A student with this ID already exists.");
                return;
            }
        }

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter Marks: ");
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid mark format! Enter a number for marks: ");
            scanner.next();
        }
        double marks = scanner.nextDouble();
        scanner.nextLine(); // Clear buffer

        // Enforce valid score range boundaries
        if (marks < 0 || marks > 100) {
            System.out.println("Error: Marks must stay between 0 and 100.");
            return;
        }

        // Instantiate object and append to list
        studentList.add(new Student(id, name, marks));
        System.out.println("Student record added successfully!");
    }

    // Function 2: Display all students
    private static void displayAllStudents() {
        System.out.println("\n--- Registered Student Records ---");
        if (studentList.isEmpty()) {
            System.out.println("No student records available in the system.");
            return;
        }

        System.out.println("------------------------------------------------------------");
        for (Student student : studentList) {
            student.displayStudentDetails();
        }
        System.out.println("------------------------------------------------------------");
    }

    // Function 3: Search for a student by ID
    private static void searchStudentById() {
        System.out.println("\n--- Search Student ---");
        if (studentList.isEmpty()) {
            System.out.println("No records available to search.");
            return;
        }

        System.out.print("Enter Student ID to look up: ");
        String searchId = scanner.nextLine().trim();
        boolean found = false;

        for (Student student : studentList) {
            if (student.getStudentId().equalsIgnoreCase(searchId)) {
                System.out.println("\nRecord Found:");
                System.out.println("------------------------------------------------------------");
                student.displayStudentDetails();
                System.out.println("------------------------------------------------------------");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student with ID '" + searchId + "' could not be found.");
        }
    }

    // Function 4: Calculate and display the average mark
    private static void calculateAverageMark() {
        System.out.println("\n--- Grade Average Metrics ---");
        if (studentList.isEmpty()) {
            System.out.println("No records available to calculate an average.");
            return;
        }

        double totalMarks = 0;
        for (Student student : studentList) {
            totalMarks += student.getMarks();
        }

        double average = totalMarks / studentList.size();
        System.out.printf("Total Active Students: %d\n", studentList.size());
        System.out.printf("Overall Class Average Mark: %.2f\n", average);
    }
}