package view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
	private Button cleanBtn;
	
	@FXML
	private Button clothBtn;
	
	@FXML
	private Button closeBtn;
	
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
			Parent root = FXMLLoader.load(getClass().getResource("/view/MyItemPop-up.fxml"));

			// 씬에 추가
			Scene sc = new Scene(root);
			// 씬에 스타일 추가
			sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			pop.setScene(sc);
			pop.setTitle("팝업 띄우기");
			pop.setResizable(false); 
			// 창 사이즈 조절 차단

			// 보여주기
			pop.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Stage stores; // 스테이지가 들어갈 변수

	public void store() {
		// 메인 스테이지 취득, 전의 두가지 방법 중 두번째 방법
		Stage mainStage = (Stage) storeBtn.getScene().getWindow();

		// 새로운 스테이지 생성 (옵션 추가, 스타일)
		stores = new Stage(StageStyle.DECORATED); // 스테이지 옵션
		stores.initModality(Modality.WINDOW_MODAL); // 그 위에 뜨는 모달의 옵션
		stores.initOwner(mainStage); // 메인 스테이지 부여

		try {
			// 새로운 스테이지에 custom 레이아웃 불러오기
			Parent root = FXMLLoader.load(getClass().getResource("/view/StorePop-UP.fxml"));

			// 씬에 추가
			Scene sc = new Scene(root);
			// 씬에 스타일 추가
			sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			stores.setScene(sc);
			stores.setTitle("팝업 띄우기");
			stores.setResizable(false); // 창 사이즈 조절 차단

			// 보여주기
			stores.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Stage foods; // 스테이지가 들어갈 변수

	public void foodpop() {
		// 메인 스테이지 취득, 전의 두가지 방법 중 두번째 방법
		Stage mainStage = (Stage) foodBtn.getScene().getWindow();

		// 새로운 스테이지 생성 (옵션 추가, 스타일)
		foods = new Stage(StageStyle.DECORATED); // 스테이지 옵션
		foods.initModality(Modality.WINDOW_MODAL); // 그 위에 뜨는 모달의 옵션
		foods.initOwner(mainStage); // 메인 스테이지 부여

		try {
			// 새로운 스테이지에 custom 레이아웃 불러오기
			Parent root = FXMLLoader.load(getClass().getResource("/view/Food.fxml"));

			// 씬에 추가
			Scene sc = new Scene(root);
			// 씬에 스타일 추가
			sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			foods.setScene(sc);
			foods.setTitle("팝업 띄우기");
			foods.setResizable(false); // 창 사이즈 조절 차단

			// 보여주기
			foods.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private Stage cleans; // 스테이지가 들어갈 변수

	public void cleanpop() {
		// 메인 스테이지 취득, 전의 두가지 방법 중 두번째 방법
		Stage mainStage = (Stage) cleanBtn.getScene().getWindow();

		// 새로운 스테이지 생성 (옵션 추가, 스타일)
		cleans = new Stage(StageStyle.DECORATED); // 스테이지 옵션
		cleans.initModality(Modality.WINDOW_MODAL); // 그 위에 뜨는 모달의 옵션
		cleans.initOwner(mainStage); // 메인 스테이지 부여

		try {
			// 새로운 스테이지에 custom 레이아웃 불러오기
			Parent root = FXMLLoader.load(getClass().getResource("/view/MDClean.fxml"));

			// 씬에 추가
			Scene sc = new Scene(root);
			// 씬에 스타일 추가
			sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			cleans.setScene(sc);
			cleans.setTitle("팝업 띄우기");
			cleans.setResizable(false); // 창 사이즈 조절 차단

			// 보여주기
			cleans.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private Stage clothes; // 스테이지가 들어갈 변수

	public void clothpop() {
		// 메인 스테이지 취득, 전의 두가지 방법 중 두번째 방법
		Stage mainStage = (Stage) clothBtn.getScene().getWindow();

		// 새로운 스테이지 생성 (옵션 추가, 스타일)
		clothes = new Stage(StageStyle.DECORATED); // 스테이지 옵션
		clothes.initModality(Modality.WINDOW_MODAL); // 그 위에 뜨는 모달의 옵션
		clothes.initOwner(mainStage); // 메인 스테이지 부여

		try {
			// 새로운 스테이지에 custom 레이아웃 불러오기
			Parent root = FXMLLoader.load(getClass().getResource("/view/clothes.fxml"));

			// 씬에 추가
			Scene sc = new Scene(root);
			// 씬에 스타일 추가
			sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			clothes.setScene(sc);
			clothes.setTitle("팝업 띄우기");
			clothes.setResizable(false); // 창 사이즈 조절 차단

			// 보여주기
			clothes.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		pop = (Stage) closeBtn.getScene().getWindow();
		pop.close();
	}

}
