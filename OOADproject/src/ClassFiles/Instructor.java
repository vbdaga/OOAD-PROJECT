package ClassFiles;
import Database.*;
public class Instructor {
	int facultyID ;
	private Profile profile;
	Course course[];
	public Instructor(int id) {
		//access faculty id from database
		facultyID = id;
		//access courses from database
		course = new Course[3];
		AccessInstructorCourse access = new AccessInstructorCourse();
		for(int i=0;i<3;i++){
			int course_id;//from database
			course_id = access.getCourse(id,i+1);
			course[i]=new Course(course_id);
		}
		profile = new Profile(id);
	}
	public Instructor() {
		// TODO Auto-generated constructor stub
	}
	public Profile getProfile(){
		return profile;
	}
	public Course[] getCourses(){
		return course;
	}
	public void setInstructor(Profile prof,int id,String pass){
		SetInstructor instruct = new SetInstructor();
		instruct.SetInstructorInfo(id);
		SetProfile access = new SetProfile();
		access.SetProfileInfo(prof, id,false);
	}
}
// direct access faculty id
//profile and courses thru object
