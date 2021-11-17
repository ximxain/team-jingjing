package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ItemController {
	@FXML
	private Button closeBtn;
	
	private Stage pop;
	
	public void close() {
		pop = (Stage) closeBtn.getScene().getWindow();
		pop.close();
	}
}
