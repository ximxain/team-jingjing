package item;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class itemController {
	private ListView<String> lists;
	
	@FXML
	public void initialize() {
		lists.add("ssss");
	}
	
	public void get() {
		int idx = lists.getSelectionModel().getSelectedIndex();
	}
}
