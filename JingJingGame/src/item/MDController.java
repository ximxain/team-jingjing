package item;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import login.Login;
import util.AppUtil;
import util.JDBCUtil;

public class MDController extends Login{
	@FXML
	private ListView<String> lists;
	@FXML
	private ImageView img;
	
	private JDBCUtil db;
	public ArrayList<String> images = new ArrayList<String>();
	public Integer id;
	
	@FXML
	public void initialize() {
		db = new JDBCUtil();
		Connection con = db.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM `MD` WHERE userId = " + "'" + user + "'";
		System.out.println(user);
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String a = rs.getString("MD");
				id = rs.getInt("id");
				
				set(a);
				System.out.println(a);
				Connection con2 = db.getConnection();
				Statement stmt2 = null;
				ResultSet rs2 = null;
				
				String sql2 = "SELECT * FROM `mdDB` WHERE `MD` = " + "'" + a + "'";
				try {
					
					stmt2 = con2.createStatement();
					rs2 = stmt2.executeQuery(sql2);
					
					while(rs2.next()) {
						
						String s = rs2.getString("image");
						System.out.println(s);
						images.add(s);
					}
				}catch(Exception E) {}
				
				
			}
		}catch(Exception E) {
			
		}
	}
	
	public void get() {
		int idx = lists.getSelectionModel().getSelectedIndex();
		System.out.println(images.get(idx));
		String idxs = images.get(idx);
		String url = "resource/MD"+idxs+".jpg";
		Image image = new Image(url);
		img.setImage(image);
	}
	
	public void set(String res) {
		lists.getItems().add(res);
	}
	
	
	public void btn() {
		int idx = lists.getSelectionModel().getSelectedIndex();
		String idxs = images.get(idx);
		
		
		db = new JDBCUtil();
		Connection con = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println(user);
		String sql2 = "DELETE FROM `MD` WHERE `id` = " + "'" + id + "'";
		try {
			pstmt = con.prepareStatement(sql2);
			pstmt.executeUpdate();
			
			
		}catch(Exception E) {
			
		}
		
		sick = 0;
		up();
	}
}
