package lab.student.entity;

public class Student {
	private String studentId;
	private String name;
	private String major;
	private int grade;
	
	public Student(String studentId, String name, String major, int grade) {
		this.studentId = studentId;
		this.name = name;
		this.major = major;
		this.grade = grade;
	}

	// getter, setter
	public String getStudentId() {
		return studentId;
	}
	
	public String getName() {
		return name;
	}
	
	public String getMajor() {
		return major;
	}
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		if(grade<1 || grade>4) {
			System.out.println("학년은 1~4 사이여야 합니다.");
		}else {
			this.grade = grade;
		}
	}
	
	/*@Override
	public String toString() {
		return name + " / " + major + " / " + grade + "학년";
	}*/
}