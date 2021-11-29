package step1;

public class Word {
    private String word;
    private int move;
    private String LR;

    public Word(String word, int move, String LR) {
        this.word = word;
        this.move = move;
        this.LR = LR;
    }

    public String getWord() {
        return word;
    }

    public int getMove() {
        return move;
    }

    public String getLR() {
        return LR;
    }
}
