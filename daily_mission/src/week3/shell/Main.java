package week3.shell;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        boolean loop = true;
        Shell shelling = new Shell();
        while (loop) {
            try {
                loop = shelling.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
