package step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RubiksCube {
    String[][] top = new String[3][3];
    String[][] front = new String[3][3];
    String[][] left = new String[3][3];
    String[][] right = new String[3][3];
    String[][] bottom = new String[3][3];
    String[][] back = new String[3][3];

    public void start() {
        firstCubeSetting();
        programStart();
    }


    private void firstCubeSetting() {
        for (int i = 0; i < 3; i++) {
            top[i] = new String[]{"B", "B", "B"};
            front[i] = new String[]{"O", "O", "O"};
            left[i] = new String[]{"W", "W", "W"};
            right[i] = new String[]{"G", "G", "G"};
            bottom[i] = new String[]{"R", "R", "R"};
            back[i] = new String[]{"Y", "Y", "Y"};
        }
        printCube("초기상태");
    }

    private void printCube(String word) {
        System.out.println("======"+word.toUpperCase()+"========");
        for (int i = 0; i < 3; i++) {
            System.out.println("\t\t"+ top[i][0] + " " + top[i][1] + " " + top[i][2]);
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + left[i][0] + " " + left[i][1] + " " + left[i][2] + " "
                    + " " + front[i][0] + " " + front[i][1] + " " + front[i][2] + " "
                    + " " + right[i][0] + " " + right[i][1] + " " + right[i][2] + " "
                    + " " + back[i][0] + " " + back[i][1] + " " + back[i][2]);
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("\t\t"+ bottom[i][0] + " " + bottom[i][1] + " " + bottom[i][2]);
        }
    }

    private void programStart() {
        List<String> commands = getCubeCommand();
        for (int i = 0; i < commands.size(); i++) {
            String[][] dummyTop = getDummyCube(top);
            String[][] dummyFront = getDummyCube(front);
            String[][] dummyRight = getDummyCube(right);
            String[][] dummyBack = getDummyCube(back);
            String[][] dummyBottom = getDummyCube(bottom);
            String[][] dummyLeft = getDummyCube(left);
            String word = commands.get(i);
            switch (word) {
                case "f":
                    moveFront(dummyTop, dummyRight, dummyBottom, dummyLeft);
                    break;
                case "f`":
                    moveFrontReverse(dummyTop, dummyRight, dummyBottom, dummyLeft);
                    break;
                case "r":
                    moveRight(dummyTop, dummyFront, dummyBottom, dummyBack);
                    break;
                case "r`":
                    moveRightReverse(dummyTop, dummyFront, dummyBottom, dummyBack);
                    break;
                case "u":
                    moveTop(dummyLeft, dummyFront, dummyRight, dummyBack);
                    break;
                case "u`":
                    moveTopReverse(dummyLeft, dummyFront, dummyRight, dummyBack);
                    break;
                case "b":
                    moveBack(dummyTop, dummyRight, dummyBottom, dummyLeft);
                    break;
                case "b`":
                    moveBackReverse(dummyTop, dummyRight, dummyBottom, dummyLeft);
                    break;
                case "l":
                    moveLeft(dummyTop, dummyFront, dummyBottom, dummyBack);
                    break;
                case "l`":
                    moveLeftReverse(dummyTop, dummyFront, dummyBottom, dummyBack);
                    break;
                case "d":
                    moveBottom(dummyLeft, dummyFront, dummyRight, dummyBack);
                    break;
                case "d`":
                    moveBottomReverse(dummyLeft, dummyFront, dummyRight, dummyBack);
                    break;
                case "q":
                    System.out.print("Bye~");
                    System.exit(0);
                    break;
            }
            printCube(word);
        }
        programStart();
    }

    private void moveBottomReverse(String[][] dummyLeft, String[][] dummyFront, String[][] dummyRight, String[][] dummyBack) {
        for (int i = 0; i < 3; i++) {
            front[2][i] = dummyRight[2][i];
            right[2][i] = dummyBack[2][i];
            back[2][i] = dummyLeft[2][i];
            left[2][i] = dummyFront[2][i];
        }
    }

    private void moveBottom(String[][] dummyLeft, String[][] dummyFront, String[][] dummyRight, String[][] dummyBack) {
        for (int i = 0; i < 3; i++) {
            front[2][i] = dummyLeft[2][i];
            right[2][i] = dummyFront[2][i];
            back[2][i] = dummyRight[2][i];
            left[2][i] = dummyBack[2][i];
        }
    }

    private void moveLeftReverse(String[][] dummyTop, String[][] dummyFront, String[][] dummyBottom, String[][] dummyBack) {
        for (int i = 0; i < 3; i++) {
            bottom[i][0] = dummyBack[i][2];
            back[i][2] = dummyTop[i][0];
            top[i][0] = dummyFront[i][0];
            front[i][0] = dummyBottom[i][0];
        }
    }

    private void moveLeft(String[][] dummyTop, String[][] dummyFront, String[][] dummyBottom, String[][] dummyBack) {
        for (int i = 0; i < 3; i++) {
            bottom[i][0] = dummyFront[i][0];
            back[i][2] = dummyBottom[i][0];
            top[i][0] = dummyBack[i][2];
            front[i][0] = dummyTop[i][0];
        }
    }

    private void moveBackReverse(String[][] dummyTop, String[][] dummyRight, String[][] dummyBottom, String[][] dummyLeft) {
        for (int i = 0; i < 3; i++) {
            left[i][0] = dummyBottom[2][i];
            bottom[2][i] = dummyRight[i][2];
            right[i][2] = dummyTop[0][i];
            top[0][i] = dummyLeft[i][0];
        }
    }

    private void moveBack(String[][] dummyTop, String[][] dummyRight, String[][] dummyBottom, String[][] dummyLeft) {
        for (int i = 0; i < 3; i++) {
            left[i][0] = dummyTop[0][i];
            bottom[2][i] = dummyLeft[i][0];
            right[i][2] = dummyBottom[2][i];
            top[0][i] = dummyRight[i][2];
        }
    }

    private void moveTopReverse(String[][] dummyLeft, String[][] dummyFront, String[][] dummyRight, String[][] dummyBack) {
        for (int i = 0; i < 3; i++) {
            front[0][i] = dummyLeft[0][i];
            left[0][i] = dummyBack[0][i];
            back[0][i] = dummyRight[0][i];
            right[0][i] = dummyFront[0][i];
        }
    }

    private void moveTop(String[][] dummyLeft, String[][] dummyFront, String[][] dummyRight, String[][] dummyBack) {
        for (int i = 0; i < 3; i++) {
            front[0][i] = dummyRight[0][i];
            left[0][i] = dummyFront[0][i];
            back[0][i] = dummyLeft[0][i];
            right[0][i] = dummyBack[0][i];
        }
    }

    private void moveRightReverse(String[][] dummyTop, String[][] dummyFront, String[][] dummyBottom, String[][] dummyBack) {
        for (int i = 0; i < 3; i++) {
            top[i][2] = dummyBack[i][0];
            front[i][2] = dummyTop[i][2];
            bottom[i][2] = dummyFront[i][2];
            back[i][0] = dummyBottom[i][2];
        }
    }

    private void moveRight(String[][] dummyTop, String[][] dummyFront, String[][] dummyBottom, String[][] dummyBack) {
        for (int i = 0; i < 3; i++) {
            top[i][2] = dummyFront[i][2];
            front[i][2] = dummyBottom[i][2];
            bottom[i][2] = dummyBack[i][2];
            back[i][0] = dummyTop[i][2];
        }
    }

    private void moveFrontReverse(String[][] dummyTop, String[][] dummyRight, String[][] dummyBottom, String[][] dummyLeft) {
        for (int i = 0; i <3; i++) {
            top[2][i] = dummyRight[i][0];
            right[i][0] = dummyBottom[0][i];
            bottom[0][i] = dummyLeft[i][2];
            left[i][2] = dummyTop[2][i];
        }
    }

    private void moveFront(String[][] dummyTop, String[][] dummyRight, String[][] dummyBottom, String[][] dummyLeft) {
        for (int i = 0; i <3; i++) {
            top[2][i] = dummyLeft[i][2];
            right[i][0] = dummyTop[2][i];
            bottom[0][i] = dummyRight[i][0];
            left[i][2] = dummyBottom[0][i];
        }
    }

    private String[][] getDummyCube(String[][] cube) {
        String[][] dummyCube = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                dummyCube[i][j] = cube[i][j];
            }
        }
        return dummyCube;
    }

    private List<String> getCubeCommand() {
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
            if (commandWord.equals("`")||commandWord.equals("2")) {
                splitCommand[i - 1] += commandWord;
            }
        }
        for (int i = 0; i < splitCommand.length; i++) {
            if (splitCommand[i].equals("`")||splitCommand[i].equals("2")) {
                continue;
            }
            commandArr.add(splitCommand[i]);
        }
        return commandArr;
    }

}
