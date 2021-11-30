package step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        String commands = "";
        try {
            commands = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringTokenizer st = new StringTokenizer(commands.toLowerCase(), "");

        while (st.hasMoreTokens()) {
            String commandWord = st.nextToken();
            switch (commandWord) {

            }
        }
        return false;
    }
}
