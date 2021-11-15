package appScene;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CrickApp {
	

	public void endPop() {
		mainStage = (Stage) app.getScene().getWindow();
		pop = new Stage(StageStyle.DECORATED);
		pop.initModality(Modality.WINDOW_MODAL);
		pop.initOwner(mainStage);

		try {
			// ���ο� ���������� custom ���̾ƿ� �ҷ�����
			Parent root = FXMLLoader.load(getClass().getResource("/mainApplication/Pop.fxml"));

			// ���� �߰�
			Scene sc = new Scene(root);
			// ���� ��Ÿ�� �߰�
			sc.getStylesheets().add(getClass().getResource("/app/application.css").toExternalForm());
			pop.setScene(sc);
			pop.setTitle("�˾� ����");
			pop.setResizable(false); // â ������ ���� ����

			// �����ֱ�
			pop.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void prologue() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/prolgue/prologue.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) app.getScene().getWindow(); // �쁽�옱 �쐢�룄�슦 媛��졇�삤湲�
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
