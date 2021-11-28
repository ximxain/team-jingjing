package cardgame;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import login.Login;

public class EndTwo extends Login{
	private Button end;
	private Button oneMore;
	
	@FXML
	public void start() {
		sick = 1;
		hungry = 1;
		up();
	}
	
	public void clickEnds() {
		Stage stage = (Stage) end.getScene().getWindow(); // 팝업창 닫기
		stage.close();
		


	}
	
	public void clickOneMore() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/cardgame/layout.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) oneMore.getScene().getWindow();
			primaryStage.setScene(scene);
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
