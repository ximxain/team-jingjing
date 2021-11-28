package math;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

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
import util.AppUtil;

public class MainApplication extends Stopwatch {
	@FXML
	ImageView backGround;

	@FXML
	Label problem;
	@FXML
	Label input;
	@FXML
	Label question1;
	@FXML
	Label question2;

	@FXML
	Label answer;
	@FXML
	Label step;

	@FXML
	Label resultWindow;

	@FXML
	Button closebtn;
	@FXML
	Label score;

	@FXML
	Button easyMod;
	@FXML
	Button nomalMod;
	@FXML
	Button hardMod;
	@FXML
	Button superHardMod;
	@FXML
	Button start1;
	@FXML
	ImageView correctAnswer;

	static int intOne = 0;
	static int intTwo = 0;
	static int intAnswer = 0;
	static int stepLimit = 10;

	static Stage mainStage;

	Random rd = new Random();

	static int value = 0;
	static String value2 = "0";
	public static int valueAnswer = 0;
	static int valueWrong = 0;

	public void start() {
		valueAnswer = 0;
		problem();
		stopwatch(1);
		resultWindow.setText(null);
	}

	public void problem() {
		if (presentStep >= stepLimit) {

			// 게임 종료
			System.out.println("end");
			System.out.println(valueAnswer);
			System.out.println("정답률: " + (int) ((double) valueAnswer / (double) stepLimit * 100.0) + "%");
			stopwatch(0);
			System.out.format("Timer OFF! 경과 시간: [%s]%n", timerBuffer);
			resultWindow.setText("정답률: " + (int) ((double) valueAnswer / (double) stepLimit * 100.0) + "%"
					+ "\n재시작할려면 계산기의 =키를 누르시오" + "\n걸린시간: " + time + "초");
			presentStep = 0;
			question1.setText("" + 0);
			question2.setText("" + 0);
			answer.setText("" + 3939);

			presentExperience += sickAndHungry(valueAnswer * 20);
			if ((int) ((double) valueAnswer / (double) stepLimit * 100.0) >= 70 && time <= 90) {
				money += 1;
				presentExperience += sickAndHungry(valueAnswer * 10);
			}
			
			if (rd.nextInt(10) < 3 && hungry == 0) {

				// 30%에 걸리면 호출
				hungry = 1;
				AppUtil.alert("징징이가 배고파졌습니다! 배고픔 상태일 때는 30% 점수가 삭감됩니다. 상점에서 해결할 수 있습니다.", "");
			}

			if ((int) ((double) valueAnswer / (double) stepLimit * 100.0) <= 50 && time >= 120) {
				if (rd.nextInt(10) < 8 && sick == 0) {

					// 30%에 걸리면 호출
					sick = 1;
					AppUtil.alert("징징이가 병에 들었습니다! 아픔 상태일 때는 30% 점수가 삭감됩니다. 상점에서 해결할 수 있습니다.", "");
				}
			}

			up();

		} else {
			presentStep++;
			step.setText(presentStep + "/" + stepLimit);
			value = 0;
			value2 = "0";
			input.setText(value2);
			if (modChoice.equals("easy")) {
				intOne = rd.nextInt(18) + 1;
				intTwo = rd.nextInt(18) + 1;
			} else if (modChoice.equals("nomal")) {
				intOne = rd.nextInt(18) + 10;
				intTwo = rd.nextInt(18) + 10;
			} else if (modChoice.equals("hard")) {
				intOne = rd.nextInt(28) + 10;
				intTwo = rd.nextInt(28) + 10;
			} else if (modChoice.equals("super hard")) {
				intOne = rd.nextInt(28) + 20;
				intTwo = rd.nextInt(28) + 20;
			}
			question1.setText("" + intOne);
			question2.setText("" + intTwo);
			intAnswer = intOne * intTwo;
			answer.setText("????");
		}
	}

	public void input0() {
		if (value2.length() > 9) {
			System.out.println("!!!");
		} else {
			if (value2.equals("0")) {
				value2 = null;
				value2 = "0";
			} else {
				value2 = value2 + "0";
			}

		}
		input.setText(value2);

	}

	public void input1() {
		if (value2.length() > 9) {
			System.out.println("!!!");
		} else {
			if (value2.equals("0")) {
				value2 = null;
				value2 = "1";
			} else {
				value2 = value2 + "1";
			}

		}
		input.setText(value2);
//		if(value > 10000) {
//			System.out.println("�삤瑜�! �꼫臾� �겙 �닔!");
//		} else if(value >= 1000) {
//			value = value + 10000;
//		} else if(value >= 100) {
//			value = value + 1000;
//		} else if(value >= 10) {
//			value = value + 100;
//		} else if(value >= 1) {
//			value = value + 10;
//		} else if(value == 0) {
//			value = value + 1;
//		}

	}

	public void input2() {
		if (value2.length() > 9) {
			System.out.println("!!!");
		} else {
			if (value2.equals("0")) {
				value2 = null;
				value2 = "2";
			} else {
				value2 = value2 + "2";
			}

		}
		input.setText(value2);

	}

	public void input3() {
		if (value2.length() > 9) {
			System.out.println("!!!");
		} else {
			if (value2.equals("0")) {
				value2 = null;
				value2 = "3";
			} else {
				value2 = value2 + "3";
			}

		}
		input.setText(value2);

	}

	public void input4() {
		if (value2.length() > 9) {
			System.out.println("!!!");
		} else {
			if (value2.equals("0")) {
				value2 = null;
				value2 = "4";
			} else {
				value2 = value2 + "4";
			}

		}
		input.setText(value2);

	}

	public void input5() {
		if (value2.length() > 9) {
			System.out.println("!!!");
		} else {
			if (value2.equals("0")) {
				value2 = null;
				value2 = "5";
			} else {
				value2 = value2 + "5";
			}

		}
		input.setText(value2);

	}

	public void input6() {
		if (value2.length() > 9) {
			System.out.println("!!!");
		} else {
			if (value2.equals("0")) {
				value2 = null;
				value2 = "6";
			} else {
				value2 = value2 + "6";
			}

		}
		input.setText(value2);

	}

	public void input7() {
		if (value2.length() > 9) {
			System.out.println("!!!");
		} else {
			if (value2.equals("0")) {
				value2 = null;
				value2 = "7";
			} else {
				value2 = value2 + "7";
			}

		}
		input.setText(value2);

	}

	public void input8() {
		if (value2.length() > 9) {
			System.out.println("!!!");
		} else {
			if (value2.equals("0")) {
				value2 = null;
				value2 = "8";
			} else {
				value2 = value2 + "8";
			}

		}
		input.setText(value2);

	}

	public void input9() {
		if (value2.length() > 9) {
			System.out.println("!!!");
		} else {
			if (value2.equals("0")) {
				value2 = null;
				value2 = "9";
			} else {
				value2 = value2 + "9";
			}

		}
		input.setText(value2);

	}

	public void inputAnswer() {
		if (presentStep == 0) {
			start();
		} else {
			if (value2.equals("" + intAnswer)) {
				System.out.println("answer");
				String path = "src//resource/answer.png";
				String path2 = "src//resource/수학퀴즈1.png";
				String path3 = "src//resource/수학퀴즈2.png";
				try {
					FileInputStream fis = new FileInputStream(path);
					BufferedInputStream bis = new BufferedInputStream(fis);
					Image img = new Image(bis);
					FileInputStream fis2 = new FileInputStream(path2);
					BufferedInputStream bis2 = new BufferedInputStream(fis2);
					Image img2 = new Image(bis2);
					FileInputStream fis3 = new FileInputStream(path3);
					BufferedInputStream bis3 = new BufferedInputStream(fis3);
					Image img3 = new Image(bis3);
					correctAnswer.setImage(img);
					backGround.setImage(img2);
					try {
						bis.close();
						fis.close();
						bis2.close();
						fis2.close();
						bis3.close();
						fis3.close();
						Thread t = new Thread(new Runnable() {

							@Override
							public void run() {
								try {
									Thread.sleep(1000);
									correctAnswer.setImage(null);
									backGround.setImage(img3);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();

								}
							}
						});

						t.start();
						valueAnswer++;
						problem();
					} catch (IOException e) {
						e.printStackTrace();
						System.out.println("img");
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}

			} else {
				System.out.println("wrong");
				String path = "src//resource//wrong.png";
				try {
					FileInputStream fis = new FileInputStream(path);
					BufferedInputStream bis = new BufferedInputStream(fis);
					Image img = new Image(bis);
					correctAnswer.setImage(img);
					try {

						bis.close();
						fis.close();
						Thread t = new Thread(new Runnable() {

							@Override
							public void run() {
								try {
									Thread.sleep(1000);
									correctAnswer.setImage(null);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();

								}
							}
						});

						t.start();
						valueWrong++;
						problem();
					} catch (IOException e) {
						e.printStackTrace();
						System.out.println("img");
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}

			}
		}

	}

	public void turnBack() {
		if (value2.length() == 0 || value2.equals("0")) {
			value2 = "0";
		} else {
			value2 = value2.substring(0, value2.length() - 1);
			if (value2.length() == 0) {
				value2 = "0";
			}
		}
		input.setText(value2);
	}

	public Stage pop;

	public void endPop() {
		// 메인 스테이지 취득, 전의 두가지 방법 중 두번째 방법

		// 새로운 스테이지 생성 (옵션 추가, 스타일)
		pop = new Stage(StageStyle.DECORATED); // 스테이지 옵션
		pop.initModality(Modality.WINDOW_MODAL); // 그 위에 뜨는 모달의 옵션
		pop.initOwner(mainStage); // 메인 스테이지 부여

		try {
			mainStage = (Stage) start1.getScene().getWindow();
			// 새로운 스테이지에 custom 레이아웃 불러오기
			Parent root = FXMLLoader.load(getClass().getResource("/math/Pop.fxml"));

			// 씬에 추가
			Scene sc = new Scene(root);
			// 씬에 스타일 추가
			sc.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			pop.setScene(sc);
			pop.setTitle("팝업 띄우기");
			pop.setResizable(false); // 창 사이즈 조절 차단

			// 보여주기
			pop.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void exit() {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("/appScene/GameView.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) start1.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
