package hideGame;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import util.AppUtil;
import util.JDBCUtil;

public class level1 implements Initializable {
	@FXML
	private ImageView imageview;
	@FXML
	private Label timerLabel;
	private Timer timer = null;
	private TimerTask timerTask = null;
	int level = 0;
	private int count = 20;
	//int second = 0;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		timer();
		ArrayList<int[]> rectLists = new ArrayList<int[]>();

		rectLists.add(new int[] { 765, 230, 120, 120 });
		rectLists.add(new int[] { 185, 395, 120, 120 });
		rectLists.add(new int[] { 1020, 530, 120, 120 });
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

							alert.setContentText("Level " + Integer.toString(level + 1) + " 오 ~"
									+ Integer.toString(3 - rectLists.size()) + "/3)");

							alert.showAndWait();

							if (rectLists.size() == 0) {
//								try {
//									Parent login = FXMLLoader.load(getClass().getResource("level1.fxml"));
//									Scene scene = new Scene(login);
//									Stage primaryStage = (Stage) imageview.getScene().getWindow();
//									primaryStage.setScene(scene);
//									scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
//								} catch (Exception e1) {
//									e1.printStackTrace();
//								}
								Alert finishAlert = new Alert(AlertType.INFORMATION);

								finishAlert.setContentText("이걸 다찾네 ㅋㅋㄹㅃㅃ");

								finishAlert.showAndWait();
								
								//�� ã���� ������ �ڵ�
								try {
									Parent login = FXMLLoader.load(getClass().getResource("/hideGame/main.fxml"));
									Scene scene = new Scene(login);
									Stage primaryStage = (Stage) imageview.getScene().getWindow();
									primaryStage.setScene(scene);
								} catch (Exception E) {
									
								}
								
								
							}
						}

						return;
					}
				}

			}

		});
	}
	
	public void timer() {
		timer = new Timer();
		timerTask = new TimerTask() {
			@Override
			public void run() {
				count--;
				System.out.println("타이머 : " + count); // �ܼ� ��� �׽�Ʈ
				//second = 15 - count;
				
				// label에 출력
				Platform.runLater(() -> timerLabel.setText("남은 시간 : " + (Integer.toString(count))));
				
				if (count == 0) {
					timer.cancel();
					give();
				}
			}
		};
		timer.schedule(timerTask, 1000l, 1000l);
	}
	
	public void lose() {
		presentExperience += sickAndHungry(200);
		Random rd = new Random();

		if (rd.nextInt(10) < 10 && hungry == 0) {

			// 30%에 걸리면 호출
			hungry = 1;
			AppUtil.alert("징징이가 배고파졌습니다! 상점에서 해결할 수 있습니다.", "");
		}
		if (rd.nextInt(10) < 10 && sick == 0) {

			// 30%에 걸리면 호출
			sick = 1;
			AppUtil.alert("징징이가 병에 들었습니다! 상점에서 해결할 수 있습니다.", "");
		}
	}
	

	public void money() {
		presentExperience += sickAndHungry(200); // 성장게이지 상승

		Random rd = new Random();

		if (rd.nextInt(10) < 3 && hungry == 0) {

			// 30%에 걸리면 호출
			hungry = 1;
			AppUtil.alert("징징이가 배고파졌습니다! 상점에서 해결할 수 있습니다.", "");
		}

		money += 2; // 소지금 지급
		up();

		System.out.println("코인 2개 지급");
		JDBCUtil db = new JDBCUtil();
		Connection con = db.getConnection();

		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM `jingjing_users` WHERE userId = " + "'" + user + "'";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Integer money = rs.getInt("money");
				money = money + 2;
			}

		} catch (Exception E) {

		}

	public void give() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Parent login = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));
					Scene scene = new Scene(login);
					Stage primaryStage = (Stage) imageview.getScene().getWindow();
					primaryStage.setScene(scene);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}

}
