package Database;
//STEP 1. Import required packages
import ClassFiles.*;
import ClassFiles.Time;

import java.sql.*;

public class SetProfile {
 // JDBC driver name and database URL
	static  String JDBC_DRIVER=null;
	static  String DB_URL=null;
	static  String USER=null;
	static  String PASS =null;
	Connection conn = null;
	 Statement stmt = null;
	public SetProfile(){
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
public void SetProfileInfo(Profile profile,int id) {
 
 
 try{
    int gender = 0;
    if(profile.gender.g)gender=1;
    String dob = profile.dateOfBirth.year+"-"+profile.dateOfBirth.month+"-"+profile.dateOfBirth.day;
    String sql = "INSERT INTO profile VALUES ( "+id+" , \'"+profile.firstName+"\' , \'"+profile.lastName+"\' , "+gender+" , \'"+profile.department.name+"\' , \'"+dob+"\' , \'"+profile.address+" \' )";
   // System.out.println(sql);
    stmt.executeUpdate(sql);
    //STEP 5: Extract data from result set
    
    
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
}//end SetProfile