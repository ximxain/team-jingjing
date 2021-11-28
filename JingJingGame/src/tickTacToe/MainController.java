package tickTacToe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class MainController {
	@FXML
	private Canvas board1;
	@FXML
	private Canvas board2;
	@FXML
	private Canvas board3;
	@FXML
	private Canvas board4;
	@FXML
	private Canvas board5;
	@FXML
	private Canvas board6;
	@FXML
	private Canvas board7;
	@FXML
	private Canvas board8;
	@FXML
	private Canvas board9;

	GraphicsContext gc1;
	GraphicsContext gc2;
	GraphicsContext gc3;
	GraphicsContext gc4;
	GraphicsContext gc5;
	GraphicsContext gc6;
	GraphicsContext gc7;
	GraphicsContext gc8;
	GraphicsContext gc9;
	Integer[] tictactoe = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	Integer a = 1;
	
	String win = "";

	@FXML
	public void initialize() {

		gc1 = board1.getGraphicsContext2D();
		gc2 = board2.getGraphicsContext2D();
		gc3 = board3.getGraphicsContext2D();
		gc4 = board4.getGraphicsContext2D();
		gc5 = board5.getGraphicsContext2D();
		gc6 = board6.getGraphicsContext2D();
		gc7 = board7.getGraphicsContext2D();
		gc8 = board8.getGraphicsContext2D();
		gc9 = board9.getGraphicsContext2D();


	}

	public void clickone() {
		boolean res = check(1,1);
		if (res == true) {
			drawone(1);
			try {
				auto();
				System.out.println(1);
			}catch(Exception E) {
				
			}
		}
	}

	public void clicktwo() {
		boolean res = check(2,1);
		if (res == true) {
			drawtwo(1);
			try {
				auto();
			}catch(Exception E) {
				
			}
		}
	}

	public void clickthree() {
		boolean res = check(3,1);
		if (res == true) {
			drawthree(1);
			try {
				auto();
			}catch(Exception E) {
				
			}
		}
	}

	public void clickfour() {
		boolean res = check(4,1);
		if (res == true) {
			drawfour(1);
			try {
				auto();
			}catch(Exception E) {
				
			}
		}
	}

	public void clickfive() {
		boolean res = check(5,1);
		if (res == true) {
			drawfive(1);
			try {
				auto();
			}catch(Exception E) {
				
			}
		}
	}

	public void clicksix() {
		boolean res = check(6,1);
		if (res == true) {
			drawsix(1);
			try {
				auto();
			}catch(Exception E) {
				
			}
		}
	}

	public void clickseven() {
		boolean res = check(7,1);
		if (res == true) {
			drawseven(1);
			try {
				auto();
			}catch(Exception E) {
				
			}
		}
	}

	public void clickeight() {
		boolean res = check(8,1);
		if (res == true) {
			draweight(1);
			try {
				auto();
			}catch(Exception E) {
				
			}
		}
	}

	public void clicknine() {
		boolean res = check(9,1);
		if (res == true) {
			drawnine(1);
			try {
				auto();
			}catch(Exception E) {
				
			}
		}
	}

	public void drawone(Integer num) {
		if (num % 2 != 0) {
			gc1.strokeOval(10, 10, 180, 180);
		} else {
			gc1.strokeRect(10, 10, 180, 180);
		}
	}

	public void drawtwo(Integer num) {
		if (num % 2 != 0) {
			gc2.strokeOval(10, 10, 180, 180);
		} else {
			gc2.strokeRect(10, 10, 180, 180);
		}
	}

	public void drawthree(Integer num) {
		if (num % 2 != 0) {
			gc3.strokeOval(10, 10, 180, 180);
		} else {
			gc3.strokeRect(10, 10, 180, 180);
		}
	}

	public void drawfour(Integer num) {
		if (num % 2 != 0) {
			gc4.strokeOval(10, 10, 180, 180);
		} else {
			gc4.strokeRect(10, 10, 180, 180);
		}
	}

	public void drawfive(Integer num) {
		if (num % 2 != 0) {
			gc5.strokeOval(10, 10, 180, 180);
		} else {
			gc5.strokeRect(10, 10, 180, 180);
		}
	}

	public void drawsix(Integer num) {
		if (num % 2 != 0) {
			gc6.strokeOval(10, 10, 180, 180);
		} else {
			gc6.strokeRect(10, 10, 180, 180);
		}
	}

	public void drawseven(Integer num) {
		if (num % 2 != 0) {
			gc7.strokeOval(10, 10, 180, 180);
		} else {
			gc7.strokeRect(10, 10, 180, 180);
		}
	}

	public void draweight(Integer num) {
		if (num % 2 != 0) {
			gc8.strokeOval(10, 10, 180, 180);
		} else {
			gc8.strokeRect(10, 10, 180, 180);
		}
	}

	public void drawnine(Integer num) {
		if (num % 2 != 0) {
			gc9.strokeOval(10, 10, 180, 180);
		} else {
			gc9.strokeRect(10, 10, 180, 180);
		}
	}

	public void clear() {
		gc1.clearRect(0, 0, board1.getWidth(), board1.getHeight());
		gc2.clearRect(0, 0, board2.getWidth(), board2.getHeight());
		gc3.clearRect(0, 0, board3.getWidth(), board3.getHeight());
		gc4.clearRect(0, 0, board4.getWidth(), board4.getHeight());
		gc5.clearRect(0, 0, board5.getWidth(), board5.getHeight());
		gc6.clearRect(0, 0, board6.getWidth(), board6.getHeight());
		gc7.clearRect(0, 0, board7.getWidth(), board7.getHeight());
		gc8.clearRect(0, 0, board8.getWidth(), board8.getHeight());
	}

	public boolean check(Integer num, Integer human) {
		checker();
		if (tictactoe[num - 1] == 0 && human ==1) {
			tictactoe[num - 1] = 1;
			return true;
		}else if(tictactoe[num - 1] == 0 && human ==2){
			tictactoe[num - 1] = 2;
			return true;
		}else {
			return false;
		}
		
	}

	public int sum = 0;
	public boolean res = false;
	Integer rand = 0;
	public void rands() {
		res = true;
		Random rd = new Random();
		rand = rd.nextInt(8)+1;
		res = check(rand,2);
	}
	
	public void auto() {
		int counts = 0;
		System.out.println(res);
		while(res == false) {
			rands();
			counts+=1;
			if(counts>=9) {
				checker();
				res = true;
			}
			
		}
		
		try {
			switch (rand) {
			case 1:
				if (res == true) {
					drawone(2);
					res = false;
					
				} 

				break;
			case 2:
				if (res == true) {
					drawtwo(2);
					res = false;
				} 
				break;
			case 3:
				if (res == true) {
					drawthree(2);
					res = false;
				} 
				break;
			case 4:
				if (res == true) {
					drawfour(2);
					res = false;
				} 
				break;
			case 5:
				if (res == true) {
					drawfive(2);
					res = false;
				} 
				break;
			case 6:
				if (res == true) {
					drawsix(2);
					res = false;
				} 
				break;
			case 7:
				if (res == true) {
					drawseven(2);
					res = false;
				} 
				break;
			case 8:
				if (res == true) {
					draweight(2);
					res = false;
				} 
				break;
			case 9:
				if (res == true) {
					drawnine(2);
					res = false;
				} 
				break;
			}
		}catch(Exception E) {
			throw E;
		}
	}
	
	public void checker() {
		if(tictactoe[0] == 1 && tictactoe[1] == 1 && tictactoe[2] ==1 ) {
			win = "human";
		}else if(tictactoe[0] == 1 && tictactoe[3] == 1 && tictactoe[6] == 1) {
			win = "human";
		}else if(tictactoe[3] == 1 && tictactoe[4] == 1 && tictactoe[5] ==1 ) {
			win = "human";
		}else if(tictactoe[6] == 1 && tictactoe[7] == 1 && tictactoe[8] ==1 ) {
			win = "human";
		}else if(tictactoe[1] == 1 && tictactoe[4] == 1 && tictactoe[7] ==1 ) {
			win = "human";
		}else if(tictactoe[2] == 1 && tictactoe[4] == 1 && tictactoe[7] ==1 ) {
			win = "human";
		}else if(tictactoe[2] == 1 && tictactoe[4] == 1 && tictactoe[6] ==1 ) {
			win = "human";
		}else if(tictactoe[0] == 2 && tictactoe[1] == 2 && tictactoe[2] == 2 ) {//
			win = "AI";
		}else if(tictactoe[0] == 2 && tictactoe[3] == 2 && tictactoe[6] == 2) {
			win = "AI";
		}else if(tictactoe[3] == 2 && tictactoe[4] == 2 && tictactoe[5] ==2 ) {
			win = "AI";
		}else if(tictactoe[6] == 2 && tictactoe[7] == 2 && tictactoe[8] ==2 ) {
			win = "AI";
		}else if(tictactoe[1] == 2 && tictactoe[4] == 2 && tictactoe[7] == 2 ) {
			win = "AI";
		}else if(tictactoe[2] == 2 && tictactoe[4] == 2 && tictactoe[7] == 2 ) {
			win = "AI";
		}else if(tictactoe[2] == 2 && tictactoe[4] == 2 && tictactoe[6] == 2 ) {
			win = "AI";
		}else if(tictactoe[0] != 0 && tictactoe[1] != 0 && tictactoe[2] != 0 && tictactoe[3] != 0 && tictactoe[4] != 0 && tictactoe[5] != 0 && tictactoe[6] != 0 && tictactoe[7] != 0 && tictactoe[8] != 0) {
			win = "NO";
		}
		
		if(win == "human") {
			popup();
			System.out.println("human");
		}else if(win == "AI"){
			popup2();
			System.out.println("AI");
		}else if(win == "NO"){
			popup3();
			System.out.println("NO");
			
			
		}
		
	}
	
	private Stage pop;

	public void popup() {
		// ���� �������� ���, ���� �ΰ��� ��� �� �ι�° ���
		Stage mainStage = (Stage) board1.getScene().getWindow();
		
		// ���ο� �������� ���� (�ɼ� �߰�, ��Ÿ��)
		pop = new Stage(StageStyle.DECORATED); // �������� �ɼ�
		pop.initModality(Modality.WINDOW_MODAL); // �� ���� �ߴ� ����� �ɼ�
		pop.initOwner(mainStage); // ���� �������� �ο�

		try {
			// ���ο� ���������� custom ���̾ƿ� �ҷ�����
			Parent root = FXMLLoader.load(getClass().getResource("/tickTacToe/Win.fxml"));

			// ���� �߰�
			Scene sc = new Scene(root);
			// ���� ��Ÿ�� �߰�
			sc.getStylesheets().add(getClass().getResource("/tickTacToe/application.css").toExternalForm());
			pop.setScene(sc);
			pop.setTitle("");
			pop.setResizable(false); // â ������ ���� ����

			// �����ֱ�
			pop.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void popup2() {
		// ���� �������� ���, ���� �ΰ��� ��� �� �ι�° ���
		Stage mainStage = (Stage) board1.getScene().getWindow();
		
		// ���ο� �������� ���� (�ɼ� �߰�, ��Ÿ��)
		pop = new Stage(StageStyle.DECORATED); // �������� �ɼ�
		pop.initModality(Modality.WINDOW_MODAL); // �� ���� �ߴ� ����� �ɼ�
		pop.initOwner(mainStage); // ���� �������� �ο�

		try {
			// ���ο� ���������� custom ���̾ƿ� �ҷ�����
			Parent root = FXMLLoader.load(getClass().getResource("/tickTacToe/Win2.fxml"));

			// ���� �߰�
			Scene sc = new Scene(root);
			// ���� ��Ÿ�� �߰�
			sc.getStylesheets().add(getClass().getResource("/tickTacToe/application.css").toExternalForm());
			pop.setScene(sc);
			pop.setTitle("");
			pop.setResizable(false); // â ������ ���� ����

			// �����ֱ�
			pop.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void popup3() {
		// ���� �������� ���, ���� �ΰ��� ��� �� �ι�° ���
		Stage mainStage = (Stage) board1.getScene().getWindow();
		
		// ���ο� �������� ���� (�ɼ� �߰�, ��Ÿ��)
		pop = new Stage(StageStyle.DECORATED); // �������� �ɼ�
		pop.initModality(Modality.WINDOW_MODAL); // �� ���� �ߴ� ����� �ɼ�
		pop.initOwner(mainStage); // ���� �������� �ο�

		try {
			// ���ο� ���������� custom ���̾ƿ� �ҷ�����
			Parent root = FXMLLoader.load(getClass().getResource("/tickTacToe/Win3.fxml"));

			// ���� �߰�
			Scene sc = new Scene(root);
			// ���� ��Ÿ�� �߰�
			sc.getStylesheets().add(getClass().getResource("/tickTacToe/application.css").toExternalForm());
			pop.setScene(sc);
			pop.setTitle("");
			pop.setResizable(false); 

			
			pop.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
