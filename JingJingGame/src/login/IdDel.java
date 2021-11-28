package login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import util.AppUtil;
import util.JDBCUtil;

public class IdDel {
	@FXML
	private Button button;

	@FXML
	public Button goLogin;

	@FXML
	private TextField id;

	@FXML
	private TextField pw;

	private JDBCUtil db;
	
	public void remove() {
		db = new JDBCUtil();
		Connection con = db.getConnection();
		// PreparedStatement 날릴 것을 저장해두는 곳
		PreparedStatement pstmt = null;
		PreparedStatement pstmtPw = null;
		ResultSet rs = null;
		String addId = id.getText();
		String addPassword = pw.getText();

		if (addId.equals("") || addPassword.equals("")) {
			AppUtil.alert("아이디와 페스워드를 입력하십시오", "");
		} else if(loginChack(addId, addPassword)){
			String sql = "DELETE FROM jingjing_users WHERE userId = '"+addId+"'";
			String sql2 = "DELETE FROM jingjing_currentStat WHERE userId = '"+addId+"'";

			try {
				pstmt = con.prepareStatement(sql);
				pstmt.executeUpdate();
				pstmtPw = con.prepareStatement(sql2);
				pstmtPw.executeUpdate();
				// insert, update, delete

				System.out.println("삭제 성공!!");
				AppUtil.alert(addId + "의 정보가 성공적으로 삭제되었습니다.", "네에네에");

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("삭제 실패!!");
			}
		} else {
			AppUtil.alert(addId + "가 없습니다.", "네에네에");
		}

	}
	
	public void goLogin() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/login/Login.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) goLogin.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean loginChack(String addId, String addPassword) {
		db = new JDBCUtil();
		Connection con = db.getConnection();
		// PreparedStatement 날릴 것을 저장해두는 곳
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select EXISTS (select * from jingjing_users where userId='" + addId + "' and pass = '" + addPassword
				+ "' limit 1) as success;";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println(sql);
			while (rs.next()) {
				int success = rs.getInt("success");
				System.out.println(success);
				if (success == 1) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("success 실패");

		}
		return false;
	}
}
