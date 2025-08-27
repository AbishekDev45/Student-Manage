package student_management;

import java.util.Arrays;

public class Student {
	private String name;
	private int rollno;
	private String dept;
	private String email;
	private int marks[] = new int[2];

	public Student(String name, int rollno, String dept, String email, int[] marks) {
		this.name = name;
		this.rollno = rollno;
		this.dept = dept;
		this.email = email;
		this.marks = marks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getrollno() {
		return rollno;
	}

	public void setrollno(int rollno) {
		this.rollno = rollno;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int[] getMarks() {
		return marks;
	}

	public void setMarks(int[] marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student Details:\n"
				+ "-----------------------------\n"
				+ "Name    : " + name + "\n"
				+ "Roll.No : " + rollno + "\n"
				+ "Dept    : " + dept + "\n"
				+ "Email   : " + email + "\n"
				+ "Marks   : " + Arrays.toString(marks) + "\n"
				+ "-----------------------------\n";
	}

}
