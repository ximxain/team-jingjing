package view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ADpackegeController extends MainController{
	@FXML
	private Button closeAD;
	@FXML
	public ImageView adsView1;
	@FXML
	public ImageView adsView2;
	@FXML
	public ImageView adsView3;
	
	

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
	
	public Stage AD1;

	public void AD1() { //광고로 넘기기
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/view/ADvertistmentone.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) closeAD.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Stage AD2;

	public void AD2() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/view/ADvertistmenttwo.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) closeAD.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Stage AD3;

	public void AD3() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/view/ADvertistmentthree.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) closeAD.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
