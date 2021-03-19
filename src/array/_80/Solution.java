package array._80;

import java.util.Arrays;

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int k = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) {
                nums[++k] = nums[i];
            }
        }
        return ++k;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution();
        int len = solution.removeDuplicates(nums);
        System.out.println("移除重复元素后的数组长度为：" + len);
        System.out.println("修改后的数组为" + Arrays.toString(nums));
    }
}
