package login;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	//징징이의 스텟
	static public int grows;
	static public int presentLevel;
	static public int presentExperience;
	static public int money;
	
	
	
	
	@FXML
	private Button button;
	
	@FXML
	private Button signUp;
	
	@FXML
	private TextField id;
	
	@FXML
	private TextField pw;

	private JDBCUtil db;
	
	public static String user;
	
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
	
	
	public void clickButton() {
		try {
			db = new JDBCUtil();
			
			Connection con = db.getConnection();
			Connection conStat = db.getConnection();
			Statement stmt = null;
			Statement stmtStat = null;
			ResultSet rs = null;
			ResultSet rsStat = null;
			
			
			user = id.getText();
			String pass = pw.getText();
			
			
			String sql = "SELECT * FROM `jingjing_users` WHERE userId = " + "'" + user + "'" + "and pass = " + "'" + pass + "'";
			String sql2 = "SELECT * FROM `jingjing_currentStat` WHERE userId = " + "'" + user + "'";
			
			
			
//			db = new JDBCUtil();
//			
//			Connection con = db.getConnection();
//			Statement stmtStat = null;
//			ResultSet rs = null;
//			String user = "aaaa";
//			String sql = "SELECT * FROM `jingjing_currentStat` WHERE userId = " + "'" + user + "'";
//			
//			try {
//				stmt = con.createStatement();
//				rs = stmt.executeQuery(sql);
//				while(rs.next()) {
//					Integer grows = rs.getInt("grows");
//					Integer money = rs.getInt("money");
//					presentLevel = rs.getInt("exp");
//					
//				}
//			}catch (Exception e) {
//				e.printStackTrace();
//				AppUtil.alert("데이터 삽입 실패", null);
//				return;
//			}finally {
//				if(rs != null) try { rs.close(); } catch (Exception e) {}
//				if(stmt != null) try { stmt.close(); } catch (Exception e) {}
//				if(con != null) try { con.close(); } catch (Exception e) {}
//			}
			
			try {
				
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql);
				stmtStat = conStat.createStatement();
				rsStat = stmtStat.executeQuery(sql2);
				boolean logins = rs.next();
				
				
				
				
				if(logins){
					
					while (rsStat.next()) {
					presentLevel = rsStat.getInt("grows");
					presentExperience = rsStat.getInt("exp");
					money = rsStat.getInt("money");
					}
					
					System.out.println("User: "+user);
					System.out.println("exp: "+presentExperience);
					System.out.println("grows: "+presentLevel);
					System.out.println("money: "+money);
					
					
					System.out.println("프롤로그 시청 여부 확인 중...");
					Integer prolog = rs.getInt("prolog");
					
					if(prolog == 0) {
						System.out.println("프롤로그 시청 시작");
						Parent login = FXMLLoader.load(getClass().getResource("/prolog/prolog.fxml"));
						Scene scene = new Scene(login);
						Stage primaryStage = (Stage) button.getScene().getWindow();
						primaryStage.setScene(scene);
						scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
					}else {
						System.out.println("프롤로그 시청 여부 있음");
						Parent login = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));
						Scene scene = new Scene(login);
						Stage primaryStage = (Stage) button.getScene().getWindow();
						primaryStage.setScene(scene);
						scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
					}
					
					
				}
				else if(logins == false) {
					AppUtil.alert("로그인 오류", "아이디 또는 비밀번호가 틀렸습니다");
				}
			}catch (Exception e) {
				e.printStackTrace();
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
	
	public void toSignUp() {
		Parent login;
		try {
			login = FXMLLoader.load(getClass().getResource("/login/SignUp.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) button.getScene().getWindow();
			primaryStage.setScene(scene);
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
