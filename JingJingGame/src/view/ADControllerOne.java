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
		System.out.println("광고비 지급");
		db = new JDBCUtil();
		
		Connection con = db.getConnection();
		
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM `jingjing_users` WHERE userId = " + "'" + user + "'";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while(rs.next()) {
				Integer money = rs.getInt("money");
				money = money+1;
			}
			
		}catch(Exception E) {
			
		}
		
		Connection con2 = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs2 = null;
		String sql2 = "UPDATE `jingjing_currentStat` SET `money`="+money+" WHERE userId = '" +user+"'";
		
		try {
			pstmt = con.prepareStatement(sql2);
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
			return;
		}finally {
			if(rs2 != null) try { rs2.close(); } catch (Exception e) {}
			if(pstmt != null) try { pstmt.close(); } catch (Exception e) {}
			if(con2 != null) try { con2.close(); } catch (Exception e) {}
		}
	}
	
}
