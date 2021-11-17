package appScene;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String connectionString = "jdbc:mysql://www.yydhsoft.com/skills06";
		String userId = "skills06";
		String password = "1q2w3e4r";
		
		Connection con = null;
		try {
			con = DriverManager
					.getConnection(connectionString, userId, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return con;
	
	}
	
	public static void close(ResultSet rs) {
		try {if(rs != null) rs.close();} catch (Exception e) {}
	}
	
	public static void close(PreparedStatement ps) {
		try {if(ps != null) ps.close();	} catch (Exception e) {}
	}
	
	public static void close(Connection co) {
		try {if(co != null) co.close();	} catch (Exception e) {}
	}
}
