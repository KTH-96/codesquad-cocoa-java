package week3.shell.hclock.time;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class TimeService {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\033[0;32m";
    private Time time;
    private Hour hour;
    private Min min;

    public void run() {
         String[][] arr = {{"한","두","셋","넷","다","섯"},
                        {"여","섯","일","곱","여","덟"},
                        {"아","홉","열","한","두","시"},
                        {"자","이","삼","사","오","십"},
                        {"정","일","이","삼","사","육"},
                        {"오","오","칠","팔","구","분"}};
        getHourAndMin();
        if (time.getHour() % 12 != 0) {
            changeColorHour(arr, time.getHour(), hour.values());
            changeColorMin(arr, time.getMin(), min.values());
        }else{
            changeColor(arr);
        }
        showClock(arr);
    }

    private void changeColor(String[][] arr) {
        if (time.getHour() == 12 && time.getMin() == 0){
            arr[4][0] = ANSI_PURPLE + "정" + ANSI_RESET;
            arr[5][0] = ANSI_PURPLE + "오" + ANSI_RESET;
        }else if (time.getHour() == 0 && time.getMin() == 0){
            arr[3][0] = ANSI_PURPLE + "자" + ANSI_RESET;
            arr[4][0] = ANSI_PURPLE + "정" + ANSI_RESET;
        }
    }

    private void changeColorHour(String[][] arr, int hour, Hour[] hangulHour) {
        int value = hour % 12;

        arr[2][5] = ANSI_PURPLE + "시" + ANSI_RESET;
        for (Hour hourValue : hangulHour) {
            if (value == hourValue.getHour()) {
                arr[hourValue.getY()][hourValue.getX()] = ANSI_PURPLE + hourValue.getHangulHour() + ANSI_RESET;
            }
        }

    }

    private void changeColorMin(String[][] arr, int min, Min[] hangulMin) {
        int tenMin = min / 10;
        int oneMin = min % 10;
        if (min != 0){
            arr[5][5] = ANSI_PURPLE + "분" + ANSI_RESET;
        }
        for (Min minValue : hangulMin) {
            if (tenMin > 0){
                arr[3][5] = ANSI_PURPLE + "십" + ANSI_RESET;
                if (oneMin == minValue.getMin()){
                    arr[minValue.getY()][minValue.getX()] = ANSI_PURPLE + minValue.getHangulMin() + ANSI_RESET;
                }
            }else {
                if (oneMin == minValue.getMin()){
                    arr[minValue.getY()][minValue.getX()] = ANSI_PURPLE + minValue.getHangulMin() + ANSI_RESET;
                }
            }
        }
    }

    private void getHourAndMin() {
        LocalTime now = LocalTime.now();
        String formattedNow = now.format(DateTimeFormatter.ofPattern("HH/mm"));
        StringTokenizer st = new StringTokenizer(formattedNow, "/");
        time = new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
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
