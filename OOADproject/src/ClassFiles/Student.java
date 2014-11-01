package ClassFiles;

import Database.AccessInstructorCourse;
import Database.setStudent;

class Student {
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
		AccessInstructorCourse access = new AccessInstructorCourse();
		for(int i=0;i<4;i++){
			int course_id;//from database
			course_id = access.getCourse(id,i+1);
			course[i]=new Course(course_id);
		}
		profile =new Student_Profile(id);
	}
	Profile getProfile(){
		return profile;
	}
	Course[] getCourses(){
		return course;
	}
	void setStudent(Student_Profile prof,int id){
		setStudent access = new setStudent();
		access.setStudentInfo(id, prof);
		Student_Profile student = new Student_Profile();
		student.setStudent_Profile(prof,id);
	}
}
