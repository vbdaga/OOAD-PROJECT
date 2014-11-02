package Database;
//STEP 1. Import required packages
import ClassFiles.*;
import ClassFiles.Time;

import java.sql.*;

public class AccessProfile {
 // JDBC driver name and database URL
	static  String JDBC_DRIVER=null;
	static  String DB_URL=null;
	static  String USER=null;
	static  String PASS =null;
	Connection conn = null;
	 Statement stmt = null;
	public AccessProfile(){
JDBC_DRIVER = "com.mysql.jdbc.Driver";  
 DB_URL = "jdbc:mysql://localhost/profile";

 //  Database credentials
 USER = "root";
PASS = "Dvaib2207";
//STEP 2: Register JDBC driver
try{
Class.forName("com.mysql.jdbc.Driver");

//STEP 3: Open a connection
// System.out.println("Connecting to a selected database...");
conn = DriverManager.getConnection(DB_URL, USER, PASS);
// System.out.println("Connected database successfully...");

//STEP 4: Execute a query
//System.out.println("Creating statement...");
stmt = conn.createStatement();
}
catch(Exception e){
	
}
	}
public void getProfile(int id, Profile profile) {
 
 
 try{
    
    String sql = "SELECT first_name, last_name, gender, department_name, DOB, address FROM profile WHERE  id="+id;
   // System.out.println(sql);
    ResultSet rs = stmt.executeQuery(sql);
    //STEP 5: Extract data from result set
    
    while(rs.next()){
        //Retrieve by column name
    	profile.firstName = rs.getString("first_name");
    	profile.lastName = rs.getString("last_name");
    	boolean gen = true;
    	int g=rs.getInt("gender");
    	if(g==0)gen=false;
    	profile.gender=new Gender();
    	String dob=rs.getString("DOB");
    	String s[]=dob.split("-");
    	profile.dateOfBirth=new DOB();
    	profile.dateOfBirth.year=Integer.parseInt(s[0]);
    	profile.dateOfBirth.month=Integer.parseInt(s[1]);
    	profile.dateOfBirth.day=Integer.parseInt(s[2]);
    	profile.address = rs.getString("address");
    	String dept = rs.getString("department_name");
    	profile.department = new Department();
    	profile.department.name= dept;
     }
    rs.close();
 }catch(SQLException se){
    //Handle errors for JDBC
    se.printStackTrace();
 }catch(Exception e){
    //Handle errors for Class.forName
    e.printStackTrace();
 }finally{
    //finally block used to close resources
	 try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   
 }//end try
 //System.out.println("Goodbye!");
}//end main
}//end AccessProfile