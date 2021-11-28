package music;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import login.Login;

public class GameClear extends Login{
	@FXML
	Button btn;
	
	
	public void replay(){
		presentExperience+=sickAndHungry(200);
		money+=2;
		up();
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/music/GameReadyScene.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void quit() {
		presentExperience+=sickAndHungry(200);
		money+=2;
		up();
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/appScene/GameView.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
