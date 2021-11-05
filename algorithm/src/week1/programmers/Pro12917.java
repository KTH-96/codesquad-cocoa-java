package week1.programmers;

import java.util.Arrays;

public class Pro12917 {
    public static void main(String[] args) {
        Pro12917 aa = new Pro12917();
        String asfasdfe = aa.solution("asfasdfe");
        System.out.println(asfasdfe);
    }
    public String solution(String s) {
//        char[] ch = new char[s.length()];
//        for (int i = 0; i < s.length(); i++) {
//            ch[i] = s.charAt(i);
//        }

//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < ch.length; i++) {
//            sb.append(ch[i]);
//        }

//        return sb.reverse().toString();

        char[] answer = s.toCharArray();
        Arrays.sort(answer);
        return new StringBuilder(new String(answer)).reverse().toString();

//        return s.chars()
//                .sorted()
//                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
//                .reverse()
//                .toString();

    }
}
