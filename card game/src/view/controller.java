package view;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class controller implements Initializable {
	@FXML
	private ImageView computerCard1;
	@FXML
	private ImageView computerCard2;
	@FXML
	private ImageView computerCard3;

	@FXML
	private ImageView card1;
	@FXML
	private ImageView card2;
	@FXML
	private ImageView card3;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	int num = 0;
	int number = 0;
	int save = 0;

	public void card1_1(MouseEvent e) {
		save = (int) card1.getLayoutY();
		card1.setLayoutY(card1.getLayoutY() - 100);
		num = 1;
		computerCard1_1(card1);
		
	}

	public void card2_1(MouseEvent e) {
		save = (int) card2.getLayoutY();
		card2.setLayoutY(card2.getLayoutY() - 100);
		num = 2;
		computerCard1_1(card2);
	}

	public void card3_1(MouseEvent e) {
		save = (int) card3.getLayoutY();
		card3.setLayoutY(card3.getLayoutY() - 100);
		num = 3;
		computerCard1_1(card3);
	}

	int save2 = 0;

	public void computerCard1_1(ImageView iv) {
		Random rd = new Random();
		int i = rd.nextInt(3);
		if (i == 0) {
			save2 =(int) computerCard1.getLayoutY();
			computerCard1.setLayoutY(computerCard1.getLayoutY() + 100);
			number = 1;
			result(computerCard1, iv);
		} else if (i == 1) {
			save2 =(int) computerCard2.getLayoutY();
			computerCard2.setLayoutY(computerCard1.getLayoutY() + 100);
			number = 2;
			result(computerCard2, iv);
		} else {
			save2 =(int) computerCard3.getLayoutY();
			computerCard3.setLayoutY(computerCard1.getLayoutY() + 100);
			number = 3;
			result(computerCard3, iv);
		}
	}

	public void result(ImageView iv, ImageView iv2) {
		if (num == number) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("승리");
			alert.setContentText("이걸 이기네 국그릇핑크퐁 ㅋ");
			alert.setHeaderText("승리");
			alert.showAndWait();
			iv.setLayoutY(save2);
			iv2.setLayoutY(save);
			reset();
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("패배");
			alert.setContentText("이걸 지네 국그릇핑크퐁 ㅋ");
			alert.setHeaderText("패배");
			alert.showAndWait();
			iv.setLayoutY(save2);
			iv2.setLayoutY(save);
			reset();
		}
	}

	public void reset() {
		num = 0;
		number = 0;
	}

}
