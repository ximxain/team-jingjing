package login;

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

public class SignUp {
	@FXML
	private Button button;

	@FXML
	private TextField id;

	@FXML
	private TextField pw;

	private JDBCUtil db;

	public void clickButton() {
		try {
			db = new JDBCUtil();

			Connection con = db.getConnection();
			Connection con2 = db.getConnection();
			Statement stmt = null;
			ResultSet rs = null;
			String user = id.getText();
			String pass = pw.getText();
			System.out.println(user);
			String sql = "SELECT * FROM `jingjing_users` WHERE userId = " + "'" + user + "'";
			
			if (user.equals("") || pass.equals("")) {
				AppUtil.alert("아이디나 비밀번호가 공백입니다.", null);

			}else {
				try {
					stmt = con.createStatement();
					rs = stmt.executeQuery(sql);

					boolean logins = rs.next();
					System.out.println(logins);
					if (logins == true) {
						AppUtil.alert("이미 있는 아이디입니다.", null);
					}

					if (logins == false) {
						PreparedStatement pstmt = null;
						PreparedStatement pstmt2 = null;
						sql = "INSERT INTO `jingjing_users`(`userId`, `pass`) VALUES (" + "'" + user + "', '" + pass
								+ "')";
						System.out.println(sql);
						String sql2 = "INSERT INTO `jingjing_currentStat`(`userId`, `grows`, `money`, `exp`) VALUES (" + "'" + user + "', 0, 0, 0)";
						System.out.println(sql2);

						try {
							pstmt = con.prepareStatement(sql);
							pstmt2 = con2.prepareStatement(sql2);
							int cnt = pstmt.executeUpdate();
							pstmt2.executeUpdate();
							AppUtil.alert("회원가입 완료", null);
							Parent login = FXMLLoader.load(getClass().getResource("/login/Login.fxml"));
							Scene scene = new Scene(login);
							Stage primaryStage = (Stage) button.getScene().getWindow();
							primaryStage.setScene(scene);
							scene.getStylesheets()
									.add(getClass().getResource("/application/application.css").toExternalForm());
							if (cnt == 0) {
								System.out.println("데이터 삽입 실패");
								return;
							}
						} catch (Exception e) {
							e.printStackTrace();
							System.out.println("데이터 삽입 실패");
							return;
						} finally {
							if (pstmt != null)
								try {
									pstmt.close();
								} catch (Exception e) {
								}
							if (con != null)
								try {
									con.close();
								} catch (Exception e) {
								}
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
					return;
				} finally {
					if (rs != null)
						try {
							rs.close();
						} catch (Exception e) {
						}
					if (stmt != null)
						try {
							stmt.close();
						} catch (Exception e) {
						}
					if (con != null)
						try {
							con.close();
						} catch (Exception e) {
						}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
