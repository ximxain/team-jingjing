package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			
//			loader.setLocation(getClass().getResource("/Login/login.fxml"));
			loader.setLocation(getClass().getResource("/login/FirstScreen.fxml"));
//			loader.setLocation(getClass().getResource("/event/Event2.fxml"));
			primaryStage.setResizable(false);
			AnchorPane AP = (AnchorPane)loader.load();
			Scene scene = new Scene(AP);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}