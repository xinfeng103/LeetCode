package array._189;

import java.util.Arrays;

public class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

    public void rotate2(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        int count = 0;         // 记录交换位置的次数，n个同学一共需要换n次
        for (int start = 0; count < len; start++) {
            int cur = start;       // 从0位置开始换位子
            int pre = nums[cur];
            do {
                int next = (cur + k) % len;
                int temp = nums[next];    // 来到角落...
                nums[next] = pre;
                pre = temp;
                cur = next;
                count++;
            } while (start != cur);     // 循环暂停，回到起始位置，角落无人

        }
    }


    public void rotate3(int[] nums, int k) {
        k %= nums.length;
        int n = nums.length;
        int[] tmp = nums.clone();
        for (int i = 0; i < n; i++) {
            nums[(i + k) % n] = tmp[i];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 5};
        int k = 2;
        solution.rotate2(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
