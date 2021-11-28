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
	static public int grows = 0;
	static public int presentLevel = 0;
	static public int presentExperience = 0;
	static public int money = 0;
	static public int hungry = 0;
	static public int sick = 0;
	
	static public int event1;
	static public int event2;
	static public int event3;
	
	public int limitExperience = 1000;
	
	
	@FXML
	private Button button;
	
	@FXML
	private Button signUp;
	
	@FXML
	private TextField id;
	
	@FXML
	private TextField pw;

	private JDBCUtil db;
	private JDBCUtil db2;
	
	public static String user;
	
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
	
	
	public void clickButton() {
		try {
			db = new JDBCUtil();
			db2 = new JDBCUtil();
			
			Connection con = db.getConnection();
			Connection conStat = db2.getConnection();
			Statement stmt = null;
			Statement stmtStat = null;
			ResultSet rs = null;
			ResultSet rsStat = null;
			
			
			user = id.getText();
			String pass = pw.getText();
			
			
			String sql = "SELECT * FROM `jingjing_users` WHERE userId = " + "'" + user + "'" + "and pass = " + "'" + pass + "'";
			String sql2 = "SELECT * FROM `jingjing_currentStat` WHERE userId = " + "'" + user + "'";
			
			
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
					hungry = rsStat.getInt("hungry");
					sick = rsStat.getInt("sick");
					}
					
					System.out.println("User: "+user);
					System.out.println("exp: "+presentExperience);
					System.out.println("grows: "+presentLevel);
					System.out.println("money: "+money);
					
					
					event1 = rs.getInt("event1");
					System.out.println("event1 : "+event1);
					event2 = rs.getInt("event2");
					System.out.println("event2 : "+event2);
					event3 = rs.getInt("event3");
					System.out.println("event3 : "+event3);
					
					
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
	
	public void up() {
		util.JDBCUtil db = new util.JDBCUtil();
		Connection con = db.getConnection();
		// PreparedStatement 날릴 것을 저장해두는 곳
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//check grows
		if(presentExperience <= limitExperience && presentLevel <= 3) {
			System.out.println("레벨 업!");
			presentLevel ++;
		}
		
		String sql = "UPDATE jingjing_currentStat SET grows = "+grows+", exp =" + presentExperience +" , money =" + money + ", grows = "+presentLevel+", hungry = " +hungry+ " , sick = "+sick+" where userId ='"+user+"'";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();

			System.out.println("정보가 데이터 베이스로 갔어요");
			System.out.println("exp: "+presentExperience);
			System.out.println("money: "+money);
			System.out.println("level: "+presentLevel);

			// insert, update, delete

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("정보가 데이터 베이스로 못감 ㅋㅋ");
		}
	}
	
	
	
	
}
