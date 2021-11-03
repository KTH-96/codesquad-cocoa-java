package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RandomDraw {
    static int num;

    public static void main(String[] args) throws IOException {
        RandomDraw randomDraw = new RandomDraw();
        boolean init = randomDraw.init();
        while (!init){
            init = randomDraw.init();
        }
        randomDraw.getDraw();

    }

    public boolean init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("몇 명인가요(1~10)? ");
        num = Integer.parseInt(br.readLine());
        if (num < 0 || num > 10){
            System.out.println("다시작성");
            return false;
        }
        br.close();
        return true;
    }

    public void getDraw() {
        String[] names = {"리븐", "카이사", "제드", "르블랑", "쓰레쉬",
                "징크스", "그레이브즈", "리신", "룰루", "잭스"};

        Random random = new Random();

        Set<String> set = new HashSet<>();
        int who = 0;
        while (set.size() < num) {
            who = random.nextInt(9);
            set.add(names[who]);
        }
        StringBuilder sb = new StringBuilder();
        set.stream()
                .forEach(name -> sb.append(name).append(", "));

        String result = sb.substring(0, sb.length() - 2);

        System.out.println(result);
    }





}
