package tickTacToe;

import javafx.fxml.FXML;
import login.Login;

public class ai extends Login{
	@FXML
	public void initialize() {
		hungry+=10;
		sick+=10;
		
		up();

	}
}
