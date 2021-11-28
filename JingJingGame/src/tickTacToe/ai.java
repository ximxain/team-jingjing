package tickTacToe;

import javafx.fxml.FXML;
import login.Login;

public class ai extends Login{
	@FXML
	public void initialize() {
		hungry=1;
		up();

	}
}
