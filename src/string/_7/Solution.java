package string._7;

class Solution {
    public int reverse(int x) {
        int revNum = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (revNum > Integer.MAX_VALUE/10 || (revNum == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)) {
                return 0;
            }
            if (revNum < Integer.MIN_VALUE/10 || (revNum == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10)) {
                return 0;
            }
            revNum = revNum * 10 + pop;
        }
        return revNum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(123));
    }
}
