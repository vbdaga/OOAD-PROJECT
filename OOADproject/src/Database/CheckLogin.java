package Database;
//STEP 1. Import required packages
import java.sql.*;

public class CheckLogin {
 // JDBC driver name and database URL
	static  String JDBC_DRIVER=null;
	static  String DB_URL=null;
	static  String USER=null;
	static  String PASS =null;
	public CheckLogin(){
JDBC_DRIVER = "com.mysql.jdbc.Driver";  
 DB_URL = "jdbc:mysql://localhost/logininfo";

 //  Database credentials
 USER = "root";
PASS = "Dvaib2207";
	}
public boolean check(int user, String pass) {
 Connection conn = null;
 Statement stmt = null;
 boolean flag=false;
 try{
    //STEP 2: Register JDBC driver
    Class.forName("com.mysql.jdbc.Driver");

    //STEP 3: Open a connection
   // System.out.println("Connecting to a selected database...");
    conn = DriverManager.getConnection(DB_URL, USER, PASS);
   // System.out.println("Connected database successfully...");
    
    //STEP 4: Execute a query
    //System.out.println("Creating statement...");
    stmt = conn.createStatement();

    String sql = "SELECT username, password FROM info WHERE ( username="+user+" AND password= '"+pass+"' )";
   // System.out.println(sql);
    ResultSet rs = stmt.executeQuery(sql);
    //STEP 5: Extract data from result set
    
    while(rs.next()){
        //Retrieve by column name
    	
        flag= true;
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
    return flag;
 }//end try
 //System.out.println("Goodbye!");
}//end main
}//end CheckLogin