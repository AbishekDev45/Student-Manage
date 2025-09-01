package student_management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentManager {
	ArrayList<Student> stu = new ArrayList<>();
	HashMap<Integer, Integer> marks = new HashMap<>();

	public void addStudent(Scanner sc) {
		try {
			System.out.println(ConsoleColors.CYAN + "Enter Roll Number: " + ConsoleColors.RESET);
			int rollno = sc.nextInt();
			sc.nextLine();

			for (Student s : stu) {
				if (s.getrollno() == rollno) {
					System.out.println(ConsoleColors.YELLOW +
							"⚠ Student with Roll No " + rollno + " already exists. Use updateStudent to modify."
							+ ConsoleColors.RESET);
					return;
				}
			}

			System.out.println(ConsoleColors.CYAN + "Enter Name: " + ConsoleColors.RESET);
			String name = sc.nextLine();
			System.out.println(ConsoleColors.CYAN + "Enter Dept: " + ConsoleColors.RESET);
			String dept = sc.nextLine();
			System.out.println(ConsoleColors.CYAN + "Enter Email: " + ConsoleColors.RESET);
			String email = sc.nextLine();

			System.out.println(ConsoleColors.CYAN + "Enter No.of Subjects: " + ConsoleColors.RESET);
			int TotSub = sc.nextInt();

			HashMap<Integer, Integer> marks = new HashMap<>();
			for (int i = 1; i <= TotSub; i++) {
				System.out.print(ConsoleColors.BLUE + "Enter Marks for Subject " + i + ": " + ConsoleColors.RESET);
				int Marks = sc.nextInt();
				marks.put(i, Marks);
			}

			Student s1 = new Student(name, rollno, dept, email, TotSub, marks);
			stu.add(s1);
			System.out.println(ConsoleColors.GREEN + "✅ Student added successfully!" + ConsoleColors.RESET);

		} catch (InputMismatchException e) {
			System.out.println(ConsoleColors.RED + "⚠ Invalid input! Please enter numbers only where required."
					+ ConsoleColors.RESET);
			sc.nextLine();
		}
	}

	public void viewAllStudents() {
		if (stu.isEmpty()) {
			System.out.println(ConsoleColors.YELLOW + "⚠ No students found!" + ConsoleColors.RESET);
			return;
		}
		for (Student i : stu) {
			System.out.println(ConsoleColors.PURPLE + i + ConsoleColors.RESET);
		}
	}

	public void searchStudent(int searchRoll) {
		boolean found = false;
		for (Student s : stu) {
			if (s.getrollno() == searchRoll) {
				System.out.println(ConsoleColors.GREEN + s + ConsoleColors.RESET);
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println(
					ConsoleColors.RED + "⚠ Student with Roll No " + searchRoll + " not found." + ConsoleColors.RESET);
		}
	}

	public void deleteStudent(int deleteRoll) {
		boolean found = false;
		for (int i = 0; i < stu.size(); i++) {
			if (stu.get(i).getrollno() == deleteRoll) {
				stu.remove(i);
				System.out.println(ConsoleColors.GREEN + "✅ Student with Roll No " + deleteRoll
						+ " deleted successfully." + ConsoleColors.RESET);
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println(
					ConsoleColors.RED + "⚠ Student with Roll No " + deleteRoll + " not found." + ConsoleColors.RESET);
		}
	}

	public void updateStudent(int updateRoll, Scanner sc) {
		boolean found = false;

		for (Student s : stu) {
			if (s.getrollno() == updateRoll) {
				found = true;

				System.out.println(ConsoleColors.CYAN + "What do you want to update?" + ConsoleColors.RESET);
				System.out.println("1. Name");
				System.out.println("2. Dept");
				System.out.println("3. Email");
				System.out.println("4. Subjects & Marks");
				int choice = sc.nextInt();
				sc.nextLine();

				switch (choice) {
					case 1 -> {
						System.out.println(ConsoleColors.CYAN + "Enter new Name: " + ConsoleColors.RESET);
						s.setName(sc.nextLine());
					}
					case 2 -> {
						System.out.println(ConsoleColors.CYAN + "Enter new Dept: " + ConsoleColors.RESET);
						s.setDept(sc.nextLine());
					}
					case 3 -> {
						System.out.println(ConsoleColors.CYAN + "Enter new Email: " + ConsoleColors.RESET);
						s.setEmail(sc.nextLine());
					}
					case 4 -> {
						System.out.println(ConsoleColors.CYAN + "Enter new Total Subjects: " + ConsoleColors.RESET);
						int TotSub = sc.nextInt();
						HashMap<Integer, Integer> marks = new HashMap<>();
						for (int i = 1; i <= TotSub; i++) {
							System.out.print(
									ConsoleColors.BLUE + "Enter Marks for Subject " + i + ": " + ConsoleColors.RESET);
							int Marks = sc.nextInt();
							marks.put(i, Marks);
						}
						s.setTotSub(TotSub);
						s.setMarks(marks);
					}
					default -> System.out.println(ConsoleColors.RED + "⚠ Invalid choice!" + ConsoleColors.RESET);
				}

				System.out.println(ConsoleColors.GREEN + "✅ Student with Roll No " + updateRoll
						+ " updated successfully!" + ConsoleColors.RESET);
				break;
			}
		}

		if (!found) {
			System.out.println(
					ConsoleColors.RED + "⚠ Student with Roll No " + updateRoll + " not found." + ConsoleColors.RESET);
		}
	}

	public void displayTopPerformer() {
		if (stu.isEmpty()) {
			System.out.println(ConsoleColors.YELLOW + "⚠ No students available." + ConsoleColors.RESET);
			return;
		}

		Student topStudent = null;
		int highestTotal = -1;

		for (Student s : stu) {
			int total = 0;
			for (int mark : s.getMarks().values()) {
				total += mark;
			}
			if (total > highestTotal) {
				highestTotal = total;
				topStudent = s;
			}
		}
		if (topStudent != null) {
			System.out.println(ConsoleColors.PURPLE + "🏆 Top Performer:" + ConsoleColors.RESET);
			System.out.println(ConsoleColors.GREEN + "Name: " + topStudent.getName() + ConsoleColors.RESET);
			System.out.println(ConsoleColors.GREEN + "Roll No: " + topStudent.getrollno() + ConsoleColors.RESET);
			System.out.println(ConsoleColors.GREEN + "Total Marks: " + highestTotal + ConsoleColors.RESET);
			System.out.println(ConsoleColors.CYAN + "-------------------------" + ConsoleColors.RESET);
		}
	}
}
