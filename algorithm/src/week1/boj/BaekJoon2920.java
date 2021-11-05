package week1.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        String answer = br.readLine();
//        if (answer.equals("1 2 3 4 5 6 7 8")) {
//            System.out.println("ascending");
//        } else if (answer.equals("8 7 6 5 4 3 2 1")){
//            System.out.println("descending");
//        } else {
//            System.out.println("mixed");
//        }

        int[] nums = new int[8];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 8; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        if (nums[0] == 1){
            int a = 1;
            for (int num : nums) {
                if (num != a) {
                    System.out.println("mixed");
                    return;
                }
                a++;
            }
            System.out.println("ascending");
        } else if (nums[0] == 8){
            int a = 8;
            for (int num : nums) {
                if (num != a) {
                    System.out.println("mixed");
                    return;
                }
                a--;
            }

            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}
