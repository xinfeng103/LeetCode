package array._27;

import java.util.Arrays;

class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int n : nums) {
            if (n != val) {
                nums[k++] = n;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        Solution solution = new Solution();
        int len = solution.removeElement(nums, val);
        System.out.println("修改后的数组为:" + Arrays.toString(nums));
        System.out.println("移除元素后的数组长度为:" + len);
    }
}
