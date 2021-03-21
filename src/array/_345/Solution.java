package array._345;

import java.util.Arrays;
import java.util.HashSet;

class Solution {
    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A',
                    'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {
        if (s == null) return null;
        int low = 0, high = s.length() - 1;
        char[] c = new char[s.length()];
        while (low <= high) {
            char cl = s.charAt(low);
            char ch = s.charAt(high);
            if (!vowels.contains(cl)) {
                c[low++] = cl;
            } else if (!vowels.contains(ch)) {
                c[high--] = ch;
            } else {
                c[low++] = ch;
                c[high--] = cl;
            }
        }
        return new String(c);
    }

    public static void main(String[] args) {
        String s = "hello";
        Solution solution = new Solution();
        System.out.println("翻转后的字符串" + solution.reverseVowels(s));
    }
}
