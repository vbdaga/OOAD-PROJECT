package ClassFiles;

import Database.AccessProfile;
import Database.SetProfile;

public class Profile {
	public String firstName,lastName;
	public Gender gender;
	public DOB dateOfBirth;
	public String address;
	public Department department;
	Profile(){
		
	}
	Profile(int id){
		//access database and set values
		AccessProfile access = new AccessProfile();
		access.getProfile(id, this);
	}
	String getFirstName(){
		return firstName;
	}
	String getLastName(){
		return lastName;
	}
	boolean getGender(){
		return gender.g;
	}
	String getDOB(){
		String dob=dateOfBirth.year+"-"+dateOfBirth.month+"-"+dateOfBirth.day;
		return dob;
	}
	String getAddress(){
		return address;
	}
	String getDepartment(){
		return department.name;
	}
	void setProfile(Student_Profile profile,int id){
		SetProfile access = new SetProfile();
		access.SetProfileInfo(profile, id);
	}
}
