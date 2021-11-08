 package view;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import application.Main;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import task.teacherTurn;

public class controller {
	@FXML
	private ImageView children;
	@FXML
	private ImageView teacher;

	boolean turntime = false;
	
	private long sec = 0;
	
//	@FXML
//	public void initialize() {
//		timer();
//		while(turntime == false) {
//			randomturn();
//			if(d == true) {
//				break;
//			}
//		}
//		randomturn();
////		
//	}
	
	private teacherTurn thread;
	
	@FXML
	public void initialize() {
		teacherTurn t = new teacherTurn();
		timer();
		while(turntime == false) {
			randomturn();
			sec++;
			if(d==true) {
				break;
			}
			if(sec>9) {
				break;
			}
		}
	}

	public void teacherturn() {
		
		
	}

	public void randomturn() {
		
	}

	private Timer timer = null;
	private TimerTask timerTask = null;
	private int count = 0;
	int second = 0;
	@FXML
	private Label timerlabel;

	public void timer() {
		timer = new Timer();
		timerTask = new TimerTask() {
			@Override
			public void run() {
				count++;
				System.out.println("타이머 : " + count); // 콘솔 출력 테스트
				second = 90 - count;

				// Platform.runLater() 메소드는 UI를 변경하는 Thread를 생성해
				// JavaFX Application Thread 가 처리 할 수 있게 Queue에 등록하는 기능 수행
				Platform.runLater(() -> timerlabel.setText("남은 시간 : " + (Integer.toString(second))));

				if (second <= 0) {
					timer.cancel();
					timeUp();
				}
			}
		};
		// timer.schedule(timerTask, 1000l); // 1초 후 단 1번
		timer.schedule(timerTask, 1000l, 1000l); // 1초 마다
	}

	boolean d = false;

	public void spacebar(KeyEvent e) {
		if (e.getCode() == KeyCode.SPACE) {
			children.setImage(new Image("/image/children1.gif"));
			if (teacher.getImage().equals(new Image("/image/teacher2.png"))) {
				gameOver();
			}
		} else {
			children.setImage(new Image("/image/children2.png"));
		}
	}

	public void gameOver() {
		d = true;
		Alert al = new Alert(AlertType.INFORMATION);
		al.setTitle("게임 오버");
		al.setContentText("썜한테 딱거리걸ㄹ");
		al.setHeaderText("무야호");
		al.showAndWait();
		d = false;
	}

	public void timeUp() {
		d = true;
		Alert al = new Alert(AlertType.INFORMATION);
		al.setTitle("게임 성공");
		al.setContentText("성공");
		al.setHeaderText("무ㅋㄹㅃㅃㅃ");
		al.showAndWait();
	}

	

}
