package Database;
//STEP 1. Import required packages
import ClassFiles.*;
import ClassFiles.Time;

import java.sql.*;

import com.mysql.jdbc.UpdatableResultSet;

public class SetStudent {
 // JDBC driver name and database URL
	static  String JDBC_DRIVER=null;
	static  String DB_URL=null;
	static  String USER=null;
	static  String PASS =null;
	Connection conn = null;
	 Statement stmt = null;
	public SetStudent(){
JDBC_DRIVER = "com.mysql.jdbc.Driver";  
 DB_URL = "jdbc:mysql://localhost/students";

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
public void setStudentInfo(int id, Student_Profile profile) {
 
 
 try{
    
    String sql = "INSERT INTO student VALUES ( "+id+" , 0 , 0 , 0 , 0 , \'"+profile.enrolledYear+"\')";
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
public boolean setStudentCourse(int course,int id) {
	 boolean flag= false;
	 
	 try{
	    String sql1 = "SELECT * FROM student WHERE id="+id+"";
	    ResultSet rs=stmt.executeQuery(sql1);
	    int noOfcolumns= rs.getMetaData().getColumnCount();
	    int i=-1;
	    while(rs.next()){
	    for(i=0;i<noOfcolumns;i++){
	    	System.out.println(rs.getInt(i+2));
	    	if((rs.getInt(i+2))==0)break;
	    }
	    }
	    if(i!=noOfcolumns&&i>=0){String sql = "UPDATE students.student SET course"+(i+1)+"="+course+" WHERE id="+id+"";
	   // System.out.println(sql);
	    	flag=true;
	    	AccessCourse access = new AccessCourse();
	    	flag=access.updateStudentStrength(course);
	    	if(flag)stmt.executeUpdate(sql);
	    }
	    //STEP 5: Extract data from result set
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
		 return flag;
	   
	 }//end try
	 //System.out.println("Goodbye!");
	}//end main
}//end setStudent