package step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WordCheck {
    private Word wordEdit;
    private String word;
    private int  moveNum;
    private String LR;

    public void run() {
        getWord();
        WordEdit wordEdit = new WordEdit();
        wordEdit.edit();
    }

    //todo: 단어 입력하기
    private void getWord() {
        System.out.println("단어 이동수 방향 ex) apple 3 L");
        System.out.print("> ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            word = st.nextToken();
            moveNum = Integer.parseInt(st.nextToken());
            LR = st.nextToken();
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean valid = wordCheck(word, moveNum, LR);
        if (valid == false) {
            getWord();
        }
        wordEdit = new Word(word, moveNum, LR);
    }
    //todo: 단어 조건에 맞는지 체크하기
    private boolean wordCheck(String word, int moveNum, String LR) {
        if (checkWord(word)) return false;
        if (checkLR(LR)) return false;
        if (moveNumCheck(moveNum)) return false;

        return true;
    }

    private boolean checkLR(String lr) {
        if (lr.equalsIgnoreCase("l") || lr.equalsIgnoreCase("r")) {
            return false;
        }else {
            return true;
        }
    }

    private boolean moveNumCheck(int moveNum) {
        if (moveNum >= 100 || moveNum < -100) {
            System.out.println("범위는 100 이하 -100 이하입니당");
            return true;
        }
        return false;
    }

    private boolean checkWord(String word) {
        if (word.contains(" ")){
            System.out.println("단어에 띄어쓰기 하면 다시 해야합니당");
            return true;
        }
        return false;
    }
}
