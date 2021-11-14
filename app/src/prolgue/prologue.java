package prolgue;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class prologue {

	@FXML
	Label textBuffer;
	static int a = 0;

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
		

		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = text.length(); i > -1; i--) {
					String text2 = "";
					text2 = text.substring(0, text.length() - i);
					System.out.println(text2);
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();

					}
					textBuffer.setText(text2);
				}
			}
		});
		t.start();
	}

}
