package week1.programmers;

public class Pro12922 {
    public String solution(int n) {
        int repeat = n/2;

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= repeat; i++) {
            sb.append("수박");
        }
        if (n % 2 == 1) {
            sb.append("수");
        }
        return sb.toString();
    }
}
