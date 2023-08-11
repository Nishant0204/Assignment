package banking;
import java.io.*;
import java.sql.*;
import java.util.*;
public class connection {
	
	    static Connection con; 
	    public static Connection getConnection()
	    {
	        try {
	            
	            
	         
	            String url
	                = "jdbc:mysql://localhost:3306/bank";

	            String user = "root";        
	            String pass = "1234";  
	            Class.forName(
	                    "com.mysql.cj.jdbc.Driver");
	             
	            con = DriverManager.getConnection(url, user,
	                                              pass);
	        }
	        catch (Exception e) {
	            System.out.println("Connection Failed!");
	        }
	 
	        return con;
	    }
	    
	    
	    
	    
	    
	    
	    
	}
	
	
	
	
	
