package math._191;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n = n >>> 1;
        }
        return count;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int ans = solution.hammingWeight(8);
        System.out.println(ans);
    }
}
