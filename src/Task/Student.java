package Task;

public class Student {
	private String studentId;
	private String name;
	private String major;
	private int grade;
	public String getStudentId() {
		return studentId;
	}
	
	// getter, setter
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		if(grade<1 || grade>4) {
			System.out.println("�г��� 1~4 ���̿��� �մϴ�.");
		}else {
			this.grade = grade;
		}
	}
	
	@Override
	public String toString() {
		return name + " / " + major + " / " + grade + "�г�";
	}
	
	public static void main(String[] args) {
		Student std1 = new Student();
		std1.setName("��μ�");
		std1.setMajor("��ǻ�Ͱ���");
		std1.setGrade(3);
		System.out.println(std1.toString());
		std1.setGrade(5);
	}

}