package ButtonHitGame;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StartController {
	@FXML
	private Button Start;

	// 화면이동
	public void changeMainView() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/ButtonHitGame/MainView.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) Start.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
