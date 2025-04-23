package lab.student.control;
import lab.student.entity.Student;

public class StudentTest {
	
	public static void main(String[] args) {
		Student std1 = new Student("1", "±è¹Î¼ö", "ÄÄÇ»ÅÍ°øÇĞ", 3);
		System.out.println(std1.getName() + " / " 
							+ std1.getMajor() + " / " 
							+ std1.getGrade() + "ÇĞ³â");
		std1.setGrade(5);
	}
}