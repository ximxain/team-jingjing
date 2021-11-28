package item;

import javafx.scene.control.ListView;

public class itemController {
	private ListView<String> lists;
	
	public void get() {
		int idx = lists.getSelectionModel().getSelectedIndex();
	}
}
