package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon2441 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int star = i;
            int space = 0;
            while (space < i) {
                sb.append(" ");
                space++;
            }
            while (star < N){
                sb.append("*");
                star++;
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
