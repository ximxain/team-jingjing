package event;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Quiz implements Initializable{

	@FXML
	ImageView correctAnswer;
	@FXML
	Label problem;
	@FXML
	Button btn;
	
	static int step = 0;

	static String[] textArr = {
			"뚱이의 애완동물의 이름은 핑핑이다",
			"뚱이는 왕족의 친척이다.",
			"뚱이는 개불이다.",
			"뚱이는 돌을 좋아한다",
			"뚱이는 먹는 것을 좋아한다" };
	static boolean[] answer = { false, true, false, true, true};
	static int wrongValue = 0;
	
	
	public void O() {
		if(answer[step] == true) {
			wrongValue++;
			String path = "src//resource/answer.png";

			try {
				FileInputStream fis = new FileInputStream(path);
				BufferedInputStream bis = new BufferedInputStream(fis);
				Image img = new Image(bis);

				correctAnswer.setImage(img);
				try {
					bis.close();
					fis.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				Thread t = new Thread(new Runnable() {

					@Override
					public void run() {
						try {
							Thread.sleep(1000);
							correctAnswer.setImage(null);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();

						}
					}
				});
				t.start();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if(answer[step] == false) {
			String path = "src//resource/wrong.png";

			try {
				FileInputStream fis = new FileInputStream(path);
				BufferedInputStream bis = new BufferedInputStream(fis);
				Image img = new Image(bis);

				correctAnswer.setImage(img);
				try {
					bis.close();
					fis.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				Thread t = new Thread(new Runnable() {

					@Override
					public void run() {
						try {
							Thread.sleep(1000);
							correctAnswer.setImage(null);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();

						}
					}
				});
				t.start();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		next();
	}
	
	public void X() {
		if(answer[step] == false) {
			wrongValue++;
			String path = "src//resource/answer.png";

			try {
				FileInputStream fis = new FileInputStream(path);
				BufferedInputStream bis = new BufferedInputStream(fis);
				Image img = new Image(bis);

				correctAnswer.setImage(img);
				try {
					bis.close();
					fis.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				Thread t = new Thread(new Runnable() {

					@Override
					public void run() {
						try {
							Thread.sleep(1000);
							correctAnswer.setImage(null);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();

						}
					}
				});
				t.start();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if(answer[step] == true) {
			String path = "src//resource/wrong.png";

			try {
				FileInputStream fis = new FileInputStream(path);
				BufferedInputStream bis = new BufferedInputStream(fis);
				Image img = new Image(bis);

				correctAnswer.setImage(img);
				try {
					bis.close();
					fis.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				Thread t = new Thread(new Runnable() {

					@Override
					public void run() {
						try {
							Thread.sleep(1000);
							correctAnswer.setImage(null);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();

						}
					}
				});
				t.start();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		next();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		step = 0;
		problem.setText(step+1+". "+textArr[step]);
		
	}
	
	public void next() {
		if(step >= 4) {
			if(wrongValue >= 3) {
				try {
					Parent login = FXMLLoader.load(getClass().getResource("/event/Event2-2.fxml"));
					Scene scene = new Scene(login);
					Stage primaryStage = (Stage) btn.getScene().getWindow();
					primaryStage.setScene(scene);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				try {
					Parent login = FXMLLoader.load(getClass().getResource("/event/Event2-1.fxml"));
					Scene scene = new Scene(login);
					Stage primaryStage = (Stage) btn.getScene().getWindow();
					primaryStage.setScene(scene);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			step++;
			problem.setText(step+1+". "+textArr[step]);
		}
	}
}