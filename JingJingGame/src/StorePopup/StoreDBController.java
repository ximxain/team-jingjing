package StorePopup;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import store.StoreController;
import util.JDBCUtil;

public class StoreDBController {
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

	// insert

	public void clickMDBtn1() {
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();

		PreparedStatement pstmt = null;
		String sql = "insert into MD values(?,?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "약1");
			pstmt.setString(2, "코인 가격");
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/store/Store.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) MDCBtn1.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
