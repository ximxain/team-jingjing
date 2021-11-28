package view;

import java.io.File;
import java.io.IOException;
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
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import util.JDBCUtil;

public class ADControllerOne extends ADpackegeController implements Initializable{
	@FXML
	private MediaView ads1;
	
	private Timer timer = null;
	private TimerTask timerTask = null;
	private int count = 0;
	int second = 0;
	private JDBCUtil db;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("test");
		//Instantiating Media class  
        Media media = new Media(getClass().getResource("/resource/ddddd.mp4").toString());  
          
        //Instantiating MediaPlayer class   
        MediaPlayer mediaPlayer = new MediaPlayer(media);  
          
        ads1.setMediaPlayer(mediaPlayer); 
        
        //by setting this property to true, the Video will be played   
        
        
        
        mediaPlayer.setOnReady(new Runnable() {

			// 화면이 동영상이 실행 되는 쓰레드 사용
			@Override
			public void run() {

				// 시작시 플레이 버튼만 활성화
				// 나머지는 비활성화
				mediaPlayer.setAutoPlay(true);  
				timer();
			}
		});
	}
	
	public void timer() {
		timer = new Timer();
		timerTask = new TimerTask() {
			@Override
			public void run() {
				count++;
				System.out.println("타이머 : " + count); // 콘솔 출력 테스트
				second = 25 - count;
				
				if (second <= 0) {
					timer.cancel();
					give();
				}
			}
		};
		timer.schedule(timerTask, 1000l, 1000l);
	}
	
	public void give() {
		money+=1;
		up();
	}
	
}
