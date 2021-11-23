package appScene;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import music.MainController;

public class MusicPop extends GameController {

	public Stage pop3;
	public Stage pop2;
	public static Scene sc;
	static public String modChoice = "easy";
	public String musicName;

	

	@FXML
	ImageView music1;
	@FXML
	ImageView music2;
	@FXML
	ImageView music3;
	@FXML
	ImageView music4;

	

	@FXML
	Button closebtn2;

	

	

}
