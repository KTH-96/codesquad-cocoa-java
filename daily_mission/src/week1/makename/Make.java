package week1.makename;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Make {

    public static void main(String[] args) throws IOException {
        Make make = new Make();
        make.getName(make.getDay());
    }

    public int[] getDay() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("생년 월 일을 입력해 주세요(날짜 사이사이에는 띄워주기)> ");
        String birth = br.readLine();

        boolean valid = validString(birth);
        while (!valid) {
            getDay();
            valid  = validString(birth);
        }
        try {
            StringTokenizer st = new StringTokenizer(birth, " ");
            int year = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());

            boolean validDay = validDay(month, day);
            while (!validDay) {
                getDay();
                validDay  = validDay(month, day);
            }

            int[] birthday = {year%10, month-1, day-1};
            return birthday;

        }catch (NoSuchElementException no){
            System.out.println(no + ": 띄워쓰기 하나 더해");
            return getDay();
        }
    }

    public boolean validDay(int month, int day) {
        if (month > 13 || month < 0 || day < 0 || day > 32) {
            System.out.println("달력보고와");
            return false;
        }
        return true;
    }

    public boolean validString(String birth) {
        if (!birth.contains(" ")){
            System.out.println("돌아가");
            return false;
        }
        return true;
    }

    public void getName(int[] birthday) {
        IndianName indianName = new IndianName(birthday[0], birthday[1], birthday[2]);
        System.out.println(indianName);
    }
}
