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
	Label resultLabel;
	@FXML
	Label barLabel;
	@FXML
	ProgressBar bar;
	@FXML
	ImageView albumArt;
	
	String result;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		double aaa = time / limitTimeOfMusic;
		bar.setProgress(aaa);
		barLabel.setText(aaa*100+"%");
		resultLabel.setText("곡 제목:"+musicName);
		
	}

}
