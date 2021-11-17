package math;

import java.io.*;

import appScene.MathPop;


public class Stopwatch extends MathPop{
  public static String timerBuffer;
  static int oldTime;
  static int time = 0;


  public static void stopwatch(int onOff) {
    if (onOff == 1)
      oldTime = (int) System.currentTimeMillis() / 1000;

    if (onOff == 0)
      secToHHMMSS(  ((int) System.currentTimeMillis() / 1000) - oldTime  );
  }


  public static void secToHHMMSS(int secs) {
    int hour, min, sec;
    System.out.println(secs);;
    sec  = secs % 60;
    min  = secs / 60 % 60;
    hour = secs / 3600;

    timerBuffer = String.format("%02d:%02d:%02d", hour, min, sec);
    time = sec;
  }


  public static void pause() {
    try {
      System.in.read();
    } catch (IOException e) { }
  }


}