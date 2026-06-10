public class Student {
    // Encapsulated fields (Private attributes)
    private String studentId;
    private String studentName;
    private double marks;

    // Constructor to initialize student details
    public Student(String studentId, String studentName, double marks) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.marks = marks;
    }

    // Getlers and Setters
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    // Helper method to display single student details cleanly
    public void displayStudentDetails() {
        System.out.printf("ID: %-12s | Name: %-20s | Marks: %.2f\n", studentId, studentName, marks);
    }
}