package appScene;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Login {
	@FXML
	private Button button;

	public void clickButton() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) button.getScene().getWindow();
			primaryStage.setScene(scene);
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
