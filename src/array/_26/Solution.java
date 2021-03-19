package array._26;

import java.util.Arrays;

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int k = 0;
        for (int val : nums) {
            if (val != nums[k]) {
                nums[++k] = val;
            }
        }
        return ++k;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        Solution solution = new Solution();
        int len = solution.removeDuplicates(nums);
        System.out.println("移除重复元素后的数组长度为：" + len);
        System.out.println("修改后的数组为" + Arrays.toString(nums));
        ;
    }
}
