package task;

import java.util.Random;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



public class teacherTurn extends Thread{
	
	@FXML
	private ImageView teacher;
	
	
	@Override
	public void run() {
		while(true) {
			Random rd = new Random();
			int random = rd.nextInt(3);
			if (random == 0) {
				System.out.println(1);
				try {
					Thread.sleep(3000);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else if (random == 1) {
				System.out.println(2);
				try {
					
					Thread.sleep(5000);				
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else if (random == 2) {
				System.out.println(3);
				try {
					Thread.sleep(7000);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			Platform.runLater(new Runnable(){
				@Override
				public void run() {
					teacher.setImage(new Image("/image/teacher2.png"));
				}
			});
		}
	}
	
//	public void teacher() {
//		System.out.println("들어옴");
//		teacher.setImage(new Image("/image/teacher2.png"));
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
}
