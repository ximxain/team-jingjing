package view;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledFuture;

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

public class controller implements Initializable {
	@FXML
	private ImageView children;
	@FXML
	private ImageView teacher;

	boolean turntime = false;


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
				
				
				
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						timerlabel.setText("남은 시간 : " + (Integer.toString(second)));
					}
				});
				

				if (second <= 0) {
					timer.cancel();
					timeUp();
				}
			}
		};
		// timer.schedule(timerTask, 1000l); // 1초 후 단 1번
		timer.schedule(timerTask, 1000l, 1000l); // 1초 마다
	}
	
	public int s = 0;
	
	public int getS() {
		return s;
	}

	public void setS(int s) {
		this.s = s;
	}

	public void randomturn() {
	    Timer timers = new Timer();
		timerTask = new TimerTask() {
			@Override
			public void run() {
				
				try {
					int r = getS();
					if(r == 0) {
						Thread.sleep(3000);
					}else if(r == 1) {
						Thread.sleep(5000);
					}else if(r == 2) {
						Thread.sleep(7000);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						teacher.setImage(new Image("/image/teacher2.png"));
					}
				});
				
				
				Random rd = new Random();
				int random = rd.nextInt(3);
				setS(random);
			}
		};
		
		
		
		long r = getS();
		
		if(r == 0) {
			timers.schedule(timerTask, 1000, 1000);
		}else if(r == 1) {
			timers.schedule(timerTask, 1000, 2000);
		}else if(r == 2) {
			timers.schedule(timerTask, 1000, 3000);
			
		}
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		timer();
		randomturn();

	}

}
