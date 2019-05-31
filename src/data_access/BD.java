package data_access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class BD {
	 	public Connection connection = null;
	    public Statement selectStatement = null, insertStatement = null, updateStatement =null,deleteStatement=null;
	    public ResultSet rs = null;
	    public ResultSetMetaData rsmd = null;
	public BD(){
	try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
    }
    catch (Exception ex) {
        System.err.println("An Exception occured during JDBC Driver loading." + 
           " Details are provided below:");
        ex.printStackTrace(System.err);
    }
   
    try {
        connection = DriverManager.getConnection("jdbc:mysql://localhost/OrderManagement?user=root&password=");
        
        
    }
    catch(SQLException sqlex) {
        System.err.println("An SQL Exception occured. Details are provided below:");
        sqlex.printStackTrace(System.err);
    }
    
}}