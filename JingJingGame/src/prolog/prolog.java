package prolog;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.animation.Animation;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.animation.Transition;
import javafx.util.Duration;

public class prolog {
	@FXML
	Label textBuffer;
	@FXML
	ImageView prologBackground;

	static boolean readingCheck = true;
	static int a = 0;
	static int b = 0;
	static String[] textArr = { "하...", "나는 일만 하다 살아와서 40대가 다 되어도 결혼은 커녕 여친 한번 사귀어 본 적 없구나",
			"내 주변 ", "'나는 일만 하다가 살아와서 40대가 되어가는데 결혼은 커녕 여자친구를 사귀어 본 적도 없지",
			"", "나는 잠이 올 수 밖에", "별 하나에 아름다운 말 한마디씩 불러 봅니다" };

	// true는 화면이 넘어감. false는 넘어가지 않고 화면이 정체되어 있음. 첫 배열은 무조건 true로.
	// textArr 배열과 booleanArr 배열의 크기가 서로 같아야함
	static boolean[] booleanArr = { true, false, true, true, false, false };

	public void start() {

	}

	public void next() {
		if (a < textArr.length) {
			if (readingCheck == true) {
				text(textArr[a]);
				if (booleanArr[a] == true) {
					b++;
					String path = "src//resource/prolog" + b + ".png";

					try {
						FileInputStream fis = new FileInputStream(path);
						BufferedInputStream bis = new BufferedInputStream(fis);
						Image img = new Image(bis);
						prologBackground.setImage(img);
						try {
							bis.close();
							fis.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				a++;
			}
		} else {
			System.out.println("end");
			// 임시
			try {
				Parent login = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));
				Scene scene = new Scene(login);
				Stage primaryStage = (Stage) textBuffer.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void text(String text) {
		readingCheck = false;
		final Animation animation = new Transition() {
			{
				setCycleDuration(Duration.millis(2000));
			}

			protected void interpolate(double frac) {
				final int length = text.length();
				final int n = Math.round(length * (float) frac);
				textBuffer.setText(text.substring(0, n));
				if (n == text.length()) {
					readingCheck = true;
				}
			}
		};

		animation.play();

	}

}
