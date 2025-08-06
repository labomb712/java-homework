package mylab.student.entity;
import javax.activity.InvalidActivityException;


public class Student{
	private String studentId;
	private String name;
	private String major;
	private int grade;
	
	public Student(String studentId, String major, String name, int grade) {
		this.studentId = studentId;
		this.major = major;
		this.name = name;
		this.grade = grade;
	}
	
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId() {
		this.name = studentId;
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
	
	public void setGrade(int grade) throws InvalidActivityException{
		
			if(grade > 4) {
				throw new InvalidActivityException("학년은 1~4 사이여야 합니다.\n");
			}else {
				this.grade = grade;
		}
	}

	
}
