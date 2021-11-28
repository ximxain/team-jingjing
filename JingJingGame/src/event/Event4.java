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

public class Event4 extends Login implements Initializable{
	@FXML
	Label textBuffer;
	@FXML
	ImageView prologBackground;

	private JDBCUtil db;
	static int a = 0;
	static int b = 0;
	static String[] textArr = { "흑... 흑... 하고 누군가의 흐느낌이 들려온다.", "그는 결혼 시기를 놓쳐 40대가 되어도 홀몸이었다.",
			"그런 때 묻은 슬픔을 지울려고 했을까, 마구 술을 마시고 있었다.", "술을 마시고 흥이 난듯 몸을 시계방향으로 돌리다가",
			"이내 쿵, 하고 머리가 테이블로 떨어졌다.", "징징이는 곧장 이런 식으로 잠들고는 했다.",
			"엔딩2 깡소주", "베드엔딩"};

	// true는 화면이 넘어감. false는 넘어가지 않고 화면이 정체되어 있음. 첫 배열은 무조건 true로.
	// textArr 배열과 booleanArr 배열의 크기가 서로 같아야함
	static boolean[] booleanArr = {
			true, false, false, false, true,
			true, false, false};

	public void start() {

	}

	public void next() {
		if (a < textArr.length) {
				text(textArr[a]);
				if (booleanArr[a] == true) {
					b++;
					String path = "src//resource/event4.png";

					try {
						FileInputStream fis = new FileInputStream(path);
						BufferedInputStream bis = new BufferedInputStream(fis);
						Image img = new Image(bis);
						prologBackground.setImage(img);
						try {
							bis.close();
							fis.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				a++;
		} else {
			System.out.println("event4 end");
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
		
		PreparedStatement pstmt = null;
		String sql = "UPDATE `jingjing_users` SET `event3`= 1 WHERE userId = " + "'" + user + "'";
		System.out.println(sql);
		db = new JDBCUtil();

		Connection con = db.getConnection();

		try {
			pstmt = con.prepareStatement(sql);
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
