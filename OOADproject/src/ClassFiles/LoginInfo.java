package ClassFiles;

import Database.SetUser;

 public class LoginInfo {
	 public int username;
	 private String password;
	 SetUser newUser;
	 public LoginInfo(){
		 newUser = new SetUser();
		 
	 }
	 void setInfo(int user,String pass){
		 newUser.setUser(user, pass);
	 }
}
