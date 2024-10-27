package electricity.billing.system;

import java.sql.*;

public class Conn {
	
	Connection c;
	Statement s;
	Conn(){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs","root","");
			
			s=c.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
