package hideGame;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainController {
	@FXML
	private Button btn1;

	public void btn1() {

		try {
			Parent login = FXMLLoader.load(getClass().getResource("/hideGame/level1.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) btn1.getScene().getWindow();
			primaryStage.setScene(scene);
			scene.getStylesheets().add(getClass().getResource("/hideGame/application.css").toExternalForm());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void btn2() {

		try {
			Parent login = FXMLLoader.load(getClass().getResource("/hideGame/level2.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) btn1.getScene().getWindow();
			primaryStage.setScene(scene);
			scene.getStylesheets().add(getClass().getResource("/hideGame/application.css").toExternalForm());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void btn3() {

		try {
			Parent login = FXMLLoader.load(getClass().getResource("/hideGame/level3.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) btn1.getScene().getWindow();
			primaryStage.setScene(scene);
			scene.getStylesheets().add(getClass().getResource("/hideGame/application.css").toExternalForm());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
