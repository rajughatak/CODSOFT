import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String studentId;
    private String name;
    private int age;
    private String newName;
    private int newAge;

     Student(String studentId, String name, int age) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;

    }

    // Getters and setters

    @Override
    public String toString() {
        return "Student ID: " + studentId + "\nName: " + name + "\nAge: " + age;
    }
    public Object getStudentId(){
        return studentId;
    }
    public Object setName(){
        return newName;
    }
    public Object setAge(){
        return newAge;
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student findStudentById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    public void editStudentDetails(String studentId, String newName, int newAge) {
        Student student = findStudentById(studentId);
        if (student != null) {
            student.setName();
            student.setAge();
            students.add(student);
            System.out.println("Student details updated successfully! ");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
            System.out.println("*************");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem system = new StudentManagementSystem();

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Find Student by ID");
            System.out.println("3. Edit Student Details");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Student newStudent = new Student(studentId, name, age);
                    system.addStudent(newStudent);
                    System.out.println("Student added successfully!");
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    String searchId = scanner.nextLine();
                    Student foundStudent = system.findStudentById(searchId);
                    if (foundStudent != null) {
                        System.out.println("Student Found:\n" + foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    String editId = scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    system.editStudentDetails(editId, newName, newAge);
                    Student newStudent1 = new Student(editId,newName, newAge);
                    system.addStudent(newStudent1);
                    break;
                case 4:
                    System.out.println("All Students:");
                    system.displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting Student management Application");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}

