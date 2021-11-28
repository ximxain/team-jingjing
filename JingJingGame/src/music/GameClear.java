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
import javafx.stage.Stage;
import login.Login;
import util.AppUtil;

public class GameClear extends Login implements Initializable{
	@FXML
	Button btn;
	
	
	public void replay(){
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
		presentExperience+=sickAndHungry(200);
		money+=2;

		Random rd = new Random();
		
		if (rd.nextInt(10) < 3 && hungry == 0) {

			// 30%에 걸리면 호출
			hungry = 1;
			AppUtil.alert("징징이가 배고파졌습니다! 배고픔 상태일 때는 30% 점수가 삭감됩니다. 상점에서 해결할 수 있습니다.", "");
		}
		up();
	}
}
