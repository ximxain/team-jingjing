package tickTacToe;

import javafx.fxml.FXML;
import login.Login;

public class human extends Login{
	@FXML
	public void initialize() {
		presentExperience+=10;
		money+=10;
		up();

	}
}
