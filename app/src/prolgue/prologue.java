package prolgue;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class prologue {

	@FXML
	Label textBuffer;
	static int a = 0;
	static String text2 = "";

	public void start() {

	}

	public void next() {
		text("하츠네 미쿠 공부법으로 허접 코딩 탈출하자!");
	}

	public void pause() {
		try {
			System.in.read();
		} catch (IOException e) {
		}
	}

	public void text(String text) {
		text2 = "";
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				textBuffer.setText(text2);
			}
		});

		for (int i = text.length(); i > -1; i--) {

			text2 = text.substring(0, text.length() - i);
			System.out.println(text2);
			t.start();

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		}
		text2 = "";

	}

}
