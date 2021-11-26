package week1.leetcode;

public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger main = new ReverseInteger();
        int reverse = main.reverse(1534236469);
        System.out.println(reverse);
    }
    public int reverse(int x) {
        int answer = 0;

        while (x != 0) {
            int i = x % 10;
            if (answer > (Integer.MAX_VALUE / 10) || answer < (Integer.MIN_VALUE / 10)) {
                return 0;
            }
            answer = (answer * 10) + i;
            x /= 10;
        }

        return answer;
    }
}
