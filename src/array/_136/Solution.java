package array._136;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 2, 1};
        int ans = solution.singleNumber(nums);
        System.out.println(ans);
    }
}
