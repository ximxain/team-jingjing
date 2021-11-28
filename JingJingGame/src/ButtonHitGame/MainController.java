package ButtonHitGame;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import login.Login;
import util.JDBCUtil;

public class MainController extends Login implements Initializable {
	int click = 0; // 버튼클릭 횟수
	int SuccessClick = 10; // 버튼클릭 성공횟수
	int FailCount = 0;

	@FXML
	private ImageView win;

	@FXML
	private Button ClickBtn; // 버튼 클릭
	@FXML
	private Button endBtn;
	@FXML
	private Button endBtn2;
	@FXML
	private Button fail;

	private JDBCUtil db;
	
	private static String viewName = "ButtonGame"; // fxml 구분

	@FXML
	private Button Start;

	// 게임화면이동
	public void changeMainView() {
		viewName = "Start";
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/buttonHitGame/MainView.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) Start.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 타이머(20초)
	private Timer timer = null;
	private TimerTask timerTask = null;
	private int count = 10;
	@FXML
	private Label timerLabel;

	// 타이머
	public void timer() {
		timer = new Timer();
		timerTask = new TimerTask() {
			@Override
			public void run() {
				count--;
				System.out.println("타이머 : " + count); // 타이머 출력

				// label에 출력
				Platform.runLater(() -> timerLabel.setText("남은 시간 : " + (Integer.toString(count))));

				if (count == 0) {
					timer.cancel();
					// timeUp();

				}
			}
		};
		timer.schedule(timerTask, 1000l, 1000l); // 1초 마다
	}

	public void timeUp() { // 실패
		if (count == 0) {
			try {
				Parent login = FXMLLoader.load(getClass().getResource("/ButtonHitGame/Fail.fxml"));
				Scene scene = new Scene(login);
				Stage primaryStage = (Stage) fail.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			util.AppUtil.alert("아직 시간 안끝났자나 ㅋ", null);
		}
	}

	// 버튼 누름과 안누름에 따라 이미지뷰 변화
	public void clickButtonWin() {
		Image image = new Image("picture/win.png");
		win.setImage(image);
	}

	public void clickButtonLose() {
		Image image = new Image("picture/lose.png");
		win.setImage(image);
	}

	public void clickButton() {
		Image image = new Image("picture/jing.png");
		win.setImage(image);
	}

	// 버튼클릭
	public void IfClickBtn() {
		viewName = "ClickBtn"; // fxml 위치
		if (count > 0) {
			click += 1; // 클릭 횟수
			System.out.println(click);
			if (click == 2) {
				clickButton();

			} else if (click == 7) {
				clickButtonWin();

			} else if (click == SuccessClick) { // 성공
				try {
					Parent login = FXMLLoader.load(getClass().getResource("/buttonHitGame/Success.fxml"));
					Scene scene = new Scene(login);
					Stage primaryStage = (Stage) ClickBtn.getScene().getWindow();
					primaryStage.setScene(scene);
				} catch (Exception e) {
					e.printStackTrace();
				}
				give();
			}
		}
	}

	public void give() {
		System.out.println("코인 2개 지급");
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();

		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM `jingjing_users` WHERE userId = " + "'" + user + "'";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Integer money = rs.getInt("money");
				money = money + 2;
			}

		} catch (Exception E) {

		}

		Connection con2 = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs2 = null;
		String sql2 = "UPDATE `jingjing_currentStat` SET `money`=" + money+2 + " WHERE userId = '" + user + "'";

		try {
			pstmt = con.prepareStatement(sql2);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			return;
		} finally {
			if (rs2 != null)
				try {
					rs2.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			if (con2 != null)
				try {
					con2.close();
				} catch (Exception e) {
				}
		}
	}

	public void changeToMain() {
		Stage stage = (Stage) endBtn.getScene().getWindow(); // 팝업창 닫기
		stage.close();
	}

	public void changeToMain2() {
		Stage stage = (Stage) endBtn2.getScene().getWindow(); // 팝업창 닫기
		stage.close();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if (viewName.equals("Start")) {
			timer();
		}
	}
}