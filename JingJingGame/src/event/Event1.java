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

public class Event1 extends Login implements Initializable{
	@FXML
	Label textBuffer;
	@FXML
	ImageView prologBackground;

	private JDBCUtil db;
	static int a = 0;
	static int b = 0;
	static String[] textArr = { "인간이 성장하여 사춘기에 이르게 되면 세상을 보는 관점이 조금 바뀌게 된다.", "예를 들어 꽃을 볼 때에 그 눈에 꽃만이 비치는 것이 아니라\n희망이나 정결 여러 시상 같은 것이 함께 맺히게 된다.",
			"징징이는 조금 특별한 오징어라서 인간과 비슷한 사춘기를 지녔다.", "그러므로 징징이가 카페 옆을 지나다가 창문으로 언 듯 본 뚱이에게서",
			"평범한 불가사리, 그 이상을 느끼고 반하게 된 것도 이상한 일이 아니다.", "...",
			"스폰지밥, 스폰-지 밥!", "왜 그래 징징이?",
			"너는 분명 초록 반바지를 입은 붉은 불가사리와 친구였지?", "뚱이 말하는거 맞지? 그렇다면 맞아. 그런데 갑자기 무슨 일이야?",
			"그래... 잘 됐어. 스폰지밥. 너에게 물어볼 것이 있어", "그... 혹시... 뚱이의 타입 같은거... 잘 아니?",
			"타입...?", "...",
			"...아하", "뚱이... 뚱이는 말이지... 조금 어리숙한 소년? 같은 면이 있어.",
			"그래서 판타지나 자신이 모르는 미지의 세계 같은 것에 껌뻑 죽지", "아마 운명의 만남 같은 것을 연출하면 뚱이는 거기에 금방 호기심을 가질거야",
			"예를 들어, 나는 미래에서 온 당신의 연인이고 그래서 당신의 모든 것을 알고 있어요! 같은 식으로 말이야", "정말 고마워! 스폰지밥! 꼭 해내볼게",
			"물론 이런 증명하기 어렵고 금방 들킬 것 같은 걸 할 수는 없겠지만... 어? 징징이가 어디 간거지?"
			};

	// true는 화면이 넘어감. false는 넘어가지 않고 화면이 정체되어 있음. 첫 배열은 무조건 true로.
	// textArr 배열과 booleanArr 배열의 크기가 서로 같아야함
	static boolean[] booleanArr = {
			true, false, true, false, true,
			true, true, false, false, false,
			false, false, false, false, false,
			false, false, false, false, false,
			false};

	public void start() {

	}

	public void next() {
		if (a < textArr.length) {
				text(textArr[a]);
				if (booleanArr[a] == true) {
					b++;
					String path = "src//resource/event1-" + b + ".png";

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
			System.out.println("event1 end");
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
		String sql = "UPDATE `jingjing_users` SET `event1`= 1 WHERE userId = " + "'" + user + "'";
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
