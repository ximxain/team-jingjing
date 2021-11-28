package music;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.sound.sampled.Clip;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import util.AppUtil;

public class GameReady implements Initializable {
	@FXML
	Button btn;
	@FXML
	public ComboBox<String> combobox;
	@FXML
	Label gameExplanation;

	MediaPlayer mp;
	Media m = null;

	static public int adder = 0;

	public int A, B, C, D;
	public int score;
	public static int t = 0;
	public int musicE = 0;
	public int limitTimeOfMusic;

	static public String scoreV = "Score:0";

	static public String musicLink;

	static public int life = 5;

	ObservableList<String> list = FXCollections.observableArrayList("piano", "Twilight Express", "둥근 바다", "KING");

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		combobox.setItems(list);
		gameExplanation.setText("무대로 올라가 연주를 합니다.\nD, F, J, K로 조종합니다.\n연주를 마치면 내려옵니다. \n중간에 미리 내려올 수도 있습니다.");
	}

	public void gameStart() {
		if (combobox.getValue() == null) {
			AppUtil.alert("음악을 선택하십시오.", "");
		} else {
			adder = 0;
			life = 5;
			score = 0;
			musicE = 0;
			musicLink = combobox.getValue();
			System.out.println(combobox.getValue());
			musicNoteList.clear();
			try {
				txtRead(combobox.getValue());
				limitTimeOfMusic = Integer.parseInt(musicNoteList.get(2));
				t = Integer.parseInt(musicNoteList.get(0));
				System.out.println("t: " + t);

				try {
					Parent login = FXMLLoader.load(getClass().getResource("/music/Scene.fxml"));
					Scene scene = new Scene(login);
					Stage primaryStage = (Stage) btn.getScene().getWindow();
					primaryStage.setScene(scene);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static ArrayList<String> musicNoteList = new ArrayList<String>();

	public void txtRead(String txtLink) throws IOException {
		File file = new File("src//musicResource/" + txtLink + ".txt");

		/*
		 * 
		 */
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String str;
		System.out.println("@@@@@@@@@@@@");
		while ((str = reader.readLine()) != null) {
			musicNoteList.add(str);
		}
		musicNoteList.add("0000");
		musicNoteList.add("0000");
		musicNoteList.add("0000");
		musicNoteList.add("0000");
		musicNoteList.add("0000");
		for (int i = 0; i < musicNoteList.size(); i++) {
			System.out.println("music1: " + musicNoteList.get(i));
		}
		reader.close();
	}

	public void ReadyExit() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/appScene/GameView.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
