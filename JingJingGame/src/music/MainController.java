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
import javafx.scene.media.MediaView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import util.AppUtil;

public class MainController extends GameReady implements Initializable {

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

	@FXML
	public Label stateLabel;

	@FXML
	private MediaView mediaView;

	Image imgBlack;
	Image imgBlank;
	Image imgLife;
	Image imgLifeBlank;
	Image imgRed;
	Image imgBlue;

	static boolean start = false;
	static boolean exit = false;
	static boolean GOW = false;
	static boolean clear = false;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		System.out.println(musicNoteList.size());
		exit = false;
		GOW = false;
		clear = false;
		start = false;
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
			stateLabel.setText("D, F, J, K??? ????????? ??????\n????????? ???????????????.");
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
		stateLabel.setText(null);

//		//???????????? 
		m = new Media(getClass().getResource("/musicResource/" + musicLink + ".mp3").toString());
		mp = new MediaPlayer(m);
		mp.play();

		Thread musicThread = new Thread(new Runnable() {

			@Override
			public void run() {

				System.out.println("t is " + t);
				System.out.println(musicNoteList.size());
				for (int i = 5; i <= musicNoteList.size() - 5; i++) {
					if (exit == true) {
						System.out.println("????????????");
						break;
					}

					System.out.println(i - 4);
					adder = i - 4;
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
					next(i);
				}
				mp.stop();
				if (exit == false) {
					System.out.println("clear");
					clear = true;
				}
			}
		});

		musicThread.start();
	}

	public void aClick() {
		if (start == true) {
			if (clear == true) {
				stateLabel.setText("????????? ??????????????? ???????????????.\n???????????? ???????????????.");
			} else {
				System.out.println("D");
				if (A == 1) {
					score = score + 100;
					blueFlow(notea5);
					A = 2;
					scoreLabel.setText("Score: " + score);
				} else if (A == 0) {
					if (life <= 0)
						stateLabel.setText("????????? ???????????????.\n?????? ???????????? ???????????????.");
					hurt();
				}
			}
		} else {
			start = true;
			MusicStart();
		}

	}

	public void AClick() {
		if (start == true) {
			if (clear == true) {
				stateLabel.setText("????????? ??????????????? ???????????????.\n???????????? ???????????????.");
			} else {
				System.out.println("F");
				if (B == 1) {
					score = score + 100;
					blueFlow(noteA5);
					B = 2;
					scoreLabel.setText("Score: " + score);
				} else if (B == 0) {
					if (life <= 0)
						stateLabel.setText("????????? ???????????????.\n?????? ???????????? ???????????????.");
					hurt();
				}
			}
		} else {
			start = true;
			MusicStart();
		}

	}

	public void BClick() {
		if (start == true) {
			if (clear == true) {
				stateLabel.setText("????????? ??????????????? ???????????????.\n???????????? ???????????????.");
			} else {
				System.out.println("J");
				if (C == 1) {
					score = score + 100;
					blueFlow(noteB5);
					C = 2;
					scoreLabel.setText("Score: " + score);
				} else if (C == 0) {
					if (life <= 0)
						stateLabel.setText("????????? ???????????????.\n?????? ???????????? ???????????????.");
					hurt();
				}
			}
		} else {
			start = true;
			MusicStart();
		}
	}

	public void bClick() {
		if (start == true) {
			if (clear == true) {
				stateLabel.setText("????????? ??????????????? ???????????????.\n???????????? ???????????????.");
			} else {
				System.out.println("K");
				if (D == 1) {
					score = score + 100;
					blueFlow(noteb5);
					D = 2;
					scoreLabel.setText("Score: " + score);
				} else if (D == 0) {
					if (life <= 0)
						stateLabel.setText("????????? ???????????????.\n?????? ???????????? ???????????????.");
					hurt();
				}
			}
		} else {
			start = true;
			MusicStart();
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
			clear = false;
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
		exit = true;
		System.out.println("game over");
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/music/GameOver.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) btn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fadeLife(ImageView notes) {
		notes.setImage(imgLifeBlank);
	}

	public void next(int i) {
		if (musicNoteList.get(i + 4).equals("0000")) {
			notea1.setImage(imgBlank);
			noteA1.setImage(imgBlank);
			noteB1.setImage(imgBlank);
			noteb1.setImage(imgBlank);
		} else if (musicNoteList.get(i + 4).equals("0001")) {
			notea1.setImage(imgBlank);
			noteA1.setImage(imgBlank);
			noteB1.setImage(imgBlank);
			noteb1.setImage(imgBlack);
		} else if (musicNoteList.get(i + 4).equals("0010")) {
			notea1.setImage(imgBlank);
			noteA1.setImage(imgBlank);
			noteB1.setImage(imgBlack);
			noteb1.setImage(imgBlank);
		} else if (musicNoteList.get(i + 4).equals("0011")) {
			notea1.setImage(imgBlank);
			noteA1.setImage(imgBlank);
			noteB1.setImage(imgBlack);
			noteb1.setImage(imgBlack);
		} else if (musicNoteList.get(i + 4).equals("0100")) {
			notea1.setImage(imgBlank);
			noteA1.setImage(imgBlack);
			noteB1.setImage(imgBlank);
			noteb1.setImage(imgBlank);
		} else if (musicNoteList.get(i + 4).equals("0101")) {
			notea1.setImage(imgBlank);
			noteA1.setImage(imgBlack);
			noteB1.setImage(imgBlank);
			noteb1.setImage(imgBlack);
		} else if (musicNoteList.get(i + 4).equals("0110")) {
			notea1.setImage(imgBlank);
			noteA1.setImage(imgBlack);
			noteB1.setImage(imgBlack);
			noteb1.setImage(imgBlank);
		} else if (musicNoteList.get(i + 4).equals("0111")) {
			notea1.setImage(imgBlank);
			noteA1.setImage(imgBlack);
			noteB1.setImage(imgBlack);
			noteb1.setImage(imgBlack);
		} else if (musicNoteList.get(i + 4).equals("1000")) {
			notea1.setImage(imgBlack);
			noteA1.setImage(imgBlank);
			noteB1.setImage(imgBlank);
			noteb1.setImage(imgBlank);
		} else if (musicNoteList.get(i + 4).equals("1001")) {
			notea1.setImage(imgBlack);
			noteA1.setImage(imgBlank);
			noteB1.setImage(imgBlank);
			noteb1.setImage(imgBlack);
		} else if (musicNoteList.get(i + 4).equals("1010")) {
			notea1.setImage(imgBlack);
			noteA1.setImage(imgBlank);
			noteB1.setImage(imgBlack);
			noteb1.setImage(imgBlank);
		} else if (musicNoteList.get(i + 4).equals("1011")) {
			notea1.setImage(imgBlack);
			noteA1.setImage(imgBlank);
			noteB1.setImage(imgBlack);
			noteb1.setImage(imgBlack);
		} else if (musicNoteList.get(i + 4).equals("1100")) {
			notea1.setImage(imgBlack);
			noteA1.setImage(imgBlack);
			noteB1.setImage(imgBlank);
			noteb1.setImage(imgBlank);
		} else if (musicNoteList.get(i + 4).equals("1101")) {
			notea1.setImage(imgBlack);
			noteA1.setImage(imgBlack);
			noteB1.setImage(imgBlank);
			noteb1.setImage(imgBlack);
		} else if (musicNoteList.get(i + 4).equals("1110")) {
			notea1.setImage(imgBlack);
			noteA1.setImage(imgBlack);
			noteB1.setImage(imgBlack);
			noteb1.setImage(imgBlank);
		} else if (musicNoteList.get(i + 4).equals("1111")) {
			notea1.setImage(imgBlack);
			noteA1.setImage(imgBlack);
			noteB1.setImage(imgBlack);
			noteb1.setImage(imgBlack);
		}
//**************************************************
		if (musicNoteList.get(i + 3).equals("0000")) {
			notea2.setImage(imgBlank);
			noteA2.setImage(imgBlank);
			noteB2.setImage(imgBlank);
			noteb2.setImage(imgBlank);
		} else if (musicNoteList.get(i + 3).equals("0001")) {
			notea2.setImage(imgBlank);
			noteA2.setImage(imgBlank);
			noteB2.setImage(imgBlank);
			noteb2.setImage(imgBlack);
		} else if (musicNoteList.get(i + 3).equals("0010")) {
			notea2.setImage(imgBlank);
			noteA2.setImage(imgBlank);
			noteB2.setImage(imgBlack);
			noteb2.setImage(imgBlank);
		} else if (musicNoteList.get(i + 3).equals("0011")) {
			notea2.setImage(imgBlank);
			noteA2.setImage(imgBlank);
			noteB2.setImage(imgBlack);
			noteb2.setImage(imgBlack);
		} else if (musicNoteList.get(i + 3).equals("0100")) {
			notea2.setImage(imgBlank);
			noteA2.setImage(imgBlack);
			noteB2.setImage(imgBlank);
			noteb2.setImage(imgBlank);
		} else if (musicNoteList.get(i + 3).equals("0101")) {
			notea2.setImage(imgBlank);
			noteA2.setImage(imgBlack);
			noteB2.setImage(imgBlank);
			noteb2.setImage(imgBlack);
		} else if (musicNoteList.get(i + 3).equals("0110")) {
			notea2.setImage(imgBlank);
			noteA2.setImage(imgBlack);
			noteB2.setImage(imgBlack);
			noteb2.setImage(imgBlank);
		} else if (musicNoteList.get(i + 3).equals("0111")) {
			notea2.setImage(imgBlank);
			noteA2.setImage(imgBlack);
			noteB2.setImage(imgBlack);
			noteb2.setImage(imgBlack);
		} else if (musicNoteList.get(i + 3).equals("1000")) {
			notea2.setImage(imgBlack);
			noteA2.setImage(imgBlank);
			noteB2.setImage(imgBlank);
			noteb2.setImage(imgBlank);
		} else if (musicNoteList.get(i + 3).equals("1001")) {
			notea2.setImage(imgBlack);
			noteA2.setImage(imgBlank);
			noteB2.setImage(imgBlank);
			noteb2.setImage(imgBlack);
		} else if (musicNoteList.get(i + 3).equals("1010")) {
			notea2.setImage(imgBlack);
			noteA2.setImage(imgBlank);
			noteB2.setImage(imgBlack);
			noteb2.setImage(imgBlank);
		} else if (musicNoteList.get(i + 3).equals("1011")) {
			notea2.setImage(imgBlack);
			noteA2.setImage(imgBlank);
			noteB2.setImage(imgBlack);
			noteb2.setImage(imgBlack);
		} else if (musicNoteList.get(i + 3).equals("1100")) {
			notea2.setImage(imgBlack);
			noteA2.setImage(imgBlack);
			noteB2.setImage(imgBlank);
			noteb2.setImage(imgBlank);
		} else if (musicNoteList.get(i + 3).equals("1101")) {
			notea2.setImage(imgBlack);
			noteA2.setImage(imgBlack);
			noteB2.setImage(imgBlank);
			noteb2.setImage(imgBlack);
		} else if (musicNoteList.get(i + 3).equals("1110")) {
			notea2.setImage(imgBlack);
			noteA2.setImage(imgBlack);
			noteB2.setImage(imgBlack);
			noteb2.setImage(imgBlank);
		} else if (musicNoteList.get(i + 3).equals("1111")) {
			notea2.setImage(imgBlack);
			noteA2.setImage(imgBlack);
			noteB2.setImage(imgBlack);
			noteb2.setImage(imgBlack);
		}
		// **************************************************
		if (musicNoteList.get(i + 2).equals("0000")) {
			notea3.setImage(imgBlank);
			noteA3.setImage(imgBlank);
			noteB3.setImage(imgBlank);
			noteb3.setImage(imgBlank);
		} else if (musicNoteList.get(i + 2).equals("0001")) {
			notea3.setImage(imgBlank);
			noteA3.setImage(imgBlank);
			noteB3.setImage(imgBlank);
			noteb3.setImage(imgBlack);
		} else if (musicNoteList.get(i + 2).equals("0010")) {
			notea3.setImage(imgBlank);
			noteA3.setImage(imgBlank);
			noteB3.setImage(imgBlack);
			noteb3.setImage(imgBlank);
		} else if (musicNoteList.get(i + 2).equals("0011")) {
			notea3.setImage(imgBlank);
			noteA3.setImage(imgBlank);
			noteB3.setImage(imgBlack);
			noteb3.setImage(imgBlack);
		} else if (musicNoteList.get(i + 2).equals("0100")) {
			notea3.setImage(imgBlank);
			noteA3.setImage(imgBlack);
			noteB3.setImage(imgBlank);
			noteb3.setImage(imgBlank);
		} else if (musicNoteList.get(i + 2).equals("0101")) {
			notea3.setImage(imgBlank);
			noteA3.setImage(imgBlack);
			noteB3.setImage(imgBlank);
			noteb3.setImage(imgBlack);
		} else if (musicNoteList.get(i + 2).equals("0110")) {
			notea3.setImage(imgBlank);
			noteA3.setImage(imgBlack);
			noteB3.setImage(imgBlack);
			noteb3.setImage(imgBlank);
		} else if (musicNoteList.get(i + 2).equals("0111")) {
			notea3.setImage(imgBlank);
			noteA3.setImage(imgBlack);
			noteB3.setImage(imgBlack);
			noteb3.setImage(imgBlack);
		} else if (musicNoteList.get(i + 2).equals("1000")) {
			notea3.setImage(imgBlack);
			noteA3.setImage(imgBlank);
			noteB3.setImage(imgBlank);
			noteb3.setImage(imgBlank);
		} else if (musicNoteList.get(i + 2).equals("1001")) {
			notea3.setImage(imgBlack);
			noteA3.setImage(imgBlank);
			noteB3.setImage(imgBlank);
			noteb3.setImage(imgBlack);
		} else if (musicNoteList.get(i + 2).equals("1010")) {
			notea3.setImage(imgBlack);
			noteA3.setImage(imgBlank);
			noteB3.setImage(imgBlack);
			noteb3.setImage(imgBlank);
		} else if (musicNoteList.get(i + 2).equals("1011")) {
			notea3.setImage(imgBlack);
			noteA3.setImage(imgBlank);
			noteB3.setImage(imgBlack);
			noteb3.setImage(imgBlack);
		} else if (musicNoteList.get(i + 2).equals("1100")) {
			notea3.setImage(imgBlack);
			noteA3.setImage(imgBlack);
			noteB3.setImage(imgBlank);
			noteb3.setImage(imgBlank);
		} else if (musicNoteList.get(i + 2).equals("1101")) {
			notea3.setImage(imgBlack);
			noteA3.setImage(imgBlack);
			noteB3.setImage(imgBlank);
			noteb3.setImage(imgBlack);
		} else if (musicNoteList.get(i + 2).equals("1110")) {
			notea3.setImage(imgBlack);
			noteA3.setImage(imgBlack);
			noteB3.setImage(imgBlack);
			noteb3.setImage(imgBlank);
		} else if (musicNoteList.get(i + 2).equals("1111")) {
			notea3.setImage(imgBlack);
			noteA3.setImage(imgBlack);
			noteB3.setImage(imgBlack);
			noteb3.setImage(imgBlack);
		}

		// **************************************************
		if (musicNoteList.get(i + 1).equals("0000")) {
			notea4.setImage(imgBlank);
			noteA4.setImage(imgBlank);
			noteB4.setImage(imgBlank);
			noteb4.setImage(imgBlank);
		} else if (musicNoteList.get(i + 1).equals("0001")) {
			notea4.setImage(imgBlank);
			noteA4.setImage(imgBlank);
			noteB4.setImage(imgBlank);
			noteb4.setImage(imgBlack);
		} else if (musicNoteList.get(i + 1).equals("0010")) {
			notea4.setImage(imgBlank);
			noteA4.setImage(imgBlank);
			noteB4.setImage(imgBlack);
			noteb4.setImage(imgBlank);
		} else if (musicNoteList.get(i + 1).equals("0011")) {
			notea4.setImage(imgBlank);
			noteA4.setImage(imgBlank);
			noteB4.setImage(imgBlack);
			noteb4.setImage(imgBlack);
		} else if (musicNoteList.get(i + 1).equals("0100")) {
			notea4.setImage(imgBlank);
			noteA4.setImage(imgBlack);
			noteB4.setImage(imgBlank);
			noteb4.setImage(imgBlank);
		} else if (musicNoteList.get(i + 1).equals("0101")) {
			notea4.setImage(imgBlank);
			noteA4.setImage(imgBlack);
			noteB4.setImage(imgBlank);
			noteb4.setImage(imgBlack);
		} else if (musicNoteList.get(i + 1).equals("0110")) {
			notea4.setImage(imgBlank);
			noteA4.setImage(imgBlack);
			noteB4.setImage(imgBlack);
			noteb4.setImage(imgBlank);
		} else if (musicNoteList.get(i + 1).equals("0111")) {
			notea4.setImage(imgBlank);
			noteA4.setImage(imgBlack);
			noteB4.setImage(imgBlack);
			noteb4.setImage(imgBlack);
		} else if (musicNoteList.get(i + 1).equals("1000")) {
			notea4.setImage(imgBlack);
			noteA4.setImage(imgBlank);
			noteB4.setImage(imgBlank);
			noteb4.setImage(imgBlank);
		} else if (musicNoteList.get(i + 1).equals("1001")) {
			notea4.setImage(imgBlack);
			noteA4.setImage(imgBlank);
			noteB4.setImage(imgBlank);
			noteb4.setImage(imgBlack);
		} else if (musicNoteList.get(i + 1).equals("1010")) {
			notea4.setImage(imgBlack);
			noteA4.setImage(imgBlank);
			noteB4.setImage(imgBlack);
			noteb4.setImage(imgBlank);
		} else if (musicNoteList.get(i + 1).equals("1011")) {
			notea4.setImage(imgBlack);
			noteA4.setImage(imgBlank);
			noteB4.setImage(imgBlack);
			noteb4.setImage(imgBlack);
		} else if (musicNoteList.get(i + 1).equals("1100")) {
			notea4.setImage(imgBlack);
			noteA4.setImage(imgBlack);
			noteB4.setImage(imgBlank);
			noteb4.setImage(imgBlank);
		} else if (musicNoteList.get(i + 1).equals("1101")) {
			notea4.setImage(imgBlack);
			noteA4.setImage(imgBlack);
			noteB4.setImage(imgBlank);
			noteb4.setImage(imgBlack);
		} else if (musicNoteList.get(i + 1).equals("1110")) {
			notea4.setImage(imgBlack);
			noteA4.setImage(imgBlack);
			noteB4.setImage(imgBlack);
			noteb4.setImage(imgBlank);
		} else if (musicNoteList.get(i + 1).equals("1111")) {
			notea4.setImage(imgBlack);
			noteA4.setImage(imgBlack);
			noteB4.setImage(imgBlack);
			noteb4.setImage(imgBlack);
		}

		// **************************************************
		if (musicNoteList.get(i).equals("0000")) {
			notea5.setImage(imgBlank);
			noteA5.setImage(imgBlank);
			noteB5.setImage(imgBlank);
			noteb5.setImage(imgBlank);
		} else if (musicNoteList.get(i).equals("0001")) {
			notea5.setImage(imgBlank);
			noteA5.setImage(imgBlank);
			noteB5.setImage(imgBlank);
			noteb5.setImage(imgBlack);
			
			D = 1;
		} else if (musicNoteList.get(i).equals("0010")) {
			notea5.setImage(imgBlank);
			noteA5.setImage(imgBlank);
			noteB5.setImage(imgBlack);
			noteb5.setImage(imgBlank);
			
			C = 1;
		} else if (musicNoteList.get(i).equals("0011")) {
			notea5.setImage(imgBlank);
			noteA5.setImage(imgBlank);
			noteB5.setImage(imgBlack);
			noteb5.setImage(imgBlack);
			
			C = 1;
			D = 1;
		} else if (musicNoteList.get(i).equals("0100")) {
			notea5.setImage(imgBlank);
			noteA5.setImage(imgBlack);
			noteB5.setImage(imgBlank);
			noteb5.setImage(imgBlank);
			
			B = 1;
		} else if (musicNoteList.get(i).equals("0101")) {
			notea5.setImage(imgBlank);
			noteA5.setImage(imgBlack);
			noteB5.setImage(imgBlank);
			noteb5.setImage(imgBlack);
			
			B = 1;
			D = 1;
		} else if (musicNoteList.get(i).equals("0110")) {
			notea5.setImage(imgBlank);
			noteA5.setImage(imgBlack);
			noteB5.setImage(imgBlack);
			noteb5.setImage(imgBlank);
			
			B = 1;
			C = 1;
		} else if (musicNoteList.get(i).equals("0111")) {
			notea5.setImage(imgBlank);
			noteA5.setImage(imgBlack);
			noteB5.setImage(imgBlack);
			noteb5.setImage(imgBlack);
			
			B = 1;
			C = 1;
			D = 1;
		} else if (musicNoteList.get(i).equals("1000")) {
			notea5.setImage(imgBlack);
			noteA5.setImage(imgBlank);
			noteB5.setImage(imgBlank);
			noteb5.setImage(imgBlank);
			
			A = 1;
		} else if (musicNoteList.get(i).equals("1001")) {
			notea5.setImage(imgBlack);
			noteA5.setImage(imgBlank);
			noteB5.setImage(imgBlank);
			noteb5.setImage(imgBlack);
			
			A = 1;
			D = 1;
		} else if (musicNoteList.get(i).equals("1010")) {
			notea5.setImage(imgBlack);
			noteA5.setImage(imgBlank);
			noteB5.setImage(imgBlack);
			noteb5.setImage(imgBlank);
			
			A = 1;
			C = 1;
		} else if (musicNoteList.get(i).equals("1011")) {
			notea5.setImage(imgBlack);
			noteA5.setImage(imgBlank);
			noteB5.setImage(imgBlack);
			noteb5.setImage(imgBlack);
			
			A = 1;
			C = 1;
			D = 1;
		} else if (musicNoteList.get(i).equals("1100")) {
			notea5.setImage(imgBlack);
			noteA5.setImage(imgBlack);
			noteB5.setImage(imgBlank);
			noteb5.setImage(imgBlank);
			
			A = 1;
			B = 1;
		} else if (musicNoteList.get(i).equals("1101")) {
			notea5.setImage(imgBlack);
			noteA5.setImage(imgBlack);
			noteB5.setImage(imgBlank);
			noteb5.setImage(imgBlack);
			
			A = 1;
			B = 1;
			D = 1;
		} else if (musicNoteList.get(i).equals("1110")) {
			notea5.setImage(imgBlack);
			noteA5.setImage(imgBlack);
			noteB5.setImage(imgBlack);
			noteb5.setImage(imgBlank);
			
			A = 1;
			B = 1;
			C = 1;
		} else if (musicNoteList.get(i).equals("1111")) {
			notea5.setImage(imgBlack);
			noteA5.setImage(imgBlack);
			noteB5.setImage(imgBlack);
			noteb5.setImage(imgBlack);
			
			A = 1;
			B = 1;
			C = 1;
			D = 1;
		}
	}

	public void exit() {
		life = 1;
		hurt();
	}

	public void showResultWindow() {
		exit = true;
		if (clear == true) {
			try {
				Parent login = FXMLLoader.load(getClass().getResource("/music/GameClear.fxml"));
				Scene scene = new Scene(login);
				Stage primaryStage = (Stage) btn.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			gameOver();
		}
	}

}