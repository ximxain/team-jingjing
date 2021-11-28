package item;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import util.JDBCUtil;

public class StoreController {

	@FXML
	private Button changeMainView;

	@FXML
	private Button showMyItem;

	@FXML
	private Button storeBtn;

	@FXML
	private Button foodBtn;

	@FXML
	private Button MDCBtn;

	@FXML
	private Button clothesBtn;
	// 음식 종류
	@FXML
	private ImageView food1;
	@FXML
	private ImageView food2;
	@FXML
	private ImageView food3;
	@FXML
	private ImageView food4;
	@FXML
	private ImageView food5;
	@FXML
	private ImageView food6;
	// 청결용품/약 종류
	@FXML
	private ImageView MDC1;
	@FXML
	private ImageView MDC2;
	@FXML
	private ImageView MDC3;
	@FXML
	private ImageView MDC4;
	@FXML
	private ImageView MDC5;
	@FXML
	private ImageView MDC6;
	// 옷 종류
	@FXML
	private ImageView clothes1;
	@FXML
	private ImageView clothes2;
	@FXML
	private ImageView clothes3;
	@FXML
	private ImageView clothes4;
	@FXML
	private ImageView clothes5;
	@FXML
	private ImageView clothes6;
	@FXML
	private ImageView clothes7;
	@FXML
	private ImageView clothes8;

	public void changeToMainView() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) changeMainView.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private Stage stores;

	public void store() {
		Stage mainStage = (Stage) storeBtn.getScene().getWindow();

		stores = new Stage(StageStyle.DECORATED);
		stores.initModality(Modality.WINDOW_MODAL);
		stores.initOwner(mainStage); // 메인 스테이지 부여

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/store/StorePop-UP.fxml"));

			Scene sc = new Scene(root);
			sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			stores.setScene(sc);
			stores.setResizable(false);
			stores.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Stage foods;

	public void foodpop() {
		Stage mainStage = (Stage) foodBtn.getScene().getWindow();

		foods = new Stage(StageStyle.DECORATED);
		foods.initModality(Modality.WINDOW_MODAL);
		foods.initOwner(mainStage);

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/item/FoodPop-up.fxml"));

			Scene sc = new Scene(root);
			sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			foods.setScene(sc);
			foods.setResizable(false);
			foods.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public void MDpop() {
		Stage mainStage = (Stage) foodBtn.getScene().getWindow();

		foods = new Stage(StageStyle.DECORATED);
		foods.initModality(Modality.WINDOW_MODAL);
		foods.initOwner(mainStage);

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/item/MDPop-up.fxml"));

			Scene sc = new Scene(root);
			sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			foods.setScene(sc);
			foods.setResizable(false);
			foods.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
