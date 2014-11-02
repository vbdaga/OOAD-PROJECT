package ClassFiles;
import Database.*;
public class Course {
	public int number;
	public String name;
	public String department;
	private Instructor instructor;
	public int term;
	public int credits;
	public String textbooks;
	public int classroom_id;
	public Time time;
	public int numberOfStudents;
	public Course(int id){
		//access database
		//Time time = new Time();
		number = id;
		AccessCourse access=new AccessCourse();
		access.getCourse(id, this);
	}
}
