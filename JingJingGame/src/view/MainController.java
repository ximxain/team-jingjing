package view;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;
import login.Login;
import util.AppUtil;
import util.JDBCUtil;

public class MainController extends Login implements Initializable {
	@FXML
	private Button changeGameView;
	@FXML
	private Button btn;

	@FXML
	ProgressBar experienceBar;
	
	@FXML
	ProgressBar hungry;
	
	@FXML
	ProgressBar sick;

	@FXML
	protected Label presentGrowth;
	@FXML
	Label moneyLabel;

	int limitExperience = 1000;
	
	protected String[] currentStat = { "애기", "유딩", "학생", "성인" };
	private JDBCUtil db;

	public void jingJingStat() {

	}

	public void changeToGameView() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/appScene/GameView.fxml"));
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
			Parent login = FXMLLoader.load(getClass().getResource("/store/Store.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) changeStore.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	private Button changeAD;

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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		experienceBar.setProgress((double) presentExperience / limitExperience);
		hungry.setProgress(0.5);
		sick.setProgress(0.2);
		presentGrowth.setText(currentStat[presentLevel]);
		moneyLabel.setText(""+money);
	}

	// 버튼 클릭 하면 음성나오기(징징이)

	// 프롤로그(임시)
	public void changeSceneToProlog() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/prolog/prolog.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) changeGameView.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showEvent() {
		if(presentLevel >= 2 && event1 == 0) {
			try {
			System.out.println("이벤트1 시청 시작");
			Parent login = FXMLLoader.load(getClass().getResource("/event/Event1.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			AppUtil.alert("현재 예정된 이벤트가 없습니다.", "");
		}
	}
	
	public void up() {
		util.JDBCUtil db = new util.JDBCUtil();
		Connection con = db.getConnection();
		// PreparedStatement 날릴 것을 저장해두는 곳
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "UPDATE jingjing_currentStat SET exp =" + presentExperience +" , money =" + money + ", grows = "+presentLevel+" where userId ='"+user+"'";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();

			System.out.println("정보가 데이터 베이스로 갔어요");
			System.out.println("exp: "+presentExperience);
			System.out.println("money: "+money);
			System.out.println("level: "+presentLevel);

			// insert, update, delete

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("정보가 데이터 베이스로 못감 ㅋㅋ");
		}
	}

}
