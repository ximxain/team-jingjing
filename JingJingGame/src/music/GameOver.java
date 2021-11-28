package music;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class GameOver extends MainController implements Initializable{
	
	@FXML
	ProgressBar musicProgressBar;
	@FXML
	ImageView albumArt;
	@FXML
	Label musicProgressLabel;
	@FXML
	Button btn;
	
	
	public void retry(){
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/music/GameReadyScene.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) musicProgressLabel.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void quit() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/appScene/GameView.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Random rd = new Random();
		
		if (rd.nextInt(10) < 3) {

			// 30%에 걸리면 호출
			hungry = 1;
		}
		if (rd.nextInt(10) < 3) {

			// 30%에 걸리면 호출
			sick = 1;
		}
		System.out.println(adder+", "+(musicNoteList.size()-9));
		System.out.println((double)adder/(musicNoteList.size()-9));
		musicProgressBar.setProgress((double)adder/(musicNoteList.size()-9));
		musicProgressLabel.setText((int)((double)adder/(musicNoteList.size()-9)*100)+"%");
	}
	
	

}
