package week1.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class boj1259 {
    public static void main(String[] args) throws IOException {
//        String input = "12421";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] str = input.split("");
        String[] str2 = new String[(str.length/2)+1];
        for (int i = (str.length/2)+1; i < str.length ; i++) {
            str2[i] = str[(str.length/2)+1];
        }
        // str = 12421 str2 = 21
        List<String> list = new ArrayList<>(Arrays.asList(str2));
        Collections.sort(list, Collections.reverseOrder());
        //str = 12421  str2 = 12
        boolean result = result(str, list);
        if (result) {
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
    }

    private static boolean result(String[] str, List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (!str[i].equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }
}
