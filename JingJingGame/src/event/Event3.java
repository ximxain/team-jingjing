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

public class Event3 extends Login implements Initializable{
	@FXML
	Label textBuffer;
	@FXML
	ImageView prologBackground;

	private JDBCUtil db;
	static int a = 0;
	static int b = 0;
	static String[] textArr = { "당신을 만난 건 정말이지 행운이었어요.", "오, 동감이에요.",
			"징징이는 뚱이에게 자신의 거짓말을 고백했다.", "그런데 뚱이는 이미 사실 알고 있었다고 했다. 그 정도로 어린애는 아니라고 했다.",
			"자신도 당돌한 마음이 좋았다고, 반했다고.", "하얀 빛이 결혼식 음악이 울려퍼트린다.",
			"엔딩1 결혼식", "해피엔딩", "당신이 징징이를 처음 낚았을 때를 기억하시나요?", "그때의 징징이는 작고 어렸습니다", "그러나 보세요!", "당신이 잘 키워주신 덕분에, 징징이는 행복한 삶을 살 수가 있을거에요!","플레이해주셔서 감사합니다!","TeamJingJing일동"};

	// true는 화면이 넘어감. false는 넘어가지 않고 화면이 정체되어 있음. 첫 배열은 무조건 true로.
	// textArr 배열과 booleanArr 배열의 크기가 서로 같아야함
	static boolean[] booleanArr = {
			true, false, false, false, false,
			true, false, false, false, false, false, false, false, false, false};

	public void start() {

	}

	public void next() {
		if (a < textArr.length) {
				text(textArr[a]);
				if (booleanArr[a] == true) {
					b++;
					String path = "src//resource/event3-" + b + ".png";

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
			System.out.println("event3 end");
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
		event3 = 1;
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
