package banking;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Scanner;

public class bankMangement {
	private static final int NULL = 0;
	static Scanner sc1=new Scanner(System.in);	
    static Connection con = connection.getConnection();
    static String sql = "";
    public static boolean createAccount(String name,int passCode,Double r) throws Exception{
    	if (name == "" || passCode == NULL) {
            System.out.println("All Field Required!");
            return false;
        }
      
        Statement st = con.createStatement();

        sql = String.format("INSERT INTO customer(cname,balance,pass_code) VALUES('%s',%s,'%s');",name,r,passCode) ;

        // Execution
        if (st.executeUpdate(sql) == 1) {
            System.out.println(name+ ", Now You Login!");
            return true;
        }else {System.out.println("FAILED");}
        return false;  
        
    }
    
public static boolean loginAccount(String name,int pas) throws Exception{
	
	if (name == "" || pas == NULL) {
        System.out.println("All Field Required!");
        return false;
    }
	Statement st = con.createStatement();

    sql = String.format("SELECT * FROM customer WHERE cname = '%s' AND pass_code = %s;", name, pas);

    ResultSet resultSet = st.executeQuery(sql);

    if (resultSet.next()) {
        System.out.println("Login Successful!");
        System.out.println("HELLLO "+name);
        boolean f=true;
        while(f) {
	        doprint();
	        int ch=sc1.nextInt();
	    	switch(ch) {
	    	
	    	case 2:
	
	            sql = String.format("SELECT * FROM customer WHERE cname = '%s' AND pass_code = %s;", name, pas);
	            ResultSet resultSet2 = st.executeQuery(sql);
	            if (resultSet2.next()) {
	                double balance = resultSet2.getDouble("balance");
	                System.out.println("Your balance is: " + balance);}
	    		break;
	    	case 5:
	    		System.out.println("******Logged out********");
	    		f=false;
	    		break;
	    	case 1:
	    		System.out.println("Give RECEIVER ACCOUNT no");
	    		int ac_no=sc1.nextInt();
	    		if (check(ac_no)) {
	    			System.out.println("Enter the amount to be send");
	    			double am=sc1.nextDouble();
	    			double balance2=resultSet.getDouble("balance");
	    			
	    			if(am<balance2) {
	    				double ne=balance2-am;
	    				Statement st2 = con.createStatement();
	    				String sql2 = String.format("UPDATE customer SET balance = %f WHERE ac_no = %d;", am, ac_no);
	    				
	    				int rowsUpdated = st2.executeUpdate(sql2);

	    				if (rowsUpdated > 0) {
	    				    System.out.println("Balance DEBITED successfully.");
	    				    sql2 = String.format("UPDATE customer SET balance = %f WHERE cname = '%s' AND pass_code = %s;",ne, name, pas);
		    				
		    				rowsUpdated = st2.executeUpdate(sql2);
	    				    
	    				    
	    				} else {
	    				    System.out.println("TRANSACTION Failed.");
	    				}

	    				st2.close();
	    				
	    				
	    			}else {System.out.println("INSUFFICENT BALANCE");}
	    			
	    			
	    			
	    		}
	    		break;
    	}
        }
        return true;
        
    } 
    else {
        System.out.println("Login Failed!");
        return false;
    }
    
}
public static void doprint() throws Exception{
	System.out.println("1)Transfer Money");
	System.out.println("2)View Balance");
	System.out.println("5)LogOut");
}
public static boolean check(int ac_no) throws Exception{
	Statement st = con.createStatement();

    sql = String.format("SELECT * FROM customer WHERE ac_no = '%s';",ac_no);

    ResultSet resultSet = st.executeQuery(sql);

    if (resultSet.next()) {
    	System.out.println("RECEIVER ACCOUNT IS VALID");return true;
    }else {
    	System.out.println("RECEIVER ACCOUNT IS NOTVALID");return false;
    }
	
}









}