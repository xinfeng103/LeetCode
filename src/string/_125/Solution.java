package string._125;

class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        char[] str2 = s.toLowerCase().toCharArray(); //转换成小写形式，再转化为字符数组
        while (left < right) {
            //判断是否为字母或数字，如果不是直接跳过
            while (left < right && !Character.isLetterOrDigit(str2[left])) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(str2[right])) {
                --right;
            }

            if (str2[left] != str2[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindrome1(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        Solution solution = new Solution();
        System.out.println("是否为回文串" + solution.isPalindrome(s));
    }
}
