package item;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import login.Login;
import util.AppUtil;
import util.JDBCUtil;

public class itemController extends Login{
	private ListView<String> lists;
	private JDBCUtil db;
	public String food
	
	@FXML
	public void initialize() {
		
		Connection con = db.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		db = new JDBCUtil();
		String sql = "SELECT * FROM `food` WHERE userId = " + "'" + user + "'";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				presentLevel = rs.getInt("food");
			}
		}catch(Exception E) {
			
		}
	}
	
	public void get() {
		int idx = lists.getSelectionModel().getSelectedIndex();
	}
	
	public void set(String res) {
		lists.getItems().add(res);
	}
}
