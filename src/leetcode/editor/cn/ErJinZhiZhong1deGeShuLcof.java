
//请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。
//例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入9，则该函数输出 2。

// 示例 1：
//输入：00000000000000000000000000001011
//输出：3

// 示例 2：
//输入：00000000000000000000000010000000
//输出：1

// 示例 3：
//输入：11111111111111111111111111111101
//输出：31

// 提示：
// 输入必须是长度为 32 的 二进制串 。 


package leetcode.editor.cn;

public class ErJinZhiZhong1deGeShuLcof {
    public static void main(String[] args) {
        Solution solution = new ErJinZhiZhong1deGeShuLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int res = 0;
            while (n != 0) {
                /*  方法一
                res += n & 1;
                n >>>= 1;
                 */

                // 方法二
                //（n-1):二进制数字最右边的1变成0，此1右边的0都变成1
                // n&(n-1):二进制数字最右边的1变成0，其余不变
                res++;
                n&=(n-1);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}