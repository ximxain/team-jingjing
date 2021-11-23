package appScene;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import login.Login;
import view.MainController;

public class GameController extends Login{
	@FXML
	private Button changeMainViewFromGame;

	@FXML
	public Button app;
	
	public Stage pop;
	
	@FXML
	public Button closebtn;
	public static Stage mainStage;

	public void clickMusic() {
		mainStage = (Stage) app.getScene().getWindow();
		pop = new Stage(StageStyle.DECORATED);
		pop.initModality(Modality.WINDOW_MODAL);
		pop.initOwner(mainStage);

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/appScene/MusicPop.fxml"));

			Scene sc = new Scene(root);
			sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			pop.setScene(sc);
			pop.setTitle("팝업");
			pop.setResizable(false);

			pop.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void clickMath() {
		System.out.println("clickMath");
		mainStage = (Stage) app.getScene().getWindow();
		pop = new Stage(StageStyle.DECORATED);
		pop.initModality(Modality.WINDOW_MODAL);
		pop.initOwner(mainStage);

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/appScene/MathPop.fxml"));

			Scene sc = new Scene(root);
			sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			pop.setScene(sc);
			pop.setTitle("팝업");
			pop.setResizable(false); // â ������ ���� ����

			pop.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void changeToMainViewFromGame() {
		System.out.println("changeToMainViewFromGame");
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) changeMainViewFromGame.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
