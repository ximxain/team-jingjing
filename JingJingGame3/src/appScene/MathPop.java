package appScene;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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

public class MathPop extends GameController {
	public Stage pop2;
	static public String modChoice = "easy";

	@FXML
	ImageView easy;
	@FXML
	ImageView nomal;
	@FXML
	ImageView hard;
	@FXML
	ImageView superHard;

	static public int presentStep = 0;

	@FXML
	Button closebtn2;

	public void clickEasy() {
		String path = "src//resource/choose.png";
		String path2 = "src//resource/nonchoose.png";
		try {
			FileInputStream fis = new FileInputStream(path);
			BufferedInputStream bis = new BufferedInputStream(fis);
			Image img = new Image(bis);
			FileInputStream fis2 = new FileInputStream(path2);
			BufferedInputStream bis2 = new BufferedInputStream(fis2);
			Image img2 = new Image(bis2);
			easy.setImage(img);
			hard.setImage(img2);
			nomal.setImage(img2);
			superHard.setImage(img2);
			try {

				bis.close();
				fis.close();
				modChoice = "easy";
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("img");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void clickNomal() {
		String path = "src//resource/choose.png";
		String path2 = "src//resource/nonchoose.png";
		try {
			FileInputStream fis = new FileInputStream(path);
			BufferedInputStream bis = new BufferedInputStream(fis);
			Image img = new Image(bis);
			FileInputStream fis2 = new FileInputStream(path2);
			BufferedInputStream bis2 = new BufferedInputStream(fis2);
			Image img2 = new Image(bis2);
			easy.setImage(img2);
			hard.setImage(img2);
			nomal.setImage(img);
			superHard.setImage(img2);
			modChoice = "nomal";
			try {

				bis.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("img");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void clickHard() {
		String path = "src//resource/choose.png";
		String path2 = "src//resource/nonchoose.png";
		try {
			FileInputStream fis = new FileInputStream(path);
			BufferedInputStream bis = new BufferedInputStream(fis);
			Image img = new Image(bis);
			FileInputStream fis2 = new FileInputStream(path2);
			BufferedInputStream bis2 = new BufferedInputStream(fis2);
			Image img2 = new Image(bis2);
			easy.setImage(img2);
			hard.setImage(img);
			nomal.setImage(img2);
			superHard.setImage(img2);
			modChoice = "hard";
			try {

				bis.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("img");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void clickSuperHard() {
		String path = "src//resource/choose.png";
		String path2 = "src//resource/nonchoose.png";
		try {
			FileInputStream fis = new FileInputStream(path);
			BufferedInputStream bis = new BufferedInputStream(fis);
			Image img = new Image(bis);
			FileInputStream fis2 = new FileInputStream(path2);
			BufferedInputStream bis2 = new BufferedInputStream(fis2);
			Image img2 = new Image(bis2);
			easy.setImage(img2);
			hard.setImage(img2);
			nomal.setImage(img2);
			superHard.setImage(img);
			modChoice = "super hard";
			try {

				bis.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("img");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void gameStart() {
		presentStep = 0;
		pop = (Stage) closebtn2.getScene().getWindow();
		pop.close();

		try {
			Parent login = FXMLLoader.load(getClass().getResource("/math/Scene.fxml"));
			Scene scene = new Scene(login);
			mainStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		mainStage = (Stage) closebtn2.getScene().getWindow();
//
//		pop2 = new Stage(StageStyle.DECORATED);
//		pop2.initModality(Modality.WINDOW_MODAL);
//		pop2.initOwner(mainStage);
//
//		try {
//			Parent root = FXMLLoader.load(getClass().getResource("/math/Scene.fxml"));
//
//			Scene sc = new Scene(root);
//			sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
//			pop2.setScene(sc);
//			pop2.setTitle("pop");
//			pop2.setResizable(false);
//
//			pop2.show();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
}
