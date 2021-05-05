package math._326;

//326 3的幂

class Solution {
    /*
        如果能够被3整除就除以3，直到不能被3整除为止，最后判断n是否等于1(0次幂).
     */
    public boolean isPowerOfThree(int n) {
        if (n > 1) { // 如果n<=1，说明不是3的幂，直接返回
            while (n % 3 == 0)  // 如果n/3=1或其他不能被3整除的数，退出循环
                n /= 3;
        }
        return n == 1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean ans = solution.isPowerOfThree(27);
        System.out.println(ans);
    }
}
