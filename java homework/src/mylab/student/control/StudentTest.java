package mylab.student.control;

import mylab.student.entity.Student;

public class StudentTest {
	
	
	public static void main(String[] args) {
		Student kim = new Student("100", "��μ�", "��ǻ�Ͱ���", 3);
		int gradechange = 5;
		
		try {
			System.out.println(kim.getName()+ "/" + kim.getGrade()+"/"+ kim.getMajor() + "�г�");
			System.out.printf("%d�г����� ����", gradechange);
			kim.setGrade(gradechange);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
				
				
	}

}
