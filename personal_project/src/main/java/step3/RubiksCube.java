package step3;

public class RubiksCube {
    String[][] top = new String[3][3];
    String[][] front = new String[3][3];
    String[][] left = new String[3][3];
    String[][] right = new String[3][3];
    String[][] bottom = new String[3][3];
    String[][] back = new String[3][3];

    private Command command = new Command();
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
        printCube();
    }

    private void printCube() {

    }

    private void programStart() {

    }

}
