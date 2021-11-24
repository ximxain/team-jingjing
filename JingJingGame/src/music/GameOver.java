package music;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;

public class GameOver extends MainController implements Initializable{
	
	@FXML
	ProgressBar musicProgressBar;
	@FXML
	ImageView albumArt;
	@FXML
	Label musicProgressLabel;
	
	
	public void retry(){
		
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		musicProgressBar.setProgress(time/Integer.parseInt(musicNoteList.get(2)));
		musicProgressLabel.setText( Math.round(time/Integer.parseInt(musicNoteList.get(2)))+"%");
	}

}
