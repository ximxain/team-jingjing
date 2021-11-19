package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String connectionString = "jdbc:mysql://yark.yydhsoft.com/skills06";
		String userId = "skills06";
		String password = "1q2w";
		
		Connection con = null;
		try {
			con = DriverManager
					.getConnection(connectionString, userId, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return con;
		
	}
}