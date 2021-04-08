package string._38;

class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        StringBuilder ans = new StringBuilder();
        //直接用String类型，会由于每次更新都要新建字符串，导致效率很低，因此使用可变的StringBuilder类型
        String s1 = countAndSay(n - 1);
        int count = 1, i = 0;
        for (; i < s1.length() - 1; i++) {
            char cur = s1.charAt(i);
            if (cur == s1.charAt(i + 1)) {
                count++;
            } else {
                ans.append(count);
                ans.append(cur);
                count = 1;
            }
        }
        ans.append(count);
        ans.append(s1.charAt(i));
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countAndSay(5));
    }
}
