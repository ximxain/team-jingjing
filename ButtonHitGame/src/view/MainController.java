package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainController {
	int click = 0; // 버튼클릭 횟수
	int SuccessClick = 100; // 버튼클릭 성공횟수

	@FXML
	private Button ClickBtn;

	@FXML
	private Button Start;

	// 화면이동
	public void changeMainView() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) Start.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	// 타이머(30초)
	// 배경음악
	// 버튼 누름과 안누름에 따라 이미지뷰 변화
	
	
	//버튼클릭 횟수
	public void IfClickBtn() {
		click += 1;
		System.out.println(click);
		if(click == SuccessClick) {
			try {
				Parent login = FXMLLoader.load(getClass().getResource("/view/Success.fxml"));
				Scene scene = new Scene(login);
				Stage primaryStage = (Stage) ClickBtn.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}