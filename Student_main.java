package student_management;

import java.util.*;

public class Student_main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==========================================");
            System.out.println("   🎓 Student Record Management System");
            System.out.println("==========================================");

            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by Roll No");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student");
            System.out.println("6. Display Top Performer");
            System.out.println("7. Exit");

            System.out.print("\nEnter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("⚠ Invalid input! Please enter a number.");
                sc.next();
                System.out.print("Enter your choice: ");
            }
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    manager.addStudent(sc);
                    break;
                case 2:
                    manager.viewAllStudents();
                    break;
                case 3:
                    System.out.print("Enter roll number to search: ");
                    int searchRoll = sc.nextInt();
                    manager.searchStudent(searchRoll);
                    break;
                case 4:
                    System.out.print("Enter roll number to delete: ");
                    int deleteRoll = sc.nextInt();
                    manager.deleteStudent(deleteRoll);
                    break;
                case 5:
                    System.out.print("Enter roll number to update: ");
                    int updateRoll = sc.nextInt();
                    sc.nextLine();
                    manager.updateStudent(updateRoll, sc);
                    break;
                case 6:
                    manager.displayTopPerformer();
                    break;
                case 7:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 7);

        sc.close();
    }
}
