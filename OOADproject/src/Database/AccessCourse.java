package Database;
//STEP 1. Import required packages
import ClassFiles.*;
import ClassFiles.Time;

import java.sql.*;

public class AccessCourse {
 // JDBC driver name and database URL
	static  String JDBC_DRIVER=null;
	static  String DB_URL=null;
	static  String USER=null;
	static  String PASS =null;
	Connection conn = null;
	 Statement stmt = null;
	public AccessCourse(){
JDBC_DRIVER = "com.mysql.jdbc.Driver";  
 DB_URL = "jdbc:mysql://localhost/course";

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
public void getCourseByID(int id, Course course) {
 
 
 try{
    
    String sql = "SELECT course_id, course_name, department, semester, credits, books, classroom_id, start_time ,end_time, numberOfStudents FROM course WHERE  course_id="+id;
   // System.out.println(sql);
    ResultSet rs = stmt.executeQuery(sql);
    //STEP 5: Extract data from result set
    
    while(rs.next()){
        //Retrieve by column name
    	course.name = rs.getString("course_name");
    	course.department = rs.getString("department");
    	course.term = rs.getInt("semester");
    	course.credits = rs.getInt("credits");
    	course.textbooks = rs.getString("books");
    	course.classroom_id = rs.getInt("classroom_id");
    	course.time=new Time();
    	course.time.start = rs.getString("start_time");
    	course.time.end = rs.getString("end_time");
    	course.numberOfStudents = rs.getInt("numberOfStudents");
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
}//end method
public void getCourseByName(String course_name, Course course) {
	 
	 
	 try{
	    
	    String sql = "SELECT course_id, course_name, department, semester, credits, books, classroom_id, start_time ,end_time, numberOfStudents FROM course WHERE  course_name= \'"+course_name+"\'";
	   // System.out.println(sql);
	    ResultSet rs = stmt.executeQuery(sql);
	    //STEP 5: Extract data from result set
	    
	    while(rs.next()){
	        //Retrieve by column name
	    	course.number = rs.getInt("course_id");
	    	course.name = rs.getString("course_name");
	    	course.department = rs.getString("department");
	    	course.term = rs.getInt("semester");
	    	course.credits = rs.getInt("credits");
	    	course.textbooks = rs.getString("books");
	    	course.classroom_id = rs.getInt("classroom_id");
	    	course.time=new Time();
	    	course.time.start = rs.getString("start_time");
	    	course.time.end = rs.getString("end_time");
	    	course.numberOfStudents = rs.getInt("numberOfStudents");
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
	}//end method
public int getCourseID(String course_name) {
	 int id=0;
	 
	 try{
	    
	    String sql = "SELECT course_id FROM course WHERE  course_name= \'"+course_name+"\'";
	   // System.out.println(sql);
	    ResultSet rs = stmt.executeQuery(sql);
	    //STEP 5: Extract data from result set
	    
	    while(rs.next()){
	        //Retrieve by column name
	    	id=rs.getInt("course_id");
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
		 return id;
	   
	 }//end try
	 //System.out.println("Goodbye!");
	}//end method
public boolean updateStudentStrength(int id) {

	 boolean flag=false;
	 try{
	    String sql1 = "SELECT numberOfStudents FROM course WHERE  course_id="+id+"";
	    ResultSet rs =stmt.executeQuery(sql1);
	    int num=0;
	    while(rs.next()){
	    	num=rs.getInt("numberOfStudents");
	    }
	    
	    if(num<75){String sql = "UPDATE course.course SET numberOfStudents="+(num+1)+" WHERE course_id="+id+"";
	   // System.out.println(sql);
	    stmt.executeUpdate(sql);
	    flag=true;
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
		 //return id;
	   
	 }//end try
	 //System.out.println("Goodbye!");
	}//end method
public String[] getCourseList() {
	String course="";
	 try{
	    String sql = "SELECT course_name FROM course";
	    ResultSet rs =stmt.executeQuery(sql);
	    while(rs.next()){
	    	course+=rs.getString("course_name");
	    	course+=",";
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
		 return course.split(",");
		 //return id;
	   
	 }//end try
	 //System.out.println("Goodbye!");
	}//end method
}//end AccessCourse