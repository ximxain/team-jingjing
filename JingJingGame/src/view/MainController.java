package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

public class MainController implements Initializable {
	@FXML
	private Button changeGameView;
	
	@FXML
	ProgressBar experienceBar;
	
	int limitExperience;
	int presentExperience;
	String currentStat;
	
	public void jingJingStat() {
		
	}

	public void changeToGameView() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/view/GameView.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) changeGameView.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	private Button changeStore;

	public void changeToStore() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/view/Store.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) changeStore.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@FXML private Button changeAD;

	public void changeToAD() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/view/Advertisement.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) changeAD.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		limitExperience = 200;
		presentExperience = 20;
		experienceBar.setProgress((double) presentExperience / limitExperience);
	}
	
	//버튼 클릭 하면 음성나오기(징징이)

}
