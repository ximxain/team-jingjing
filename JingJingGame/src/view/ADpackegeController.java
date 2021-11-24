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

public class ADpackegeController {
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
	
	private Stage AD1;

	public void AD1() { //광고로 넘기기
		Stage mainStage = (Stage) adsView1.getScene().getWindow();

		AD1 = new Stage(StageStyle.DECORATED);
		AD1.initModality(Modality.WINDOW_MODAL);
		AD1.initOwner(mainStage); // 메인 스테이지 부여

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/Advertistmentone.fxml"));

			Scene sc = new Scene(root);
			sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			AD1.setScene(sc);
			AD1.setResizable(false);
			AD1.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Stage AD2;

	public void AD2() {
		Stage mainStage = (Stage) adsView2.getScene().getWindow();

		AD2 = new Stage(StageStyle.DECORATED);
		AD2.initModality(Modality.WINDOW_MODAL);
		AD2.initOwner(mainStage); // 메인 스테이지 부여

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/Advertistmenttwo.fxml"));

			Scene sc = new Scene(root);
			sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			AD2.setScene(sc);
			AD2.setResizable(false);
			AD2.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Stage AD3;

	public void AD3() {
		Stage mainStage = (Stage) adsView3.getScene().getWindow();

		AD3 = new Stage(StageStyle.DECORATED);
		AD3.initModality(Modality.WINDOW_MODAL);
		AD3.initOwner(mainStage); // 메인 스테이지 부여

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/view/Advertistmentthree.fxml"));

			Scene sc = new Scene(root);
			sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			AD3.setScene(sc);
			AD3.setResizable(false);
			AD3.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
