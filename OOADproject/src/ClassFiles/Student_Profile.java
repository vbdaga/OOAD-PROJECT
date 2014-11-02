package ClassFiles;

import Database.AccessStudent;

public class Student_Profile extends Profile{
	public int enrolledYear;
	public Student_Profile() {
		super();
	}
	Student_Profile(int id) {
		super(id);
		//set enrolled year from database
		AccessStudent access = new AccessStudent();
		enrolledYear = access.getYear(id, this);
	}
	void setStudent_Profile(Student_Profile profile,int id){
		//setProfile((Profile)profile,id);
	}
}