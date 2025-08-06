package mylab.student.control;

import mylab.student.entity.Student;

public class StudentTest {
	
	
	public static void main(String[] args) {
		Student kim = new Student("100", "김민수", "컴퓨터공학", 3);
		int gradechange = 5;
		
		try {
			System.out.println(kim.getName()+ "/" + kim.getGrade()+"/"+ kim.getMajor() + "학년");
			System.out.printf("%d학년으로 변경", gradechange);
			kim.setGrade(gradechange);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
				
				
	}

}
