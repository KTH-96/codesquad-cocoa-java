package step1;

import java.util.Scanner;

public class WordService {
    private Scanner sc = new Scanner(System.in);
    private Word wordEdit;

    public void run() {
        getWord();

    }

    //todo: 단어 입력하기
    private void getWord() {
        System.out.println("단어 이동수 방향 ex) apple 3 L");
        System.out.print("> ");
        String word = sc.next();
        int moveNum = sc.nextInt();
        String LR = sc.next();
        LR.toLowerCase();

        boolean valid = wordCheck(word, moveNum, LR);
        while (valid){
            getWord();
        }

        wordEdit = new Word(word, moveNum, LR);
    }
    //todo: 단어 조건에 맞는지 체크하
    private boolean wordCheck(String word, int moveNum, String LR) {
        if (word.split(" ").length >= 1){
            System.out.println("띄워쓰기 들어가면 인식 못합니다 ㅠㅠ");
            return true;
        }
        if (moveNum >= 100 || moveNum < -100) {
            System.out.println("범위는 100 이하 -100 이하입니당");
            return true;
        }
        if (!LR.equals("l") || !LR.equals("r")) {
            System.out.println("L또는 R만 인식 가능합니다르");
            return true;
        }
        return false;
    }
}
