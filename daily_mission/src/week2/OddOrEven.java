package week2;

import java.util.Random;
import java.util.Scanner;

public class OddOrEven {
    static Scanner sc = new Scanner(System.in);
    static int stage = 1;
    public static void main(String[] args) {
        int playerMoney = getPlayerAndMoney();

        double computerMoney = getComputerMoney(playerMoney, stage);

        startGame(playerMoney, computerMoney);
    }

    private static void startGame(int playerMoney, double computerMoney) {
        Random random = new Random();
        while (playerMoney != 0) {
            System.out.print("배팅하세요 >");
            int batMoney = sc.nextInt();//

            int oddOrEven = random.nextInt(20);
            System.out.println(oddOrEven);
            System.out.print("odd,even? >");
            String str = sc.next();
            str.toLowerCase();
            if (str.equals("odd")){
                if (oddOrEven % 2 != 0){
                    System.out.println("승리");
                    playerMoney += batMoney;
                    computerMoney += batMoney;
                }else {
                    System.out.println("패배");
                    playerMoney -= batMoney;
                    computerMoney -= batMoney;
                }
            }else if (str.equals("even")){
                if (oddOrEven % 2 == 0){
                    System.out.println("승리");
                    playerMoney += batMoney;
                    computerMoney += batMoney;
                }else {
                    System.out.println("패배");
                    playerMoney -= batMoney;
                    computerMoney -= batMoney;
                }
            }
        }
        if (playerMoney <= 0) {
            System.out.print("1. 재시작 2.종료 > ");
            int num = sc.nextInt();
            switch (num){
                case 1:
                    getPlayerAndMoney();
                    stage = 1;
                    break;
                case 2:
                    System.exit(0);
            }
        } else if (computerMoney <= 0 ){
            System.out.print("승리하셨습니다 다음게임~ >");
            stage++;
            if (stage > 8){
                System.out.println("완전히 승리하셨습니다");
                System.exit(0);
            }
            getComputerMoney(playerMoney, stage);
        }

    }

    private static double getComputerMoney(int playerMoney, int stage) {
        double computerMoney = Math.pow(playerMoney * 1.2, stage);
        return computerMoney;
    }

    private static int getPlayerAndMoney() {
        System.out.print("플레이어 이름> ");
        String player = sc.next();
        int playerMoney = 100;
        return playerMoney;
    }
}
