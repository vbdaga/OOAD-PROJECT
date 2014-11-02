package ClassFiles;

import Database.AccessInstructorCourse;
import Database.AccessStudentCourse;
import Database.SetStudent;

public class Student {
	int studentID;
	private Student_Profile profile;
	private Course course[];
	public Student(){
		
	}
	public Student(int id) {
		//access student id from database
		studentID = id;
		//access courses from database
		course = new Course[4];
		AccessStudentCourse access = new AccessStudentCourse();
		for(int i=0;i<4;i++){
			int course_id;//from database
			int cid=i+1;
			course_id = access.getCourse(id,cid);
			System.out.println(course_id);
			course[i]=new Course(course_id);
			//System.out.println(course[i].number);
		}
		profile =new Student_Profile(id);
	}
	public Profile getProfile(){
		return profile;
	}
	public Course[] getCourses(){
		return course;
	}
	void setStudent(Student_Profile prof,int id){
		SetStudent access = new SetStudent();
		access.setStudentInfo(id, prof);
		Student_Profile student = new Student_Profile();
		student.setStudent_Profile(prof,id);
	}
}
