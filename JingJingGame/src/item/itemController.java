package item;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import login.Login;
import util.AppUtil;
import util.JDBCUtil;

public class itemController extends Login{
	private ListView<String> lists;
	private JDBCUtil db;
	public ArrayList<String> pitches = new ArrayList<String>();
	
	@FXML
	public void initialize() {
		db = new JDBCUtil();
		Connection con = db.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		db = new JDBCUtil();
		String sql = "SELECT * FROM `food` WHERE userId = " + "'" + user + "'";
		System.out.println(user);
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String a = rs.getString("food");
				System.out.println(a);
				lists.getItems().add(a);
				
			}
		}catch(Exception E) {
			
		}
	}
	
	public void get() {
		int idx = lists.getSelectionModel().getSelectedIndex();
	}
	
	public void set(String res) {
		
	}
	
}
