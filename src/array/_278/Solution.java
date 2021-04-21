package array._278;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (!isBadVersion(mid)) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    public int firstBadVersion1(int n) {
        for (int i = 1; i < n; i++) {
            if (isBadVersion(i)) {
                return i;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.firstBadVersion(10));
    }
}
