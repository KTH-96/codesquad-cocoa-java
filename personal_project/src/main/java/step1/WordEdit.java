package step1;

public class WordEdit {
    //todo: 단어 고치기
    public void edit(String word, int moveNum, String LR) {
        if (moveNum < 0) {
            LR = changeLR(LR);
            moveNum *= -1;
        }
        int move = moveNum % word.length();
        //L은 앞 -> 뒤
        if (LR.equalsIgnoreCase("l")) {
            editLeft(word, move, LR);
        } else {
        //R은 뒤 -> 앞
            editRight(word, move, LR);
        }
    }

    private void editRight(String word, int move, String lr) {
        System.out.println(word.length() - move);
        String moveWord = word.substring(word.length() - move, word.length());
        String standWord = word.substring(0, word.length() - move);
        System.out.println(moveWord + standWord);
    }

    private void editLeft(String word, int move, String LR) {
        String moveWord = word.substring(0, move);
        String standWord = word.substring(move, word.length());
        System.out.println(standWord + moveWord);
    }

    private String changeLR(String lr) {
        if (lr.equalsIgnoreCase("l")){
            lr = "r";
        }else {
            lr = "l";
        }
        return lr;
    }


}
