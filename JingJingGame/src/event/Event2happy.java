package event;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import login.Login;
import util.JDBCUtil;

public class Event2happy extends Login implements Initializable{
	@FXML
	Label textBuffer;
	@FXML
	ImageView prologBackground;

	private JDBCUtil db;
	static int a = 0;
	static int b = 0;
	static String[] textArr = { "오 당신은 정말 제 운명의 연인이었나봐요!", "그럼요! 당연하죠!(정말 다행이야)"};

	// true는 화면이 넘어감. false는 넘어가지 않고 화면이 정체되어 있음. 첫 배열은 무조건 true로.
	// textArr 배열과 booleanArr 배열의 크기가 서로 같아야함
	static boolean[] booleanArr = {
			true, false};

	public void start() {

	}

	public void next() {
		if (a < textArr.length) {
				text(textArr[a]);
				a++;
		} else {
			System.out.println("event2 end");
			// 임시
			try {
				Parent login = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));
				Scene scene = new Scene(login);
				Stage primaryStage = (Stage) textBuffer.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void text(String text) {
		final Animation animation = new Transition() {
			{
				setCycleDuration(Duration.millis(2000));
			}

			protected void interpolate(double frac) {
				final int length = text.length();
				final int n = Math.round(length * (float) frac);
				textBuffer.setText(text.substring(0, n));
			}
		};

		animation.play();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		next();
		event2 = 1;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		String sql = "UPDATE `jingjing_users` SET `event2`= 1 WHERE userId = " + "'" + user + "'";
		String sql2 = "UPDATE `jingjing_users` SET `endingWhether`= 1 WHERE userId = " + "'" + user + "'";
		System.out.println(sql);
		db = new JDBCUtil();

		Connection con = db.getConnection();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt2 = con.prepareStatement(sql2);
			pstmt2.executeUpdate();
			int cnt = pstmt.executeUpdate();
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
}
