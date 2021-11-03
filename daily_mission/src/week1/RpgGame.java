package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class RpgGame {

    public static void main(String[] args) throws IOException {
        RpgGame rpgGame = new RpgGame();

        String[][] finishSetting = rpgGame.createBoobAndMonster(rpgGame.getBackBoard());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("WASD로 중 하나로 움직이세요 >");
        String move = br.readLine();
        if (move.equals("w")) {

        }

    }

    private String[][] createBoobAndMonster(String[][] backBoard) {
        Random rd = new Random();

        int row = rd.nextInt(4);
        int column = rd.nextInt(4);
        backBoard[row][column] = "m";

        row = rd.nextInt(4);
        column = rd.nextInt(4);
        backBoard[row][column] = "b";

        return backBoard;
    }

    private String[][] getBackBoard() {
        String[][] arr = new String[5][5];
        arr[2][2] = "p";
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[i][j] == null) {
                    arr[i][j] = "*";
                }
            }
        }
        return arr;
    }
}
