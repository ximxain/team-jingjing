package music;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import appScene.MusicPop;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainController extends GameReady implements Initializable {

	MediaPlayer mp;
	Media m = null;

	@FXML
	Button btn;
	
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

	Image imgBlack;
	Image imgBlank;
	Image imgLife;
	Image imgLifeBlank;
	Image imgRed;
	Image imgBlue;

	static boolean exit = false;
	static boolean GOW = false;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println(musicNoteList.size());
		exit = false;
		GOW = false;
		String pathBlack = "src//resource/A,black.png";
		String pathBlank = "src//resource/A,blank.png";
		String pathLife = "src//resource/life.png";
		String pathLifeBlank = "src//resource/lifeBlank.png";
		String pathRed = "src//resource/A,red.png";
		String pathBlue = "src//resource/A,Blue.png";

		try {

			FileInputStream fisBlack = new FileInputStream(pathBlack);
			BufferedInputStream bisBlack = new BufferedInputStream(fisBlack);

			FileInputStream fisBlank = new FileInputStream(pathBlank);
			BufferedInputStream bisBlank = new BufferedInputStream(fisBlank);

			FileInputStream fisLife = new FileInputStream(pathLife);
			BufferedInputStream bisLife = new BufferedInputStream(fisLife);

			FileInputStream fisRed = new FileInputStream(pathRed);
			BufferedInputStream bisRed = new BufferedInputStream(fisRed);

			FileInputStream fisBlue = new FileInputStream(pathBlue);
			BufferedInputStream bisBlue = new BufferedInputStream(fisBlue);

			FileInputStream fisLifeBlank = new FileInputStream(pathLifeBlank);
			BufferedInputStream bisLifeBlank = new BufferedInputStream(fisLifeBlank);

			imgBlack = new Image(bisBlack);
			imgBlank = new Image(bisBlank);
			imgLife = new Image(bisLife);
			imgRed = new Image(bisRed);
			imgBlue = new Image(bisBlue);
			imgLifeBlank = new Image(bisLifeBlank);

			noteA1.setImage(imgBlack);
			noteA2.setImage(imgBlack);
			noteA3.setImage(imgBlack);
			noteA4.setImage(imgBlack);
			noteA5.setImage(imgBlack);

			notea1.setImage(imgBlack);
			notea2.setImage(imgBlack);
			notea3.setImage(imgBlack);
			notea4.setImage(imgBlack);
			notea5.setImage(imgBlack);

			noteB1.setImage(imgBlack);
			noteB2.setImage(imgBlack);
			noteB3.setImage(imgBlack);
			noteB4.setImage(imgBlack);
			noteB5.setImage(imgBlack);

			noteb1.setImage(imgBlack);
			noteb2.setImage(imgBlack);
			noteb3.setImage(imgBlack);
			noteb4.setImage(imgBlack);
			noteb5.setImage(imgBlack);

			life1.setImage(imgLife);
			life2.setImage(imgLife);
			life3.setImage(imgLife);
			life4.setImage(imgLife);
			life5.setImage(imgLife);

			scoreLabel.setText("Score: " + score);
			// String.valueOf(score)

			try {
				bisBlack.close();
				fisBlack.close();
				bisBlank.close();
				fisBlank.close();
				bisLife.close();
				fisLife.close();
				bisRed.close();
				fisRed.close();
				bisBlue.close();
				fisBlue.close();
				MusicStart();
				System.out.println(t);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void noteFlow1(ImageView notes) {
		notes.setImage(imgBlack);

	}

	public void redFlow(ImageView notes) {
		notes.setImage(imgRed);

	}

	public void noteFlow2(ImageView notes, ImageView notes2) {
		notes.setImage(imgBlack);
		notes2.setImage(imgBlack);
	}

	public void noteFlow3(ImageView notes, ImageView notes2, ImageView notes3) {
		notes.setImage(imgBlack);
		notes2.setImage(imgBlack);
		notes3.setImage(imgBlack);
	}

	public void noteFlow4(ImageView notes, ImageView notes2, ImageView notes3, ImageView notes4) {
		notes.setImage(imgBlack);
		notes2.setImage(imgBlack);
		notes3.setImage(imgBlack);
		notes4.setImage(imgBlack);
	}

	public void AllBlank() {
		noteA1.setImage(imgBlank);
		noteA2.setImage(imgBlank);
		noteA3.setImage(imgBlank);
		noteA4.setImage(imgBlank);
		noteA5.setImage(imgBlank);

		notea1.setImage(imgBlank);
		notea2.setImage(imgBlank);
		notea3.setImage(imgBlank);
		notea4.setImage(imgBlank);
		notea5.setImage(imgBlank);

		noteB1.setImage(imgBlank);
		noteB2.setImage(imgBlank);
		noteB3.setImage(imgBlank);
		noteB4.setImage(imgBlank);
		noteB5.setImage(imgBlank);

		noteb1.setImage(imgBlank);
		noteb2.setImage(imgBlank);
		noteb3.setImage(imgBlank);
		noteb4.setImage(imgBlank);
		noteb5.setImage(imgBlank);
	}

	@FXML
	public void keyP(KeyEvent key) {

		if (key.getCode() == KeyCode.D) {
			aClick();
		}
		if (key.getCode() == KeyCode.F) {
			AClick();
		}
		if (key.getCode() == KeyCode.J) {
			BClick();
		}
		if (key.getCode() == KeyCode.K) {
			bClick();
		}
	}

	public void MusicStart() {
		stopwatch(1);
		Thread musicThread = new Thread(new Runnable() {

			@Override
			public void run() {

				System.out.println("t is " + t);
				System.out.println(musicNoteList.size());
				for (int i = 5; i <= musicNoteList.size() - 5; i++) {
					if (exit == true) {
						System.out.println("?");
						break;
					}

					

					System.out.println(i);
					try {
						Thread.sleep(t);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();

					}

					if (A == 1) {
						hurt();
						A = 0;
					}
					;
					if (B == 1) {
						hurt();
						B = 0;
					}
					;
					if (C == 1) {
						hurt();
						C = 0;
					}
					;
					if (D == 1) {
						hurt();
						D = 0;
					}
					;
					A = 0;
					B = 0;
					C = 0;
					D = 0;
					AllBlank();
					next(i);
				}
				stopwatch(0);
				if (GOW == true) {
					gameOver();
					System.out.println("uuu");
				}
			}
		});

		musicThread.start();
	}

	public void aClick() {
		System.out.println("D");
		if (A == 1) {
			score = score + 100;
			blueFlow(notea5);
			A = 2;
			scoreLabel.setText("Score: " + score);
		} else if (A == 0) {
			hurt();
		}
	}

	public void AClick() {
		System.out.println("F");
		if (B == 1) {
			score = score + 100;
			blueFlow(noteA5);
			B = 2;
			scoreLabel.setText("Score: " + score);
		} else if (B == 0) {
			hurt();
		}
	}

	public void BClick() {
		System.out.println("J");
		if (C == 1) {
			score = score + 100;
			blueFlow(noteB5);
			C = 2;
			scoreLabel.setText("Score: " + score);
		} else if (C == 0) {
			hurt();
		}
	}

	public void bClick() {
		System.out.println("K");
		if (D == 1) {
			score = score + 100;
			blueFlow(noteb5);
			D = 2;
			scoreLabel.setText("Score: " + score);
		} else if (D == 0) {
			hurt();
		}
	}

	public void hurt() {
		System.out.println("hurt!");
		life--;
		if (life == 4) {
			fadeLife(life5);
			System.out.println("life 4");
		} else if (life == 3) {
			fadeLife(life5);
			fadeLife(life4);
			System.out.println("life 3");
		} else if (life == 2) {
			fadeLife(life5);
			fadeLife(life4);
			fadeLife(life3);
			System.out.println("life 2");
		} else if (life == 1) {
			fadeLife(life5);
			fadeLife(life4);
			fadeLife(life3);
			fadeLife(life2);
			System.out.println("life 1");
		} else if (life <= 0) {
			fadeLife(life5);
			fadeLife(life4);
			fadeLife(life3);
			fadeLife(life2);
			fadeLife(life1);
			GOW = true;
			exit = true;
		}
	}

	public void blueFlow(ImageView notes) {
		String path = "src//resource/A,blue.png";
		try {
			FileInputStream fis = new FileInputStream(path);
			BufferedInputStream bis = new BufferedInputStream(fis);
			Image img = new Image(bis);
			notes.setImage(img);
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

	Stage pop3;

	public void gameOver() {
		System.out.println("game over");
		exit = true;
	}

	public void fadeLife(ImageView notes) {
		notes.setImage(imgLifeBlank);
	}

	public void MusicDance(String musicName) {

		m = new Media(getClass().getResource("/musics/" + musicName + ".mp3").toString());
		mp = new MediaPlayer(m);
		Runnable onEnd = new Runnable() {
			@Override
			public void run() {
				mp.dispose();
				mp = new MediaPlayer(m);
				mp.play();
				mp.setOnEndOfMedia(this);
			}
		};
		mp.setOnEndOfMedia(onEnd);
		mp.play();

	}

	public void next(int i) {
		if (musicNoteList.get(i + 4).equals("0000")) {

		} else if (musicNoteList.get(i + 4).equals("0001")) {
			noteFlow1(noteb1);
		} else if (musicNoteList.get(i + 4).equals("0010")) {
			noteFlow1(noteB1);
		} else if (musicNoteList.get(i + 4).equals("0011")) {
			noteFlow2(noteB1, noteb1);
		} else if (musicNoteList.get(i + 4).equals("0100")) {
			noteFlow1(noteA1);
		} else if (musicNoteList.get(i + 4).equals("0101")) {
			noteFlow2(noteA1, noteb1);
		} else if (musicNoteList.get(i + 4).equals("0110")) {
			noteFlow2(noteA1, noteB1);
		} else if (musicNoteList.get(i + 4).equals("0111")) {
			noteFlow3(noteA1, noteB1, noteb1);
		} else if (musicNoteList.get(i + 4).equals("1000")) {
			noteFlow1(notea1);
		} else if (musicNoteList.get(i + 4).equals("1001")) {
			noteFlow2(notea1, noteb1);
		} else if (musicNoteList.get(i + 4).equals("1010")) {
			noteFlow2(notea1, noteB1);
		} else if (musicNoteList.get(i + 4).equals("1011")) {
			noteFlow3(notea1, noteB1, noteb1);
		} else if (musicNoteList.get(i + 4).equals("1100")) {
			noteFlow2(notea1, noteA1);
		} else if (musicNoteList.get(i + 4).equals("1101")) {
			noteFlow3(notea1, noteA1, noteb1);
		} else if (musicNoteList.get(i + 4).equals("1110")) {
			noteFlow3(notea1, noteA1, noteB1);
		} else if (musicNoteList.get(i + 4).equals("1111")) {
			noteFlow4(notea1, noteA1, noteB1, noteb1);
		}

		if (musicNoteList.get(i + 3).equals("0000")) {

		} else if (musicNoteList.get(i + 3).equals("0001")) {
			noteFlow1(noteb2);
		} else if (musicNoteList.get(i + 3).equals("0010")) {
			noteFlow1(noteB2);
		} else if (musicNoteList.get(i + 3).equals("0011")) {
			noteFlow2(noteB2, noteb2);
		} else if (musicNoteList.get(i + 3).equals("0100")) {
			noteFlow1(noteA2);
		} else if (musicNoteList.get(i + 3).equals("0101")) {
			noteFlow2(noteA2, noteb2);
		} else if (musicNoteList.get(i + 3).equals("0110")) {
			noteFlow2(noteA2, noteB2);
		} else if (musicNoteList.get(i + 3).equals("0111")) {
			noteFlow3(noteA2, noteB2, noteb2);
		} else if (musicNoteList.get(i + 3).equals("1000")) {
			noteFlow1(notea2);
		} else if (musicNoteList.get(i + 3).equals("1001")) {
			noteFlow2(notea2, noteb2);
		} else if (musicNoteList.get(i + 3).equals("1010")) {
			noteFlow2(notea2, noteB2);
		} else if (musicNoteList.get(i + 3).equals("1011")) {
			noteFlow3(notea2, noteB2, noteb2);
		} else if (musicNoteList.get(i + 3).equals("1100")) {
			noteFlow2(notea2, noteA2);
		} else if (musicNoteList.get(i + 3).equals("1101")) {
			noteFlow3(notea2, noteA2, noteb2);
		} else if (musicNoteList.get(i + 3).equals("1110")) {
			noteFlow3(notea2, noteA2, noteB2);
		} else if (musicNoteList.get(i + 3).equals("1111")) {
			noteFlow4(notea2, noteA2, noteB2, noteb2);
		}

		if (musicNoteList.get(i + 2).equals("0000")) {

		} else if (musicNoteList.get(i + 2).equals("0001")) {
			noteFlow1(noteb3);
		} else if (musicNoteList.get(i + 2).equals("0010")) {
			noteFlow1(noteB3);
		} else if (musicNoteList.get(i + 2).equals("0011")) {
			noteFlow2(noteB3, noteb3);
		} else if (musicNoteList.get(i + 2).equals("0100")) {
			noteFlow1(noteA3);
		} else if (musicNoteList.get(i + 2).equals("0101")) {
			noteFlow2(noteA3, noteb3);
		} else if (musicNoteList.get(i + 2).equals("0110")) {
			noteFlow2(noteA3, noteB3);
		} else if (musicNoteList.get(i + 2).equals("0111")) {
			noteFlow3(noteA3, noteB3, noteb3);
		} else if (musicNoteList.get(i + 2).equals("1000")) {
			noteFlow1(notea3);
		} else if (musicNoteList.get(i + 2).equals("1001")) {
			noteFlow2(notea3, noteb3);
		} else if (musicNoteList.get(i + 2).equals("1010")) {
			noteFlow2(notea3, noteB3);
		} else if (musicNoteList.get(i + 2).equals("1011")) {
			noteFlow3(notea3, noteB3, noteb3);
		} else if (musicNoteList.get(i + 2).equals("1100")) {
			noteFlow2(notea3, noteA3);
		} else if (musicNoteList.get(i + 2).equals("1101")) {
			noteFlow3(notea3, noteA3, noteb3);
		} else if (musicNoteList.get(i + 2).equals("1110")) {
			noteFlow3(notea3, noteA3, noteB3);
		} else if (musicNoteList.get(i + 2).equals("1111")) {
			noteFlow4(notea3, noteA3, noteB3, noteb3);
		}

		if (musicNoteList.get(i + 1).equals("0000")) {

		} else if (musicNoteList.get(i + 1).equals("0001")) {
			noteFlow1(noteb4);
		} else if (musicNoteList.get(i + 1).equals("0010")) {
			noteFlow1(noteB4);
		} else if (musicNoteList.get(i + 1).equals("0011")) {
			noteFlow2(noteB4, noteb4);
		} else if (musicNoteList.get(i + 1).equals("0100")) {
			noteFlow1(noteA4);
		} else if (musicNoteList.get(i + 1).equals("0101")) {
			noteFlow2(noteA4, noteb4);
		} else if (musicNoteList.get(i + 1).equals("0110")) {
			noteFlow2(noteA4, noteB4);
		} else if (musicNoteList.get(i + 1).equals("0111")) {
			noteFlow3(noteA4, noteB4, noteb4);
		} else if (musicNoteList.get(i + 1).equals("1000")) {
			noteFlow1(notea4);
		} else if (musicNoteList.get(i + 1).equals("1001")) {
			noteFlow2(notea4, noteb4);
		} else if (musicNoteList.get(i + 1).equals("1010")) {
			noteFlow2(notea4, noteB4);
		} else if (musicNoteList.get(i + 1).equals("1011")) {
			noteFlow3(notea4, noteB4, noteb4);
		} else if (musicNoteList.get(i + 1).equals("1100")) {
			noteFlow2(notea4, noteA4);
		} else if (musicNoteList.get(i + 1).equals("1101")) {
			noteFlow3(notea4, noteA4, noteb4);
		} else if (musicNoteList.get(i + 1).equals("1110")) {
			noteFlow3(notea4, noteA4, noteB4);
		} else if (musicNoteList.get(i + 1).equals("1111")) {
			noteFlow4(notea4, noteA4, noteB4, noteb4);
		}

		if (musicNoteList.get(i).equals("0000")) {

		} else if (musicNoteList.get(i).equals("0001")) {
			noteFlow1(noteb5);
			D = 1;
		} else if (musicNoteList.get(i).equals("0010")) {
			noteFlow1(noteB5);
			C = 1;
		} else if (musicNoteList.get(i).equals("0011")) {
			noteFlow2(noteB5, noteb5);
			C = 1;
			D = 1;
		} else if (musicNoteList.get(i).equals("0100")) {
			noteFlow1(noteA5);
			B = 1;
		} else if (musicNoteList.get(i).equals("0101")) {
			noteFlow2(noteA5, noteb5);
			B = 1;
			D = 1;
		} else if (musicNoteList.get(i).equals("0110")) {
			noteFlow2(noteA5, noteB5);
			B = 1;
			C = 1;
		} else if (musicNoteList.get(i).equals("0111")) {
			noteFlow3(noteA5, noteB5, noteb5);
			B = 1;
			C = 1;
			D = 1;
		} else if (musicNoteList.get(i).equals("1000")) {
			noteFlow1(notea5);
			A = 1;
		} else if (musicNoteList.get(i).equals("1001")) {
			noteFlow2(notea5, noteb5);
			A = 1;
			D = 1;
		} else if (musicNoteList.get(i).equals("1010")) {
			noteFlow2(notea5, noteB5);
			A = 1;
			C = 1;
		} else if (musicNoteList.get(i).equals("1011")) {
			noteFlow3(notea5, noteB5, noteb5);
			A = 1;
			C = 1;
			D = 1;
		} else if (musicNoteList.get(i).equals("1100")) {
			noteFlow2(notea5, noteA5);
			A = 1;
			B = 1;
		} else if (musicNoteList.get(i).equals("1101")) {
			noteFlow3(notea5, noteA5, noteb5);
			A = 1;
			B = 1;
			D = 1;
		} else if (musicNoteList.get(i).equals("1110")) {
			noteFlow3(notea5, noteA5, noteB5);
			A = 1;
			B = 1;
			C = 1;
		} else if (musicNoteList.get(i).equals("1111")) {
			noteFlow4(notea5, noteA5, noteB5, noteb5);
			A = 1;
			B = 1;
			C = 1;
			D = 1;
		}
	}

//	public void aClick() {
//		if (A == 1) {
//			score = score + 100;
//			blueFlow(notea5);
//			A = 0;
//			scoreLabel.setText("Score: " + score);
//		} else if (A == 0) {
//			hurt();
//		}
//	}
//
//	public void AClick() {
//		if (B == 1) {
//			score = score + 100;
//			blueFlow(noteA5);
//			B = 0;
//			scoreLabel.setText("Score: " + score);
//		} else if (B == 0) {
//			life = life - 1;
//			hurt();
//		}
//	}
//
//	public void BClick() {
//		if (C == 1) {
//			score = score + 100;
//			blueFlow(noteB5);
//			C = 0;
//			scoreLabel.setText("Score: " + score);
//		} else if (C == 0) {
//			life = life - 1;
//			hurt();
//		}
//	}
//
//	public void bClick() {
//		if (D == 1) {
//			score = score + 100;
//			blueFlow(noteb5);
//			D = 0;
//			scoreLabel.setText("Score: " + score);
//		} else if (D == 0) {
//			life = life - 1;
//			hurt();
//		}
//	}

	public void Music2() {
		AllBlank();
		System.out.println("music2");
		// musicNoteList.clear();
		try {
			txtRead("music2");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// MusicDance("night_bug_thread");
		MusicStart();

	}

	public void exit() {
		exit = true;
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/appScene/GameView.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// stop watch
	public static String timerBuffer;
	static int oldTime;
	static int time = 0;

	public static void stopwatch(int onOff) {
		if (onOff == 1)
			oldTime = (int) System.currentTimeMillis() / 1000;

		if (onOff == 0)
			secToHHMMSS(((int) System.currentTimeMillis() / 1000) - oldTime);
	}

	public static void secToHHMMSS(int secs) {
		int hour, min, sec;
		System.out.println(secs);
		;
		sec = secs % 60;
		min = secs / 60 % 60;
		hour = secs / 3600;

		timerBuffer = String.format("%02d:%02d:%02d", hour, min, sec);
		time = sec;
	}

}