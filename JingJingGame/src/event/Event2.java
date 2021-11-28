package event;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import login.Login;
import util.JDBCUtil;

public class Event2 extends Login implements Initializable{
	@FXML
	Label textBuffer;
	@FXML
	ImageView prologBackground;

	private JDBCUtil db;
	static int a = 0;
	static int b = 0;
	static String[] textArr = { "저는 당신의 미래에서 온 연인이에요!", "집게리아에서 식사를 하고 있는 뚱이에게 징징이가 말했다.",
			"뭐요? 그럼 저의 모든 것을 아시겠죠?", "어... 어...? 네...! 그럼요! 당연하죠!",
			"그럼 저에 대한 퀴즈를 낼테니, 맞추어보세요!", "알겠어요!(내가 할 수 있겠지?)"};

	// true는 화면이 넘어감. false는 넘어가지 않고 화면이 정체되어 있음. 첫 배열은 무조건 true로.
	// textArr 배열과 booleanArr 배열의 크기가 서로 같아야함
	static boolean[] booleanArr = {
			true, false, false, false, false,
			false};

	public void start() {

	}

	public void next() {
		if (a < textArr.length) {
				text(textArr[a]);
				a++;
		} else {
			System.out.println("event2 end");
			// 임시
			
			
			
			try {
				Parent login = FXMLLoader.load(getClass().getResource("/event/Quiz.fxml"));
				Scene scene = new Scene(login);
				Stage primaryStage = (Stage) textBuffer.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void text(String text) {
		final Animation animation = new Transition() {
			{
				setCycleDuration(Duration.millis(2000));
			}

			protected void interpolate(double frac) {
				final int length = text.length();
				final int n = Math.round(length * (float) frac);
				textBuffer.setText(text.substring(0, n));
			}
		};

		animation.play();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		next();
	}


}
