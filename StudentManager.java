package student_management;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
	ArrayList<Student> stu = new ArrayList<>();

	public void addStudent(Scanner sc) {
		System.out.println("Enter your Name: ");
		String name = sc.nextLine();
		System.out.println("Enter Roll Number: ");
		int rollno = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter your Dept: ");
		String dept = sc.nextLine();
		System.out.println("Enter your Email: ");
		String email = sc.nextLine();
		int marks[] = new int[2];
		for (int i = 0; i < marks.length; i++) {
			System.out.print("Enter Marks for Subject" + (i + 1) + ":");
			marks[i] = sc.nextInt();
		}
		Student s1 = new Student(name, rollno, dept, email, marks);
		stu.add(s1);
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
		for (Student s : stu) {
			if (s.getrollno() == updateRoll) {
				System.out.println("Enter your Name: ");
				String name = sc.nextLine();
				System.out.println("Enter Roll Number: ");
				// int rollno = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter your Dept: ");
				String dept = sc.nextLine();
				System.out.println("Enter your Email: ");
				String email = sc.nextLine();
				int marks[] = new int[2];
				for (int i = 0; i < marks.length; i++) {
					System.out.print("Enter Marks for Subject" + (i + 1) + ":");
					marks[i] = sc.nextInt();
				}
				s.setName(name);
				s.setDept(dept);
				s.setEmail(email);
				s.setMarks(marks);
				System.out.println("Student with Roll No " + updateRoll + " updated successfully.");
				break;
			}
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
			int[] marks = s.getMarks();
			int total = 0;
			for (int m : marks) {
				total += m;
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
