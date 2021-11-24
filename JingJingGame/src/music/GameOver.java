package music;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println(adder+", "+(musicNoteList.size()-9));
		System.out.println((double)adder/(musicNoteList.size()-9));
		musicProgressBar.setProgress((double)adder/(musicNoteList.size()-9));
		musicProgressLabel.setText((double)adder/(musicNoteList.size()-9)*100+"%");
	}

}
