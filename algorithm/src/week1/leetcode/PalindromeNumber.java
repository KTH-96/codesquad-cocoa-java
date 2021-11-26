package week1.leetcode;

public class PalindromeNumber {
    public static void main(String[] args) {
        PalindromeNumber main = new PalindromeNumber();
        boolean palindrome = main.isPalindrome(121);
        System.out.println(palindrome);
    }
    public boolean isPalindrome(int x) {
        int result = x;
        if (x < 0) {
            return false;
        }
        int reverseX = 0;
        int i = 0;
        while (x != 0){
            i = x % 10;
            reverseX = (reverseX * 10) + i;
            x /= 10;
        }
        if (reverseX == result) {
            return true;
        }
        return false;
    }
}
