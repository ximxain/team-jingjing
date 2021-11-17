package prolog;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.animation.Animation;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	static String[] textArr = { "하츠네 미쿠 공부법으로 허접 코딩 탈출하자!", "잃어버린 고향을 찾기 위해서 인간은 타향으로 가야 한다",
			"내 돈이 불쌍한 자들의 관을 짜는데 쓰이길 바란다", "그 마녀의 이름은 무엇일까요?" };
	
	//true는 화면이 넘어감. false는 넘어가지 않고 화면이 정체되어 있음. 첫 배열은 무조건 true로.
	static boolean[] arr = {true, false, true, true};
	
	public void start() {

	}

	public void next() {
		if (readingCheck == true) {
			text(textArr[a]);
			if (arr[a] == true) {
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
