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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;
import util.AppUtil;
import util.JDBCUtil;

public class MainController implements Initializable {
	@FXML
	private Button changeGameView;

	@FXML
	ProgressBar experienceBar;

	@FXML
	protected Label presentGrowth;
	@FXML
	Label moneyLabel;

	int limitExperience;
	int presentExperience;
	int presentLevel;
	int money;
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
		limitExperience = 30;
		presentExperience = 20;
		money = 1000;
		presentLevel = 0;
		experienceBar.setProgress((double) presentExperience / limitExperience);
		presentGrowth.setText(currentStat[presentLevel]);
		moneyLabel.setText(""+money);
		db = new JDBCUtil();
		
		Connection con = db.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String user = "aaaa";
		String sql = "SELECT * FROM `jingjing_currentStat` WHERE userId = " + "'" + user + "'";
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Integer grows = rs.getInt("grows");
				Integer money = rs.getInt("money");
				presentLevel = rs.getInt("exp");
				
			}
		}catch (Exception e) {
			e.printStackTrace();
			AppUtil.alert("데이터 삽입 실패", null);
			return;
		}finally {
			if(rs != null) try { rs.close(); } catch (Exception e) {}
			if(stmt != null) try { stmt.close(); } catch (Exception e) {}
			if(con != null) try { con.close(); } catch (Exception e) {}
		}
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

}
