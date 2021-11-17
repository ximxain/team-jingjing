package appScene;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import music.MainController;

public class MusicPop extends GameController {
	private HashMap<KeyCode, Boolean> keys = new HashMap<>();
	public Stage pop3;
	public Stage pop2;
	public static Scene sc;
	static public String modChoice = "easy";

	@FXML
	public Label scoreLabel;

	@FXML
	public ImageView noteA1;
	@FXML
	public ImageView noteA2;
	@FXML
	public ImageView noteA3;
	@FXML
	public ImageView noteA4;
	@FXML
	public ImageView noteA5;

	@FXML
	public ImageView notea1;
	@FXML
	public ImageView notea2;
	@FXML
	public ImageView notea3;
	@FXML
	public ImageView notea4;
	@FXML
	public ImageView notea5;

	@FXML
	public ImageView noteB1;
	@FXML
	public ImageView noteB2;
	@FXML
	public ImageView noteB3;
	@FXML
	public ImageView noteB4;
	@FXML
	public ImageView noteB5;

	@FXML
	public ImageView noteb1;
	@FXML
	public ImageView noteb2;
	@FXML
	public ImageView noteb3;
	@FXML
	public ImageView noteb4;
	@FXML
	public ImageView noteb5;

	@FXML
	public ImageView life1;
	@FXML
	public ImageView life2;
	@FXML
	public ImageView life3;
	@FXML
	public ImageView life4;
	@FXML
	public ImageView life5;

	@FXML
	ImageView music1;
	@FXML
	ImageView music2;
	@FXML
	ImageView music3;
	@FXML
	ImageView music4;

	static public int A, B, C, D = 0;
	static public int score = 0;
	static public int musicE = 0;

	static public String scoreV = "Score:" + score;

	static public int life = 5;

	@FXML
	Button closebtn2;

	public void gameStart() {
		pop = (Stage) closebtn2.getScene().getWindow();
		pop.close();
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/music/Scene.fxml"));
			Scene scene = new Scene(login);
			mainStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
