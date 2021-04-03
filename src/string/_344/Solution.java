package string._344;

class Solution {
    public void reverseString(char[] s) {
        if (s.length < 2) {
            return;
        }
        int left = -1, right = s.length;
        while (++left < --right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        solution.reverseString(s);
        System.out.println(s);
    }
}
