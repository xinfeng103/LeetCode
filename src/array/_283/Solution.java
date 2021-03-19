package array._283;

import java.util.Arrays;

class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int k = 0;
        for (int val : nums) {
            if (val != 0) {
                nums[k++] = val;
            }
        }
        while (k < nums.length) {
            nums[k++] = 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 1, 0, 3, 12};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
