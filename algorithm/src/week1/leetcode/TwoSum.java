package week1.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target){
        int[] answer = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= j) {
                    continue;
                }
                if (nums[i] + nums[j] == target) {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        return answer;

    }
    /**
     * 6ms solution
     */
    public int[] solution(int[] nums, int target){
        Map<Integer, Integer> m = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            System.out.println("+++++++++++ " + (target - nums[i]) + "++++++++++++ "+i);
            System.out.println("=========== "+ m.get(target-nums[i]));
            //key true = return value
            if(m.get(target-nums[i]) != null){
                return new int[]{m.get(target-nums[i]), i};
            }
            m.put(nums[i],i);
            // map = (1, 0)(2, 1)(3,2)(5,3)
        }
        return new int[]{0,0};
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] test = {1, 2, 3, 5};
        int targetTest = 5;
        twoSum.solution(test, targetTest);
    }
}
