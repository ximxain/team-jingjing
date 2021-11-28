package Painting;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;

public class Main extends Application {
	int level = 0;
	Label image;

	ArrayList<int[]> rectLists;

	Stage primaryState;
	Stage gameStage;

	Label levelLabel;

	public void gameWindow(int level) {
		this.level = level;
		gameStage = new Stage();

		gameStage.setWidth(1920);
		gameStage.setHeight(1080);
		ArrayList<int[]> rectLists = new ArrayList<int[]>();

		if (level == 0) {
			rectLists.add(new int[] { 765, 230, 120, 120 });
			rectLists.add(new int[] { 185, 395, 120, 120 });
			rectLists.add(new int[] { 1020, 530, 120, 120 });
		} else if (level == 1) {
			rectLists.add(new int[] { 35, 575, 120, 120 });
			rectLists.add(new int[] { 590, 530, 120, 120 });
			rectLists.add(new int[] { 975, 300, 120, 120 });
		} else {
			rectLists.add(new int[] { 20, 340, 120, 120 });
			rectLists.add(new int[] { 765, 215, 120, 120 });
			rectLists.add(new int[] { 930, 370, 120, 120 });
		}

		BorderPane root = new BorderPane();

		levelLabel = new Label("Level " + Integer.toString(level + 1));
		root.setTop(levelLabel);

		image = new Label("",
				new ImageView(new Image(getClass().getResourceAsStream(Integer.toString(level + 1) + ".png"))));

		image.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				for (int i = 0; i < 3; i++) {
					int[] xywh = rectLists.get(i);

					int x = xywh[0];
					int y = xywh[1];
					int width = xywh[2];
					int height = xywh[3];

					if (x < me.getX() && x + width > me.getX()) {
						if (y < me.getY() && y + height > me.getY()) {
							rectLists.remove(i);

							Alert alert = new Alert(AlertType.INFORMATION);

							alert.setContentText("Level " + Integer.toString(level + 1) + " 클리어 ("
									+ Integer.toString(3 - rectLists.size()) + "/3)");

							alert.showAndWait();

							if (rectLists.size() == 0) {
								Alert finishAlert = new Alert(AlertType.INFORMATION);

								finishAlert.setContentText("게임 클리어 ㅋㅋㄹㅃㅃ");

								finishAlert.showAndWait();

								gameStage.close();
							}

							levelLabel.setText(Integer.toString(level + 1));
						}

						return;
					}
				}
			}
		});

		root.setCenter(image);

		Scene scene = new Scene(root, 400, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		gameStage.setScene(scene);
		gameStage.show();
	}

	@Override
	public void start(Stage primaryStage) {
		FlowPane root = new FlowPane();
		Scene scene = new Scene(root, 400, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		primaryStage.setScene(scene);
		primaryStage.show();

		Button btn1 = new Button("Level 1");
		btn1.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				gameWindow(0);
			}
		});

		Button btn2 = new Button("Level 2");
		btn2.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				gameWindow(1);
			}
		});

		Button btn3 = new Button("Level 3");
		btn3.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				gameWindow(2);
			}
		});

		root.getChildren().add(btn1);
		root.getChildren().add(btn2);
		root.getChildren().add(btn3);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
