package string._28;

class Solution {
    public int BF(String s, String t) {
        int m = t.length();
        int n = s.length();
        for (int start = 0; start < n - m + 1; start++) {
            if (s.substring(start, start + m).equals(t)) {
                return start;
            }
        }
        return -1;
    }

    public int KMP(String s, String t) {
        int m = t.length();
        int n = s.length();
        if (m==0){
            return 0;
        }
        int[] NextArray = getNextArray(t);
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (j == -1 || s.charAt(i) == t.charAt(j)) {
                i += 1;
                j += 1;
            } else {
                j = NextArray[j];
            }

        }

        if (j == m) {
            return i - m;
        } else {
            return -1;
        }

    }

    //next数组
    public int[] getNextArray(String modeStr) {
        int[] nextArray = new int[modeStr.length()];
        nextArray[0] = -1;
        int i = 0;
        int j = -1;
        while (i < modeStr.length() - 1) {
            if (j == -1 || modeStr.charAt(i) == modeStr.charAt(j)) {
                nextArray[++i] = ++j;
            } else {
                j = nextArray[j];
            }
        }
        return nextArray;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String haystack = "mississippi", needle = "issip";
        System.out.println(solution.KMP(haystack, needle));
    }
}
