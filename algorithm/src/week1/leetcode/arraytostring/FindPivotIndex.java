package week1.leetcode.arraytostring;

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int leftSum = 0;
        int rightSum = sum;

        int pastpinum = 0;
        for (int i = 0; i < nums.length; i++) {
            int pinum = nums[i];
            rightSum -= pinum;
            leftSum += pastpinum;
            if (leftSum == rightSum) {
                return i;
            }
            pastpinum = pinum;
        }
        return -1;
    }
}
