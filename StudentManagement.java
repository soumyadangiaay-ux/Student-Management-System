import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    int marks;

    Student(int rollNo, String name, int marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    void display() {
        System.out.println("Roll No:" + rollNo);
        System.out.println("Name:" + name);
        System.out.println("Marks:" + marks);
        System.out.println("_ __ __ _ __ _  _ _ _");
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        int choice;
        do {
            System.out.println("\n......Student management system........");
            System.out.println("1.Add Student");
            System.out.println("2.View Students");
            System.out.println("3.Delete Student");
            System.out.println("4.Exit");
            System.out.println("5.enter choice");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("enter roll no:");
                    int roll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name:");
                    String name = sc.nextLine();
                    System.out.print("Enter marks:");
                    int marks = sc.nextInt();
                    students.add(new Student(roll, name, marks));
                    System.out.println("Student Added Successfull:");
                    break;
                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        for (Student s : students) {
                            s.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Roll No to delete: ");
                    int r = sc.nextInt();
                    boolean found = false;

                    for (Student s : students) {
                        if (s.rollNo == r) {
                            students.remove(s);
                            System.out.println("Student Deleted!");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}
