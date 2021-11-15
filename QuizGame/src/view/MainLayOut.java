package view;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainLayOut {
	@FXML
	private Label txtPass;
	@FXML
	private Label txtFail;

	public static int score = 0;

	@FXML
	private Button StartQuiz;

	private static String viewName = "Init & Quiz";
	//서술형 답
	private static String Quiz3 = "1";
	private static String Quiz7 = "2";
	private static String Quiz9 = "3";

	// 결과출력
	public void initialize() {
		if (viewName.equals("Score")) {
			txtPass.setText("점수 : " + score + "점");

		} else if (viewName.equals("Score2")) {
			txtFail.setText("점수 : " + score + "점");
		}
	}

	// 퀴즈화면이동
	public void changeStartPage() {
		try {
			System.out.println(score);
			Parent login = FXMLLoader.load(getClass().getResource("/view/Quiz1.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) StartQuiz.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML private Button Quiz1Correct;
	@FXML private Button Quiz1Wrong;

	public void ClickQuiz1Correct() {
		score += 10;
		try {
			System.out.println(score);
			Parent login = FXMLLoader.load(getClass().getResource("/view/Quiz2.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) Quiz1Correct.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ClickQuiz1Wrong() {
		System.out.println(score);
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/view/Quiz2.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) Quiz1Wrong.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML private Button Quiz2Correct;
	@FXML private Button Quiz2Wrong;

	public void ClickQuiz2Correct() {
		score += 10;
		System.out.println(score);
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/view/Quiz3.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) Quiz2Correct.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ClickQuiz2Wrong() {
		System.out.println(score);
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/view/Quiz3.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) Quiz2Wrong.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML private TextField Quiz3Answer;
	@FXML private Button Quiz3Btn;

	public void Quiz3CorrectAnswer() {
		if (Quiz3Answer.getText().equals(Quiz3)) {  //맞으면 +10
			score += 10;
			System.out.println(score);
			try {
				Parent login = FXMLLoader.load(getClass().getResource("/view/Quiz4.fxml"));
				Scene scene = new Scene(login);
				Stage primaryStage = (Stage) Quiz3Btn.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (Quiz3Answer.getText().isEmpty()) {
			AppUtil.alert("답을 입력하세요.", null);
		} else {
			System.out.println(score);
			try {
				Parent login = FXMLLoader.load(getClass().getResource("/view/Quiz4.fxml"));
				Scene scene = new Scene(login);
				Stage primaryStage = (Stage) Quiz3Btn.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@FXML private Button Quiz4Correct;
	@FXML private Button Quiz4Wrong;
	@FXML private Button Quiz4Wrong2;

	public void ClickQuiz4Correct() {
		score += 10;
		System.out.println(score);
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/view/Quiz5.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) Quiz4Correct.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ClickQuiz4Wrong() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/view/Quiz5.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) Quiz4Wrong.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ClickQuiz4Wrong2() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/view/Quiz5.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) Quiz4Wrong2.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML private Button Quiz5Correct;
	@FXML private Button Quiz5Wrong;
	@FXML private Button Quiz5Wrong2;

	public void ClickQuiz5Correct() {
		score += 10;
		System.out.println(score);
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/view/Quiz6.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) Quiz5Correct.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ClickQuiz5Wrong() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/view/Quiz6.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) Quiz5Wrong.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ClickQuiz5Wrong2() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/view/Quiz6.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) Quiz5Wrong2.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML private Button Quiz6Correct;
	@FXML private Button Quiz6Wrong;

	public void ClickQuiz6Correct() {
		score += 10;
		System.out.println(score);
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/view/Quiz7.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) Quiz6Correct.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ClickQuiz6Wrong() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/view/Quiz7.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) Quiz6Wrong.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML private Button Quiz7AnswerBtn;
	@FXML private TextField Quiz7Answer;

	public void Quiz7CorrectAnswer() {
		if (Quiz7Answer.getText().equals(Quiz7)) {  //맞으면 +10
			score += 10;
			System.out.println(score);
			try {
				Parent login = FXMLLoader.load(getClass().getResource("/view/Quiz8.fxml"));
				Scene scene = new Scene(login);
				Stage primaryStage = (Stage) Quiz7AnswerBtn.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (Quiz7Answer.getText().isEmpty()) {
			AppUtil.alert("답을 입력하세요.", null);
		} else {
			System.out.println(score);
			try {
				Parent login = FXMLLoader.load(getClass().getResource("/view/Quiz8.fxml"));
				Scene scene = new Scene(login);
				Stage primaryStage = (Stage) Quiz7AnswerBtn.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@FXML private Button Quiz8Correct;
	@FXML private Button Quiz8Wrong;

	public void ClickQuiz8Correct() {
		score += 10;
		System.out.println(score);
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/view/Quiz9.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) Quiz8Correct.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ClickQuiz8Wrong() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/view/Quiz9.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) Quiz8Wrong.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML private Button Quiz9Btn;
	@FXML private TextField Quiz9Answer;

	public void Quiz9CorrectAnswer() {
		if (Quiz9Answer.getText().equals(Quiz9)) {  //맞으면 +10
			score += 10;
			System.out.println(score);
			try {
				Parent login = FXMLLoader.load(getClass().getResource("/view/Quiz10.fxml"));
				Scene scene = new Scene(login);
				Stage primaryStage = (Stage) Quiz9Btn.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (Quiz9Answer.getText().isEmpty()) {
			AppUtil.alert("답을 입력하세요.", null);
		} else {
			System.out.println(score);
			try {
				Parent login = FXMLLoader.load(getClass().getResource("/view/Quiz10.fxml"));
				Scene scene = new Scene(login);
				Stage primaryStage = (Stage) Quiz9Btn.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@FXML private Button Quiz10Correct;
	@FXML private Button Quiz10Wrong;

	public void ClickQuiz10Correct() {
		viewName = "Score";  //initialize score

		score += 10;
		// 소리넣기
		System.out.println(score);
		if (score > 50) {  //score가 50 초과면 성공
			try {
				Parent login = FXMLLoader.load(getClass().getResource("/view/Pass.fxml"));
				Scene scene = new Scene(login);
				Stage primaryStage = (Stage) Quiz10Correct.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				Parent login = FXMLLoader.load(getClass().getResource("/view/Fail.fxml"));
				Scene scene = new Scene(login);
				Stage primaryStage = (Stage) Quiz10Correct.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void ClickQuiz10Wrong() {
		viewName = "Score2";  //initialize score2

		// 소리넣기
		if (score < 60) {  //score가 60미만이면 실패
			try {
				Parent login = FXMLLoader.load(getClass().getResource("/view/Fail.fxml"));
				Scene scene = new Scene(login);
				Stage primaryStage = (Stage) Quiz10Correct.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				Parent login = FXMLLoader.load(getClass().getResource("/view/Pass.fxml"));
				Scene scene = new Scene(login);
				Stage primaryStage = (Stage) Quiz10Correct.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
