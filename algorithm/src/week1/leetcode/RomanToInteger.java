package week1.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        RomanToInteger main = new RomanToInteger();
        main.romanToInt("III");
    }
    public int romanToInt(String s) {
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);
        char[] chars = s.toCharArray();
        int answer = 0;
        for (char aChar :chars){
            Integer a = roman.get(aChar);
            answer += a;
        }
        return answer;
    }
}
