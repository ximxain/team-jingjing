package music;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import util.AppUtil;

public class GameReady implements Initializable {
	@FXML
	Button btn;

	public int A, B, C, D;
	public int score;
	public static int t = 0;
	public int musicE = 0;
	public int limitTimeOfMusic;

	static public String scoreV = "Score:0";

	static public int life = 5;

	@FXML
	public ComboBox<String> combobox;

	ObservableList<String> list = FXCollections.observableArrayList("플라워 댄스", "222", "John", "Jack");

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		combobox.setItems(list);
	}

	public void gameStart() {
		if (combobox.getValue() == null) {
			AppUtil.alert("음악을 선택하십시오.", "");
		} else {

			life = 5;
			score = 0;
			musicE = 0;

			System.out.println(combobox.getValue());
			musicNoteList.clear();
			try {
				txtRead("악보 "+combobox.getValue());
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
		File file = new File("src//resource/" + txtLink + ".txt");

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
}
