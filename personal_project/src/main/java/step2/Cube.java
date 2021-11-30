package step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Cube {
    String[][] cube = new String[3][3];

    public boolean Start() {
        firstCube();

        for (String[] strings : cube) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
        return programStart();
    }

    private void firstCube() {
        String[][] firstCube = {{"R", "R", "W"},
                {"G", "C", "W"},
                {"G", "B", "B"}};
        cube = firstCube;
    }

    private boolean programStart() {
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

        for (int i = 0; i < commandArr.size(); i++) {
            switch (commandArr.get(i)) {
                case "u":
                    moveTopLeft();
                    break;
                case "u`":
                    moveTopRight();
                    break;
                case "r":
                    moveRightTop();
                    break;
                case "r`":
                    moveRightBottom();
                    break;
                case "l":
                    moveLeftBottom();
                    break;
                case "l`":
                    moveLeftTop();
                    break;
                case "b":
                    moveBottomRight();
                    break;
                case "b`":
                    moveBottomLeft();
                    break;
                case "q":
                    System.out.println("Bye~");
                    return false;
            }
        }
        return true;
    }
    //todo: 가장 아래줄을 왼쪽으로 한칸 밀기
    private void moveBottomLeft() {
    }
    //todo: 가장 아래줄을 오른쪽으로 한칸 밀기
    private void moveBottomRight() {
    }
    //todo: 가장 왼쪽줄을 위로 한칸 밀기
    private void moveLeftTop() {
    }
    //todo:가장 왼쪽줄을 아래로 한칸 밀기
    private void moveLeftBottom() {
    }
    //todo: 가장 오른쪽줄을 아래로 한칸 밀기
    private void moveRightBottom() {
    }
    //todo: 가장 오른쪽줄을 위로 한칸 밀기
    private void moveRightTop() {
    }
    //todo: 가장 윗줄을 오른쪽으로 한칸 밀기
    private void moveTopRight() {
    }
    //todo: 가장 윗줄을 왼쪽으로 한 칸 밀기
    private void moveTopLeft() {

    }

    private String[][] copyCube(){
        String[][] dummyCube = cube;
        return dummyCube;
    }
}
