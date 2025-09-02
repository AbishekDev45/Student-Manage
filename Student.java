package student_management;

import java.util.HashMap;
import java.util.Map;

public class Student {
	private String name;
	private int rollno;
	private String dept;
	private String email;
	private int TotSub;
	private HashMap<Integer, Integer> marks = new HashMap<>();

	public Student(String name, int rollno, String dept, String email, int TotSub, HashMap<Integer, Integer> marks) {
		this.name = name;
		this.rollno = rollno;
		this.dept = dept;
		this.email = email;
		this.TotSub = TotSub;
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

	public HashMap<Integer, Integer> getMarks() {
		return marks;
	}

	public void setMarks(HashMap<Integer, Integer> marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Student Details:\n")
				.append("-----------------------------\n")
				.append("Name    : ").append(name).append("\n")
				.append("Roll.No : ").append(rollno).append("\n")
				.append("Dept    : ").append(dept).append("\n")
				.append("Email   : ").append(email).append("\n")
				.append("Marks   :\n");

		for (Map.Entry<Integer, Integer> entry : marks.entrySet()) {
			sb.append("   ").append(entry.getKey())
					.append(" : ").append(entry.getValue())
					.append("\n");
		}

		sb.append("-----------------------------\n");
		return sb.toString();
	}

	public int getTotSub() {
		return TotSub;
	}

	public void setTotSub(int TotSub) {
		this.TotSub = TotSub;
	}
}
