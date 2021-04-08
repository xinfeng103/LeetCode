package string._14;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        int count = 0;
        String str1 = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int len = str1.length() < strs[i].length() ? str1.length() : strs[i].length();
            for (int j = 0; j < len; j++) {
                if (str1.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
                count++;
            }
            str1 = str1.substring(0, count);
            count = 0;
        }
        return str1;
    }

    public String longestCommonPrefix1(String[] strs) {
        //边界条件判断
        if (strs == null || strs.length == 0)
            return "";
        //默认第一个字符串是他们的公共前缀
        String pre = strs[0];
        int i = 1;
        while (i < strs.length) {
            //不断的截取
            while (strs[i].indexOf(pre) != 0)
                pre = pre.substring(0, pre.length() - 1);
            i++;
        }
        return pre;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix1(strs));
    }
}
