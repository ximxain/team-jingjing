package view;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ADControllerTwo implements Initializable{
	@FXML
	private Stage ads;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Instantiating Media class  


        Media media = new Media(getClass().getResource("/resource/ddddd2.mp4").toString());  
          
        //Instantiating MediaPlayer class   
        MediaPlayer mediaPlayer = new MediaPlayer(media);  
        
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
