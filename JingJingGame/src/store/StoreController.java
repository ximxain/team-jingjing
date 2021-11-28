package store;

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
import login.Login;
import util.JDBCUtil;

public class StoreController extends Login{

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
			Parent root = FXMLLoader.load(getClass().getResource("/item/MyItemPop-up.fxml"));

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
			Parent root = FXMLLoader.load(getClass().getResource("/store/FoodName1.fxml"));
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
			Parent root = FXMLLoader.load(getClass().getResource("/store/FoodName2.fxml"));
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
			Parent root = FXMLLoader.load(getClass().getResource("/store/FoodName3.fxml"));
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
			Parent root = FXMLLoader.load(getClass().getResource("/store/FoodName4.fxml"));
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
			Parent root = FXMLLoader.load(getClass().getResource("/store/FoodName5.fxml"));
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
			Parent root = FXMLLoader.load(getClass().getResource("/store/FoodName6.fxml"));
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
			Parent root = FXMLLoader.load(getClass().getResource("/store/MD.fxml"));

			Scene sc = new Scene(root);
			sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			MDC.setScene(sc);
			MDC.setResizable(false);

			MDC.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Stage MDCView1;

	public void MDCName1() {

		Stage mainStage = (Stage) MDC1.getScene().getWindow();

		MDCView1 = new Stage(StageStyle.DECORATED);
		MDCView1.initModality(Modality.WINDOW_MODAL);
		MDCView1.initOwner(mainStage);

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/store/MDCName1.fxml"));
			Scene sc = new Scene(root);
			sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			MDCView1.setScene(sc);
			MDCView1.setResizable(false);
			MDCView1.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Stage MDCView2;

	public void MDCName2() {

		Stage mainStage = (Stage) MDC2.getScene().getWindow();

		MDCView2 = new Stage(StageStyle.DECORATED);
		MDCView2.initModality(Modality.WINDOW_MODAL);
		MDCView2.initOwner(mainStage);

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/store/MDCName2.fxml"));
			Scene sc = new Scene(root);
			sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			MDCView2.setScene(sc);
			MDCView2.setResizable(false);
			MDCView2.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Stage MDCView3;

	public void MDCName3() {

		Stage mainStage = (Stage) MDC3.getScene().getWindow();

		MDCView3 = new Stage(StageStyle.DECORATED);
		MDCView3.initModality(Modality.WINDOW_MODAL);
		MDCView3.initOwner(mainStage);

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/store/MDCName3.fxml"));
			Scene sc = new Scene(root);
			sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			MDCView3.setScene(sc);
			MDCView3.setResizable(false);
			MDCView3.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Stage MDCView4;

	public void MDCName4() {

		Stage mainStage = (Stage) MDC4.getScene().getWindow();

		MDCView4 = new Stage(StageStyle.DECORATED);
		MDCView4.initModality(Modality.WINDOW_MODAL);
		MDCView4.initOwner(mainStage);

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/store/MDCName4.fxml"));
			Scene sc = new Scene(root);
			sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			MDCView4.setScene(sc);
			MDCView4.setResizable(false);
			MDCView4.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Stage MDCView5;

	public void MDCName5() {

		Stage mainStage = (Stage) MDC5.getScene().getWindow();

		MDCView5 = new Stage(StageStyle.DECORATED);
		MDCView5.initModality(Modality.WINDOW_MODAL);
		MDCView5.initOwner(mainStage);

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/store/MDCName5.fxml"));
			Scene sc = new Scene(root);
			sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			MDCView5.setScene(sc);
			MDCView5.setResizable(false);
			MDCView5.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Stage MDCView6;

	public void MDCName6() {

		Stage mainStage = (Stage) MDC6.getScene().getWindow();

		MDCView6 = new Stage(StageStyle.DECORATED);
		MDCView6.initModality(Modality.WINDOW_MODAL);
		MDCView6.initOwner(mainStage);

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/store/MDCName6.fxml"));
			Scene sc = new Scene(root);
			sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			MDCView6.setScene(sc);
			MDCView6.setResizable(false);
			MDCView6.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void StudentClothes1() { // 학생일 때 옷이미지1
		System.out.println("clothes1");
		Image image = new Image("resource/clothes1.png");
		clothes1.setImage(image);
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

	private Stage clothesView1;

	public void clothesName1() {

		Stage mainStage = (Stage) clothes1.getScene().getWindow();

		clothesView1 = new Stage(StageStyle.DECORATED);
		clothesView1.initModality(Modality.WINDOW_MODAL);
		clothesView1.initOwner(mainStage);

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/store/clothesName1.fxml"));
			Scene sc = new Scene(root);
			sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			clothesView1.setScene(sc);
			clothesView1.setResizable(false);
			clothesView1.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Stage clothesView2;

	public void clothesName2() {

		Stage mainStage = (Stage) clothes2.getScene().getWindow();

		clothesView2 = new Stage(StageStyle.DECORATED);
		clothesView2.initModality(Modality.WINDOW_MODAL);
		clothesView2.initOwner(mainStage);

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/store/clothesName2.fxml"));
			Scene sc = new Scene(root);
			sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			clothesView2.setScene(sc);
			clothesView2.setResizable(false);
			clothesView2.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Stage clothesView3;

	public void clothesName3() {

		Stage mainStage = (Stage) clothes3.getScene().getWindow();

		clothesView3 = new Stage(StageStyle.DECORATED);
		clothesView3.initModality(Modality.WINDOW_MODAL);
		clothesView3.initOwner(mainStage);

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/store/clothesName3.fxml"));
			Scene sc = new Scene(root);
			sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			clothesView3.setScene(sc);
			clothesView3.setResizable(false);
			clothesView3.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Stage clothesView4;

	public void clothesName4() {

		Stage mainStage = (Stage) clothes4.getScene().getWindow();

		clothesView4 = new Stage(StageStyle.DECORATED);
		clothesView4.initModality(Modality.WINDOW_MODAL);
		clothesView4.initOwner(mainStage);

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/store/clothesName4.fxml"));
			Scene sc = new Scene(root);
			sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			clothesView4.setScene(sc);
			clothesView4.setResizable(false);
			clothesView4.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Stage clothesView5;

	public void clothesName5() {

		Stage mainStage = (Stage) clothes5.getScene().getWindow();

		clothesView5 = new Stage(StageStyle.DECORATED);
		clothesView5.initModality(Modality.WINDOW_MODAL);
		clothesView5.initOwner(mainStage);

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/store/clothesName5.fxml"));
			Scene sc = new Scene(root);
			sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			clothesView5.setScene(sc);
			clothesView5.setResizable(false);
			clothesView5.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Stage clothesView6;

	public void clothesName6() {

		Stage mainStage = (Stage) clothes6.getScene().getWindow();

		clothesView6 = new Stage(StageStyle.DECORATED);
		clothesView6.initModality(Modality.WINDOW_MODAL);
		clothesView6.initOwner(mainStage);

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/store/clothesName6.fxml"));
			Scene sc = new Scene(root);
			sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			clothesView6.setScene(sc);
			clothesView6.setResizable(false);
			clothesView6.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Stage clothesView7;

	public void clothesName7() {

		Stage mainStage = (Stage) clothes7.getScene().getWindow();

		clothesView7 = new Stage(StageStyle.DECORATED);
		clothesView7.initModality(Modality.WINDOW_MODAL);
		clothesView7.initOwner(mainStage);

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/store/clothesName7.fxml"));
			Scene sc = new Scene(root);
			sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			clothesView7.setScene(sc);
			clothesView7.setResizable(false);
			clothesView7.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Stage clothesView8;

	public void clothesName8() {

		Stage mainStage = (Stage) clothes8.getScene().getWindow();

		clothesView8 = new Stage(StageStyle.DECORATED);
		clothesView8.initModality(Modality.WINDOW_MODAL);
		clothesView8.initOwner(mainStage);

		try {
			Parent root = FXMLLoader.load(getClass().getResource("/store/clothesName8.fxml"));
			Scene sc = new Scene(root);
			sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			clothesView8.setScene(sc);
			clothesView8.setResizable(false);
			clothesView8.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 음식 구매하기
	@FXML
	private Button foodBtn1;
	@FXML
	private Button foodBtn2;
	@FXML
	private Button foodBtn3;
	@FXML
	private Button foodBtn4;
	@FXML
	private Button foodBtn5;
	@FXML
	private Button foodBtn6;
	// 약/청결용품 구매하기
	@FXML
	private Button MDCBtn1;
	@FXML
	private Button MDCBtn2;
	@FXML
	private Button MDCBtn3;
	@FXML
	private Button MDCBtn4;
	@FXML
	private Button MDCBtn5;
	@FXML
	private Button MDCBtn6;
	// 옷 구매하기
	@FXML
	private Button clothesBtn1;
	@FXML
	private Button clothesBtn2;
	@FXML
	private Button clothesBtn3;
	@FXML
	private Button clothesBtn4;
	@FXML
	private Button clothesBtn5;
	@FXML
	private Button clothesBtn6;
	

	// 음식1 insert
	public void clickFoodBtn1() {
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();

		Stage stage = (Stage) foodBtn1.getScene().getWindow(); // 팝업창 닫기
		stage.close();
		util.AppUtil.alert("구매 완료", null); // 구매 완료 알림

		PreparedStatement pstmt = null;
		String sql = "insert into food values(?,?)";

		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, "퐁퐁케이크");
			pstmt.setString(2, user);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 음식2 insert
	public void clickFoodBtn2() {
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();

		Stage stage = (Stage) foodBtn2.getScene().getWindow(); // 팝업창 닫기
		stage.close();
		util.AppUtil.alert("구매 완료", null); // 구매 완료 알림

		PreparedStatement pstmt = null;
		String sql = "insert into food values(?,?)";

		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, "플리즈핫도그WORLD");
			pstmt.setString(2, user);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 음식3 insert
	public void clickFoodBtn3() {
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();

		Stage stage = (Stage) foodBtn3.getScene().getWindow(); // 팝업창 닫기
		stage.close();
		util.AppUtil.alert("구매 완료", null); // 구매 완료 알림

		PreparedStatement pstmt = null;
		String sql = "insert into food values(?,?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "징징이정식");
			pstmt.setString(2, user);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 음식4 insert
	public void clickFoodBtn4() {
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();

		Stage stage = (Stage) foodBtn4.getScene().getWindow(); // 팝업창 닫기
		stage.close();
		util.AppUtil.alert("구매 완료", null); // 구매 완료 알림

		PreparedStatement pstmt = null;
		String sql = "insert into food values(?,?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "핑핑이밥");
			pstmt.setString(2, user);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 음식5 insert
	public void clickFoodBtn5() {
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();

		Stage stage = (Stage) foodBtn5.getScene().getWindow(); // 팝업창 닫기
		stage.close();
		util.AppUtil.alert("구매 완료", null); // 구매 완료 알림

		PreparedStatement pstmt = null;
		String sql = "insert into food values(?,?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "김건우");
			pstmt.setString(2, user);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 음식6 insert
	public void clickFoodBtn6() {
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();

		Stage stage = (Stage) foodBtn6.getScene().getWindow(); // 팝업창 닫기
		stage.close();
		util.AppUtil.alert("구매 완료", null); // 구매 완료 알림

		PreparedStatement pstmt = null;
		String sql = "insert into food values(?,?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "게살버거");
			pstmt.setString(2, user);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int MDid = 0;
	// 약1 insert
	public void clickMDBtn1() {
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();

		Stage stage = (Stage) MDCBtn1.getScene().getWindow(); // 팝업창 닫기
		stage.close();
		util.AppUtil.alert("구매 완료", null); // 구매 완료 알림

		PreparedStatement pstmt = null;
		String sql = "insert into MD values(?,?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "그냥약");
			pstmt.setString(2, user);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 약2 insert
	public void clickMDBtn2() {
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();

		Stage stage = (Stage) MDCBtn2.getScene().getWindow(); // 팝업창 닫기
		stage.close();
		util.AppUtil.alert("구매 완료", null); // 구매 완료 알림

		PreparedStatement pstmt = null;
		String sql = "insert into MD values(?,?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "징징이특효약");
			pstmt.setString(2, user);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 약3 insert
	public void clickMDBtn3() {
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();

		Stage stage = (Stage) MDCBtn3.getScene().getWindow(); // 팝업창 닫기
		stage.close();
		util.AppUtil.alert("구매 완료", null); // 구매 완료 알림

		PreparedStatement pstmt = null;
		String sql = "insert into MD values(?,?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "뚱약");
			pstmt.setString(2, user);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 약4 insert
	public void clickMDBtn4() {
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();

		Stage stage = (Stage) MDCBtn4.getScene().getWindow(); // 팝업창 닫기
		stage.close();
		util.AppUtil.alert("구매 완료", null); // 구매 완료 알림

		PreparedStatement pstmt = null;
		String sql = "insert into MD values(?,?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "오징어물약");
			pstmt.setString(2, user);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 약5 insert
	public void clickMDBtn5() {
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();

		Stage stage = (Stage) MDCBtn5.getScene().getWindow(); // 팝업창 닫기
		stage.close();
		util.AppUtil.alert("구매 완료", null); // 구매 완료 알림

		PreparedStatement pstmt = null;
		String sql = "insert into MD values(?,?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "네모바지약");
			pstmt.setString(2, user);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 약6 insert
	public void clickMDBtn6() {
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();

		Stage stage = (Stage) MDCBtn6.getScene().getWindow(); // 팝업창 닫기
		stage.close();
		util.AppUtil.alert("구매 완료", null); // 구매 완료 알림

		PreparedStatement pstmt = null;
		String sql = "insert into MD values(?,?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "인영이특효약");
			pstmt.setString(2, user);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
