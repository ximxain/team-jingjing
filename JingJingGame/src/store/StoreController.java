package store;

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

public class StoreController {

	@FXML private Button changeMainView;

	@FXML private Button showMyItem;

	@FXML private Button storeBtn;

	@FXML private Button foodBtn;

	@FXML private Button MDCBtn;

	@FXML private Button clothesBtn;
	// 음식 종류
	@FXML private ImageView food1;
	@FXML private ImageView food2;
	@FXML private ImageView food3;
	@FXML private ImageView food4;
	@FXML private ImageView food5;
	@FXML private ImageView food6;
	// 청결용품/약 종류
	@FXML private ImageView MDC1;
	@FXML private ImageView MDC2;
	@FXML private ImageView MDC3;
	@FXML private ImageView MDC4;
	@FXML private ImageView MDC5;
	@FXML private ImageView MDC6;
	// 옷 종류
	@FXML private ImageView clothes1;
	@FXML private ImageView clothes2;
	@FXML private ImageView clothes3;
	@FXML private ImageView clothes4;
	@FXML private ImageView clothes5;
	@FXML private ImageView clothes6;

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

	// fxml 팝업창 띄우기(내아이템 -> MyItemPop-Up / 상점 -> StorePop-Up)
	private Stage pop; // 스테이지가 들어갈 변수

	public void myItem() {
		// 메인 스테이지 취득, 전의 두가지 방법 중 두번째 방법
		Stage mainStage = (Stage) showMyItem.getScene().getWindow();

		// 새로운 스테이지 생성 (옵션 추가, 스타일)
		pop = new Stage(StageStyle.DECORATED); // 스테이지 옵션
		pop.initModality(Modality.WINDOW_MODAL); // 그 위에 뜨는 모달의 옵션
		pop.initOwner(mainStage); // 메인 스테이지 부여

		try {
			// 새로운 스테이지에 custom 레이아웃 불러오기
			Parent root = FXMLLoader.load(getClass().getResource("/store/MyItemPop-up.fxml"));

			// 씬에 추가
			Scene sc = new Scene(root);
			// 씬에 스타일 추가
			sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			pop.setScene(sc);
			pop.setResizable(false);
			// 창 사이즈 조절 차단

			// 보여주기
			pop.show();

		} catch (IOException e) {
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
			Parent root = FXMLLoader.load(getClass().getResource("/store/Food.fxml"));

			Scene sc = new Scene(root);
			sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			foods.setScene(sc);
			foods.setResizable(false);
			foods.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Stage Food1;

	public void FoodName1() {

		Stage mainStage = (Stage) food1.getScene().getWindow();

		Food1 = new Stage(StageStyle.DECORATED);
		Food1.initModality(Modality.WINDOW_MODAL);
		Food1.initOwner(mainStage);

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/StorePopup/FoodName1.fxml"));
			Scene sc = new Scene(root);
			sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			Food1.setScene(sc);
			Food1.setResizable(false);
			Food1.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Stage Food2;

	public void FoodName2() {

		Stage mainStage = (Stage) food2.getScene().getWindow();

		Food2 = new Stage(StageStyle.DECORATED);
		Food2.initModality(Modality.WINDOW_MODAL);
		Food2.initOwner(mainStage);

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/StorePopup/FoodName2.fxml"));
			Scene sc = new Scene(root);
			sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			Food2.setScene(sc);
			Food2.setResizable(false);
			Food2.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Stage Food3;

	public void FoodName3() {

		Stage mainStage = (Stage) food3.getScene().getWindow();

		Food3 = new Stage(StageStyle.DECORATED);
		Food3.initModality(Modality.WINDOW_MODAL);
		Food3.initOwner(mainStage);

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/StorePopup/FoodName3.fxml"));
			Scene sc = new Scene(root);
			sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			Food3.setScene(sc);
			Food3.setResizable(false);
			Food3.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Stage Food4;

	public void FoodName4() {

		Stage mainStage = (Stage) food4.getScene().getWindow();

		Food4 = new Stage(StageStyle.DECORATED);
		Food4.initModality(Modality.WINDOW_MODAL);
		Food4.initOwner(mainStage);

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/StorePopup/FoodName4.fxml"));
			Scene sc = new Scene(root);
			sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			Food4.setScene(sc);
			Food4.setResizable(false);
			Food4.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Stage Food5;

	public void FoodName5() {

		Stage mainStage = (Stage) food5.getScene().getWindow();

		Food5 = new Stage(StageStyle.DECORATED);
		Food5.initModality(Modality.WINDOW_MODAL);
		Food5.initOwner(mainStage);

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/StorePopup/FoodName5.fxml"));
			Scene sc = new Scene(root);
			sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			Food5.setScene(sc);
			Food5.setResizable(false);
			Food5.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Stage Food6;

	public void FoodName6() {

		Stage mainStage = (Stage) food6.getScene().getWindow();

		Food6 = new Stage(StageStyle.DECORATED);
		Food6.initModality(Modality.WINDOW_MODAL);
		Food6.initOwner(mainStage);

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/StorePopup/FoodName6.fxml"));
			Scene sc = new Scene(root);
			sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			Food6.setScene(sc);
			Food6.setResizable(false);
			Food6.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Stage MDC;

	public void MDCpop() {
		Stage mainStage = (Stage) MDCBtn.getScene().getWindow();

		MDC = new Stage(StageStyle.DECORATED);
		MDC.initModality(Modality.WINDOW_MODAL);
		MDC.initOwner(mainStage);

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/store/MDClean.fxml"));

			Scene sc = new Scene(root);
			sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			MDC.setScene(sc);
			MDC.setResizable(false);

			MDC.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Stage clothes;

	public void clothespop() {
		Stage mainStage = (Stage) clothesBtn.getScene().getWindow();

		clothes = new Stage(StageStyle.DECORATED);
		clothes.initModality(Modality.WINDOW_MODAL);
		clothes.initOwner(mainStage);

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/store/clothes.fxml"));

			Scene sc = new Scene(root);
			sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			clothes.setScene(sc);
			clothes.setResizable(false);

			clothes.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
