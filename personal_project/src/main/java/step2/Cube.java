package step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

public class Cube {
    String[][] cube = new String[3][3];
    public boolean Start() {
        firstCube();

        for (String[] strings : cube) {
            for (String string : strings) {
                System.out.print(string+ " ");
            }
            System.out.println();
        }
        return programStart();
    }

    private void firstCube() {
        String[][] firstCube = {{"R","R","W"},
                        {"G","C","W"},
                        {"G","B","B"}};
        cube = firstCube;
    }

    private boolean programStart() {
        System.out.print("CUBE> ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command = "";
        try {
            command = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] splitCommand = command.split("");
        //a a a ` a ` a a
        List<String> commandArr = new ArrayList<>();
        for (int i = 0; i < command.length(); i++) {
            String commandWord = splitCommand[i];
            if (commandWord.equals("`")) {
                splitCommand[i - 1] += commandWord;
            }
        }
        for (int i = 0; i < splitCommand.length; i++) {
            if (splitCommand[i].equals("`")){
                continue;
            }
            commandArr.add(splitCommand[i]);
        }
        for (String s : commandArr) {
            System.out.println(s);
        }


//        switch (commandWord) {
//            case "u":
//                moveTopLeft();
//            case "u`":
//                moveTopRight();
//            case "q":
//                return false;
//            }

        return false;
    }
}
