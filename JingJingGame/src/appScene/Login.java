package appScene;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import util.AppUtil;
import util.JDBCUtil;

public class Login {
	@FXML
	private Button button;
	
	@FXML
	private TextField id;
	
	@FXML
	private TextField pw;

	private JDBCUtil db;
	
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
	
	
	public void clickButton() {
		try {
			db = new JDBCUtil();
			
			Connection con = db.getConnection();
			Statement stmt = null;
			ResultSet rs = null;
			String user = id.getText();
			String pass = pw.getText();
			String sql = "SELECT * FROM `jingjing_users` WHERE userId = " + "'" + user + "'" + "and pass = " + "'" + pass + "'";
			
			try {
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					Parent login = FXMLLoader.load(getClass().getResource("/prolog/prolog.fxml"));
					Scene scene = new Scene(login);
					Stage primaryStage = (Stage) button.getScene().getWindow();
					primaryStage.setScene(scene);
					scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
				}
			}catch (Exception e) {
				e.printStackTrace();
				AppUtil.alert("데이터 삽입 실패", null);
				return;
			}finally {
				if(rs != null) try { rs.close(); } catch (Exception e) {}
				if(stmt != null) try { stmt.close(); } catch (Exception e) {}
				if(con != null) try { con.close(); } catch (Exception e) {}
			}
			
			
			
			
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
}
