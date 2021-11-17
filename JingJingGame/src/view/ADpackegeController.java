package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ADpackegeController {
	@FXML private Button closeAD;

	public void changeToMainFromAD() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) closeAD.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
