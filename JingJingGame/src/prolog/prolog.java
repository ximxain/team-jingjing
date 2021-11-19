package prolog;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.animation.Transition;
import javafx.util.Duration;

public class prolog implements Initializable{
	@FXML
	Label textBuffer;
	@FXML
	ImageView prologBackground;

	static boolean readingCheck = true;
	static int a = 0;
	static int b = 0;
	static String[] textArr = {
			"밤바닷가에 홀로 몇시간이고 앉아 낚시를 하고 있으면,",
			"던져놓은 찌만을 멍하게 바라보고 있다가 문득 한숨을 내쉬면",
			"갑자기 서글픈 인간의 자기성철 같은 것이 별과 함께 떠오른다",
			"'하아, 나는 40대가 다 되어가는데 결혼은 커녕\n여자친구 한번 사귀어 본 적 없구나",
			"내 주변 친구들은 이미 다 결혼해서 아이를 가진 녀석도 있어",
			"이제부터는 더 기회가 없을거야 \n...기회가 적었던 없었던 여태것보다도 더 말이야'",
			"바람이 추워졌다. 남자는 밤낚시를 계속할까 고민하다가 돌아가기로 결정했다.",
			"낚싯대를 치울려고 마구 릴을 감았다. 뭔가가 걸려있다는걸 눈치채고 끌어 올려보니",
			"징징이었다. 외계에서 온듯한 징징이가 찌에 걸려 몸을 축 늘어트리고 있었다.",
			"사내는 징징이를 잠시 지긋이 바라보고는 소리쳤다.",
			"\"내가 정말로 미쳤군. 오징어 따위에게 연민을 느끼다니!\"",
			"사내는 징징이를 품에 넣었다가 곧 숨 쉬기가 불편할거라고 깨닿고는",
			"통에 들은 생선을 버리고 그 안에 징징이를 물 조금과 함께 넣었다.",
			"집으로 달려가면서도 통이 흔들리지 않게 조심하는 것을 잊지 않았다."};

	// true는 화면이 넘어감. false는 넘어가지 않고 화면이 정체되어 있음. 첫 배열은 무조건 true로.
	// textArr 배열과 booleanArr 배열의 크기가 서로 같아야함
	static boolean[] booleanArr = {
			true, false, false, false, false,
			false, false, false, true, false,
			false, false, false, true};

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
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	next();
	}

}
