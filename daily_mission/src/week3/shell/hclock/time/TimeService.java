package week3.shell.hclock.time;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class TimeService {
    public static final String ANSI_RESET = "\u001B[0M";
    public static final String ANSI_PURPLE = "\u001B[35M";
    private Time time;

    private String[][] arr = {{"한","두","셋","넷","다","섯"},
                        {"여","섯","일","곱","여","덟"},
                        {"아","홉","열","한","두","시"},
                        {"자","이","삼","사","오","십"},
                        {"정","일","이","삼","사","육"},
                        {"오","오","칠","팔","구","분"}};

    public void run() {
        getHourAndMin();
        changeColorHour();
        changeColorMin();
        showClock(arr);
    }
    //todo:해당시간의 좌표값에 색깔을 넣기, 12 넘어가면 다시 초기화, 12정오 00자정
    private void changeColorHour() {

    }
    //todo:해당분의 좌표값에 색깔을 넣기, 십분단위 /10, 일분단위 %10 해서 해볼예정
    private void changeColorMin() {
    }

    private void getHourAndMin() {
        LocalTime now = LocalTime.now();
        String formattedNow = now.format(DateTimeFormatter.ofPattern("HH/mm"));
        StringTokenizer st = new StringTokenizer(formattedNow, "/");
        time = new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        System.out.println(formattedNow);
    }

    private void showClock(String[][] arr) {
        for (String[] strings : arr) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }
}
