package ClassFiles;

class Instructor {
	int facultyID ;
	private Profile profile;
	Course course[];
	public Instructor(int id) {
		//access faculty id from database
		//access courses from database
		course = new Course[3];
		for(int i=0;i<3;i++){
			int course_id=0;//from database
			course[i]=new Course(course_id);
		}
		profile = new Profile(id);
	}
	Profile getProfile(){
		return profile;
	}
	Course[] getCourses(){
		return course;
	}
}
// direct access faculty id
//profile and courses thru object
