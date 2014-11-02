package ClassFiles;

import Database.AccessProfile;
import Database.SetProfile;

public class Profile {
	public String firstName,lastName;
	public Gender gender;
	public DOB dateOfBirth;
	public String address;
	public Department department;
	public Profile(){
		
	}
	public Profile(int id){
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
	public void setProfile(Profile profile,int id,String pass){
		SetProfile access = new SetProfile();
		access.SetProfileInfo(profile, id,true);
		LoginInfo login = new LoginInfo();
		login.setInfo(id, pass);
	}
	public void setProfile(Student_Profile profile,int id,String pass){
		SetProfile access = new SetProfile();
		access.SetProfileInfo(profile, id,true);
		LoginInfo login = new LoginInfo();
		login.setInfo(id, pass);
	}
}
