package hideGame;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class level2 implements Initializable {
	@FXML
	private ImageView imageview;
	int level = 0;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ArrayList<int[]> rectLists = new ArrayList<int[]>();

		rectLists.add(new int[] { 35, 575, 120, 120 });
		rectLists.add(new int[] { 590, 530, 120, 120 });
		rectLists.add(new int[] { 975, 300, 120, 120 });
		imageview.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				for (int i = 0; i < 3; i++) {
					int[] xywh = rectLists.get(i);

					int x = xywh[0];
					int y = xywh[1];
					int width = xywh[2];
					int height = xywh[3];

					if (x < e.getX() && x + width > e.getX()) {
						if (y < e.getY() && y + height > e.getY()) {
							rectLists.remove(i);

							Alert alert = new Alert(AlertType.INFORMATION);

							alert.setContentText("Level " + Integer.toString(level + 1) + " Ŭ���� ("
									+ Integer.toString(3 - rectLists.size()) + "/3)");

							alert.showAndWait();

							if (rectLists.size() == 0) {
								Alert finishAlert = new Alert(AlertType.INFORMATION);

								finishAlert.setContentText("���� Ŭ���� ����������");

								finishAlert.showAndWait();

							}
						}

						return;
					}
				}

			}

		});
	}

}
