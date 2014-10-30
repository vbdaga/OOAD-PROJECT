package Database;
//STEP 1. Import required packages
import java.sql.*;

public class CreatingDatabase {
 // JDBC driver name and database URL
 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
 static final String DB_URL = "jdbc:mysql://localhost/";

 //  Database credentials
 static final String USER = "root";
 static final String PASS = "Dvaib2207";
 
 public static void main(String[] args) {
 Connection conn = null;
 Statement stmt = null;
 try{
    //STEP 2: Register JDBC driver
    Class.forName("com.mysql.jdbc.Driver");

    //STEP 3: Open a connection
    System.out.println("Connecting to database...");
    conn = DriverManager.getConnection(DB_URL, USER, PASS);

    //STEP 4: Execute a query
    System.out.println("Creating database...");
    stmt = conn.createStatement();
    /*String sql = "CREATE DATABASE PROFILE";
    String sql1 = "CREATE DATABASE STUDENTS";
    String sql2 = "CREATE DATABASE INSTRUCTOR";
    String sql3 = "CREATE DATABASE COURSE";*/
    //String sql4 = "CREATE DATABASE LOGININFO";
   // String sql5 = "CREATE DATABASE DEPARTMENT";
    String sql6 = "CREATE DATABASE CLASSROOM";
    /*stmt.executeUpdate(sql);
    stmt.executeUpdate(sql1);
    stmt.executeUpdate(sql2);
    stmt.executeUpdate(sql3);*/
    //stmt.executeUpdate(sql4);
    //stmt.executeUpdate(sql5);
    stmt.executeUpdate(sql6);
    System.out.println("Database created successfully...");
 }catch(SQLException se){
    //Handle errors for JDBC
    se.printStackTrace();
 }catch(Exception e){
    //Handle errors for Class.forName
    e.printStackTrace();
 }finally{
    //finally block used to close resources
    try{
       if(stmt!=null)
          stmt.close();
    }catch(SQLException se2){
    }// nothing we can do
    try{
       if(conn!=null)
          conn.close();
    }catch(SQLException se){
       se.printStackTrace();
    }//end finally try
 }//end try
 System.out.println("Goodbye!");
}//end main
}//end CreatingDatabase