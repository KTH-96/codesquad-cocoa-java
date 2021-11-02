package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gugudan {
    static int startNum,endNum;
    static StringBuilder sb = new StringBuilder();

    public boolean writeNum() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("시작단 과 끝단을 입력(1 ~10)");
        startNum = Integer.parseInt(br.readLine());
        endNum = Integer.parseInt(br.readLine());
        if (startNum < 1 || endNum > 10 || startNum > endNum) {
            System.out.println("다시");
            return false;
        }
        br.close();
        return true;
    }

    public static void getGugudan() {
        for (int i = startNum; i < endNum + 1; i++) {
            for (int j = 1; j < 10; j++) {
                sb.append(i + " * "+ j +" = "+ (i*j)).append('\n');
            }
        }
        System.out.println(sb);
    }

    @Override
    public String toString() {
        return "Gugudan{"+
                "start = "+ startNum+
                ", end = "+endNum+
                '}';
    }

    public static void main(String[] args) throws IOException {
        Gugudan gugudan = new Gugudan();

        boolean valid = gugudan.writeNum();

        while (!valid){
            valid = gugudan.writeNum();
        }

        System.out.println(gugudan);
        getGugudan();
    }
}
