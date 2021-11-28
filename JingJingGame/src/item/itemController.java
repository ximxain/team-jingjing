package item;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import util.AppUtil;
import util.JDBCUtil;

public class itemController {
	private ListView<String> lists;
	private JDBCUtil db;
	
	@FXML
	public void initialize() {
		lists.getItems().add("ssss");
		Connection con = db.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		db = new JDBCUtil();
		String sql = "SELECT * FROM `jingjing_users` WHERE userId = " + "'" + user + "'";
	}
	
	public void get() {
		int idx = lists.getSelectionModel().getSelectedIndex();
	}
}
