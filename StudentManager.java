package student_management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class StudentManager {
	ArrayList<Student> stu = new ArrayList<>();
	HashMap<Integer, Integer> m = new HashMap<>();

	public void addStudent(Scanner sc) {
		System.out.println("Enter Roll Number: ");
		int rollno = sc.nextInt();
		sc.nextLine();
		for (Student s : stu) {
			if (s.getrollno() == rollno) {
				System.out
						.println("⚠ Student with Roll No " + rollno + " already exists. Use updateStudent to modify.");
				return; // stop adding
			}
		}
		System.out.println("Enter Name: ");
		String name = sc.nextLine();
		System.out.println("Enter Dept: ");
		String dept = sc.nextLine();
		System.out.println("Enter Email: ");
		String email = sc.nextLine();
		System.out.println("Enter No.of Subjects: ");
		int TotSub = sc.nextInt();

		HashMap<Integer, Integer> marks = new HashMap<>();
		for (int i = 1; i <= TotSub; i++) {
			System.out.print("Enter Marks for Subject " + i + ": ");
			int Marks = sc.nextInt();
			marks.put(i, Marks);
		}

		Student s1 = new Student(name, rollno, dept, email, TotSub, marks);
		stu.add(s1);
		System.out.println("✅ Student added successfully!");
	}

	public void viewAllStudents() {
		for (Student i : stu) {
			System.out.println(i);
		}
	}

	public void searchStudent(int searchRoll) {
		boolean found = false;
		for (Student s : stu) {
			if (s.getrollno() == searchRoll) {
				System.out.println(s);
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("Student with Roll No " + searchRoll + " not found.");
		}
	}

	public void deleteStudent(int deleteRoll) {
		boolean found = false;
		for (int i = 0; i < stu.size(); i++) {
			if (stu.get(i).getrollno() == deleteRoll) {
				stu.remove(i);
				System.out.println("Student with Roll No " + deleteRoll + " deleted successfully.");
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("Student with Roll No " + deleteRoll + " not found.");
		}
	}

	public void updateStudent(int updateRoll, Scanner sc) {
		boolean found = false;

		for (Student s : stu) {
			if (s.getrollno() == updateRoll) {
				found = true;

				System.out.println("What do you want to update?");
				System.out.println("1. Name");
				System.out.println("2. Dept");
				System.out.println("3. Email");
				System.out.println("4. Subjects & Marks");
				int choice = sc.nextInt();
				sc.nextLine();

				switch (choice) {
					case 1 -> {
						System.out.println("Enter new Name: ");
						s.setName(sc.nextLine());
					}
					case 2 -> {
						System.out.println("Enter new Dept: ");
						s.setDept(sc.nextLine());
					}
					case 3 -> {
						System.out.println("Enter new Email: ");
						s.setEmail(sc.nextLine());
					}
					case 4 -> {
						System.out.println("Enter new Total Subjects: ");
						int TotSub = sc.nextInt();
						HashMap<Integer, Integer> marks = new HashMap<>();
						for (int i = 1; i <= TotSub; i++) {
							System.out.print("Enter Marks for Subject " + i + ": ");
							int Marks = sc.nextInt();
							marks.put(i, Marks);
						}
						s.setTotSub(TotSub);
						s.setM(marks);
					}
					default -> System.out.println("⚠ Invalid choice!");
				}

				System.out.println("✅ Student with Roll No " + updateRoll + " updated successfully!");
				break;
			}
		}

		if (!found) {
			System.out.println("⚠ Student with Roll No " + updateRoll + " not found.");
		}
	}

	public void displayTopPerformer() {
		if (stu.isEmpty()) {
			System.out.println("No students available.");
			return;
		}

		Student topStudent = null;
		int highestTotal = -1;

		for (Student s : stu) {

			int total = 0;
			for (int i = 0; i < m.size(); i++) {
				total += m.get(i);
			}
			if (total > highestTotal) {
				highestTotal = total;
				topStudent = s;
			}
		}
		if (topStudent != null) {
			System.out.println("Top Performer:");
			System.out.println("Name: " + topStudent.getName());
			System.out.println("Roll No: " + topStudent.getrollno());
			System.out.println("Total Marks: " + highestTotal);
			System.out.println("-------------------------");
		}
	}

}
