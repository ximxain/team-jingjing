package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ItemController {
	@FXML
	private Button closeBtn;
	
	private Stage pop;
	
	public void close() { // �쁽�옱�쓽 �뒪�뀒�씠吏�瑜� 諛쏆븘�꽌 close瑜� �빐二쇱뼱�빞 �븿
		pop = (Stage) closeBtn.getScene().getWindow(); // 踰꾪듉�쓣 �넻�빐�꽌 �쁽�옱 �뒪�뀒�씠吏�瑜� �븣�븘�깂
		pop.close();
	}
}
