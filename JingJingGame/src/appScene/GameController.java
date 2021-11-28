package appScene;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import login.Login;
import view.MainController;

public class GameController extends Login {
	@FXML
	private Button changeMainViewFromGame;

	@FXML
	public Button app;

	public Stage pop;

	@FXML
	public Button closebtn;
	public static Stage mainStage;

	int level = 0;
	Label image;

	ArrayList<int[]> rectLists;

	Stage primaryState;
	Stage gameStage;

	Label levelLabel;

	public void clickMusic() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/music/GameReadyScene.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) app.getScene().getWindow();
			primaryStage.setScene(scene);
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
			pop.setTitle("수학퀴즈게임");
			pop.setResizable(false);

			pop.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void clickButtonGame() {
		if (hungry == 0 && sick == 0) {
			mainStage = (Stage) app.getScene().getWindow();
			pop = new Stage(StageStyle.DECORATED);
			pop.initModality(Modality.WINDOW_MODAL);
			pop.initOwner(mainStage);

			try {
				Parent root = FXMLLoader.load(getClass().getResource("/ButtonHitGame/StartPage.fxml"));

				Scene sc = new Scene(root);
				sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
				pop.setScene(sc);
				pop.setTitle("정예린을 이겨라 !");
				pop.setResizable(false);

				pop.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			util.AppUtil.alert("징징이 상태가 안좋아요 ㅜ", null);
		}
	}

	public void clickCardGame() {
		if (hungry == 0 && sick == 0) {
			mainStage = (Stage) app.getScene().getWindow();
			pop = new Stage(StageStyle.DECORATED);
			pop.initModality(Modality.WINDOW_MODAL);
			pop.initOwner(mainStage);

			try {
				Parent root = FXMLLoader.load(getClass().getResource("/cardgame/layout.fxml"));

				Scene sc = new Scene(root);
				sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
				pop.setScene(sc);
				pop.setTitle("운빨카드게임");
				pop.setResizable(false);

				pop.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			util.AppUtil.alert("징징이 상태가 안좋아요 ㅜ", null);
		}
	}

	public void clickTickTacToe() {
		if (hungry == 0 && sick == 0) {
			mainStage = (Stage) app.getScene().getWindow();
			pop = new Stage(StageStyle.DECORATED);
			pop.initModality(Modality.WINDOW_MODAL);
			pop.initOwner(mainStage);

			try {
				Parent root = FXMLLoader.load(getClass().getResource("/tickTacToe/MainLayout.fxml"));

				Scene sc = new Scene(root);
				sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
				pop.setScene(sc);
				pop.setTitle("틱택토");
				pop.setResizable(false);

				pop.show();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			util.AppUtil.alert("징징이 상태가 안좋아요 ㅜ", null);
		}
	}

	public void changeToMainViewFromGame() { // 메인이동
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
