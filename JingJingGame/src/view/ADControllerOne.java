package view;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class ADControllerOne extends ADpackegeController implements Initializable{
	@FXML
	private MediaView ads1;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
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

			}
		});
	}
	
}
