package view;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.sun.javafx.stage.WindowHelper;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	protected Label presentGrowth;
	@FXML
	Label moneyLabel;

	@FXML
	public ImageView jingJingMain;
	
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
		try {
			System.out.println((double) presentExperience / limitExperience);
			experienceBar.setProgress((double) presentExperience / limitExperience);
			String statLabel = "";
			statLabel += currentStat[presentLevel] + "/";

			if (sick == 1) {
				statLabel += "아픔" + "/";
			} else {
				statLabel += "건강함" + "/";
			}

			if (hungry == 1) {
				statLabel += "배고픔";
			} else {
				statLabel += "배부름";
			}

			presentGrowth.setText(statLabel);
			moneyLabel.setText("" + money);

			FileInputStream fis = new FileInputStream("src//jingJingStat/" + currentStat[presentLevel] + ".png");
			BufferedInputStream bis = new BufferedInputStream(fis);

			Image img = new Image(bis);

			jingJingMain.setImage(img);
		} catch (Exception E) {

		}
	}

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
		
		if (presentLevel >= 1 && event1 == 0) {
			try {
				System.out.println("이벤트1 시청 시작");
				Parent login = FXMLLoader.load(getClass().getResource("/event/Event1.fxml"));
				Scene scene = new Scene(login);
				Stage primaryStage = (Stage) btn.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (presentLevel >= 2 && event2 == 0) {
			try {
				System.out.println("이벤트2 시청 시작");
				Parent login = FXMLLoader.load(getClass().getResource("/event/Event2.fxml"));
				Scene scene = new Scene(login);
				Stage primaryStage = (Stage) btn.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (presentLevel >= 3 && event3 == 0) {
			// 엔딩 여부
			if (endingWhether == 0) {
				try {
					System.out.println("배드엔딩 시청 시작");
					Parent login = FXMLLoader.load(getClass().getResource("/event/Event4.fxml"));
					Scene scene = new Scene(login);
					Stage primaryStage = (Stage) btn.getScene().getWindow();
					primaryStage.setScene(scene);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (endingWhether == 1) {
				try {
					System.out.println("해피엔딩 시청 시작");
					Parent login = FXMLLoader.load(getClass().getResource("/event/Event3.fxml"));
					Scene scene = new Scene(login);
					Stage primaryStage = (Stage) btn.getScene().getWindow();
					primaryStage.setScene(scene);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}

	}
}
