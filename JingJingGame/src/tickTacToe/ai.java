package tickTacToe;

import javafx.fxml.FXML;
import login.Login;

public class ai extends Login{
	@FXML
	public void initialize() {
		hungry=1;
		up();
		util.AppUtil.alert("징징이가 배고파졌습니다!", "징징이가 배고픔");

	}
}
