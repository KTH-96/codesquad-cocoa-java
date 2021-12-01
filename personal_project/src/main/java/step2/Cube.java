package step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Cube {
    String[][] cube = new String[3][3];
    public void start() {
        firstCube();
        programStart();
    }

    private void firstCube() {
        String[][] firstCube = {{"R", "R", "W"},
                {"G", "C", "W"},
                {"G", "B", "B"}};

        cube = firstCube;

        for (String[] strings : cube) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    private void programStart() {

        List<String> commandArr = getCube();

        for (int i = 0; i < commandArr.size(); i++) {
            String[][] dummyCube = getDummyCube();
            switch (commandArr.get(i)) {
                case "u":
                    moveTopLeft(dummyCube);
                    break;
                case "u`":
                    moveTopRight(dummyCube);
                    break;
                case "r":
                    moveRightTop(dummyCube);
                    break;
                case "r`":
                    moveRightBottom(dummyCube);
                    break;
                case "l":
                    moveLeftBottom(dummyCube);
                    break;
                case "l`":
                    moveLeftTop(dummyCube);
                    break;
                case "b":
                    moveBottomRight(dummyCube);
                    break;
                case "b`":
                    moveBottomLeft(dummyCube);
                    break;
                case "q":
                    System.out.print("Bye~");
                    System.exit(0);
                    break;
            }
            printCube(commandArr.get(i));
        }
        programStart();
    }

    private String[][] getDummyCube() {
        String[][] dummyCube = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                dummyCube[i][j] = cube[i][j];
            }
        }
        return dummyCube;
    }

    private void printCube(String command) {
        System.out.println(command);
        for (String[] strings : cube) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private List<String> getCube() {
        System.out.print("CUBE> ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command = "";
        try {
            command = br.readLine().toLowerCase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] splitCommand = command.split("");
        List<String> commandArr = new ArrayList<>();
        for (int i = 0; i < command.length(); i++) {
            String commandWord = splitCommand[i];
            if (commandWord.equals("`")) {
                splitCommand[i - 1] += commandWord;
            }
        }
        for (int i = 0; i < splitCommand.length; i++) {
            if (splitCommand[i].equals("`")) {
                continue;
            }
            commandArr.add(splitCommand[i]);
        }
        return commandArr;
    }

    //todo: 가장 아래줄을 왼쪽으로 한칸 밀기
    private void moveBottomLeft(String[][] dummyCube) {
        cube[2][0] = dummyCube[2][2];
        cube[2][1] = dummyCube[2][0];
        cube[2][2] = dummyCube[2][1];
    }
    //todo: 가장 아래줄을 오른쪽으로 한칸 밀기
    private void moveBottomRight(String[][] dummyCube) {
        cube[2][0] = dummyCube[2][1];
        cube[2][1] = dummyCube[2][2];
        cube[2][2] = dummyCube[2][0];
    }
    //todo: 가장 왼쪽줄을 위로 한칸 밀기
    private void moveLeftTop(String[][] dummyCube) {
        cube[0][0] = dummyCube[2][0];
        cube[1][0] = dummyCube[0][0];
        cube[2][0] = dummyCube[1][0];
    }
    //todo:가장 왼쪽줄을 아래로 한칸 밀기
    private void moveLeftBottom(String[][] dummyCube) {
        cube[1][0] = dummyCube[0][0];
        cube[2][0] = dummyCube[1][0];
        cube[0][0] = dummyCube[2][0];
    }
    //todo: 가장 오른쪽줄을 아래로 한칸 밀기
    private void moveRightBottom(String[][] dummyCube) {
        cube[1][2] = dummyCube[0][2];
        cube[2][2] = dummyCube[1][2];
        cube[0][2] = dummyCube[2][2];
    }
    //todo: 가장 오른쪽줄을 위로 한칸 밀기
    private void moveRightTop(String[][] dummyCube) {
        cube[2][2] = dummyCube[0][2];
        cube[1][2] = dummyCube[2][2];
        cube[0][2] = dummyCube[1][2];
    }
    //todo: 가장 윗줄을 오른쪽으로 한칸 밀기
    private void moveTopRight(String[][] dummyCube) {
        cube[0][0] = dummyCube[0][2];
        cube[0][1] = dummyCube[0][0];
        cube[0][2] = dummyCube[0][1];
    }
    //todo: 가장 윗줄을 왼쪽으로 한 칸 밀기
    private void moveTopLeft(String[][] dummyCube) {
        cube[0][0] = dummyCube[0][1];
        cube[0][1] = dummyCube[0][2];
        cube[0][2] = dummyCube[0][0];
    }

}
