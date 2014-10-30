package ClassFiles;

class Student {
	int studentID;
	private Student_Profile profile;
	Course course[];
	public Student(int id) {
		//access student id from database
		//access courses from database
		course = new Course[4];
		for(int i=0;i<4;i++){
			int course_id=0;//from database
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
}
