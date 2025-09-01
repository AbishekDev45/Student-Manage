package student_management;

import java.util.*;

public class Student_main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println(
                    ConsoleColors.PURPLE + "\n==========================================" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN + "   🎓 Student Record Management System" + ConsoleColors.RESET);
            System.out
                    .println(ConsoleColors.PURPLE + "==========================================" + ConsoleColors.RESET);

            System.out.println(ConsoleColors.YELLOW + "1. Add Student" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.YELLOW + "2. View All Students" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.YELLOW + "3. Search Student by Roll No" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.YELLOW + "4. Delete Student" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.YELLOW + "5. Update Student" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.YELLOW + "6. Display Top Performer" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.YELLOW + "7. Exit" + ConsoleColors.RESET);

            System.out.print(ConsoleColors.BLUE + "\n👉 Enter your choice: " + ConsoleColors.RESET);

            while (!sc.hasNextInt()) {
                System.out.println(ConsoleColors.RED + "⚠ Invalid input! Please enter a number." + ConsoleColors.RESET);
                sc.next();
                System.out.print(ConsoleColors.BLUE + "👉 Enter your choice: " + ConsoleColors.RESET);
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
                    System.out.print(ConsoleColors.BLUE + "🔍 Enter roll number to search: " + ConsoleColors.RESET);
                    int searchRoll = sc.nextInt();
                    manager.searchStudent(searchRoll);
                    break;
                case 4:
                    System.out.print(ConsoleColors.BLUE + "❌ Enter roll number to delete: " + ConsoleColors.RESET);
                    int deleteRoll = sc.nextInt();
                    manager.deleteStudent(deleteRoll);
                    break;
                case 5:
                    System.out.print(ConsoleColors.BLUE + "✏ Enter roll number to update: " + ConsoleColors.RESET);
                    int updateRoll = sc.nextInt();
                    sc.nextLine();
                    manager.updateStudent(updateRoll, sc);
                    break;
                case 6:
                    manager.displayTopPerformer();
                    break;
                case 7:
                    System.out.println(ConsoleColors.GREEN + "✅ Exiting... Goodbye!" + ConsoleColors.RESET);
                    break;
                default:
                    System.out.println(ConsoleColors.RED + "⚠ Invalid choice. Try again." + ConsoleColors.RESET);
            }
        } while (choice != 7);

        sc.close();
    }
}
