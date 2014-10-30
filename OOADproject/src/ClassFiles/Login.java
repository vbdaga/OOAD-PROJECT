package ClassFiles;

import java.util.Scanner;
import Database.CheckLogin;
public class Login {
	public static void main(String []args){
		Scanner in= new Scanner(System.in);
		CheckLogin chl = new CheckLogin();
		int user;
		String pass;
		while(true){
			user = in.nextInt();
			in.nextLine();
			pass = in.nextLine();
			if(!chl.check(user, pass)){
				System.out.println("Invalid login... :(");
			}
			else{
				System.out.println("Congo");
				break;
			}
		}
		
	}
}
