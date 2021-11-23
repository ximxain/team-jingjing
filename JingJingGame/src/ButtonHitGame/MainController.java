package ButtonHitGame;

import java.net.URL;

import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

public class MainController implements Initializable {
	int click = 0; // 버튼클릭 횟수
	int SuccessClick = 100; // 버튼클릭 성공횟수
	@FXML
	private ImageView win;
	@FXML
	private ImageView lose;

	@FXML
	private Button ClickBtn;

	// 타이머(20초)
	private Timer timer = null;
	private TimerTask timerTask = null;
	private int count = 21;
	@FXML
	private Label timerLabel;

	// 타이머
	public void timer() {
		timer = new Timer();
		timerTask = new TimerTask() {
			@Override
			public void run() {
				count--;
				System.out.println("타이머 : " + count);

				// label에 출력
				Platform.runLater(() -> timerLabel.setText("남은 시간 : " + (Integer.toString(count))));

				if (count <= 0) {
					timer.cancel();
					timeUp();
				}
			}
		};
		timer.schedule(timerTask, 1000l, 1000l); // 1초 마다
	}

	public void timeUp() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/view/Fail.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) ClickBtn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 버튼 누름과 안누름에 따라 이미지뷰 변화
	public void clickButtonWin() {
		System.out.println("win");
		Image image = new Image("picture/win.png");
		win.setImage(image);
	}

	public void clickButtonLose() {
		System.out.println("lose");
		Image image = new Image("picture/lose.png");
		lose.setImage(image);
	}

	public void clickButton() {
		System.out.println(".");
		Image image = new Image("picture/jing.png");
		lose.setImage(image);
	}

	// 버튼클릭
	public void IfClickBtn() {
		click += 1; // 클릭 횟수
		System.out.println(click);
		if (click >= 3) {
			clickButton();
		} else if (click >= 7) {
			clickButtonWin();
		} else if (click == SuccessClick) {
			try {
				Parent login = FXMLLoader.load(getClass().getResource("/view/Success.fxml"));
				Scene scene = new Scene(login);
				Stage primaryStage = (Stage) ClickBtn.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		timer();
		clickButtonLose(); // 처음 게임 시작 이미지
	}
}