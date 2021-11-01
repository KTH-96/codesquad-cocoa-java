package week1;

import java.util.Scanner;

public class Gugudan {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        System.out.println("시작숫자와 마지막 숫자 입력: ");
        int startNum = sc.nextInt();
        int endNum = sc.nextInt();
        for (int i = startNum; i <= endNum; i++) {
            for (int j = 1; j <= 9; j++) {
                sb.append(i + " * " + j + " = " + i * j).append('\n');
            }
        }
        System.out.println(sb);
    }
}
