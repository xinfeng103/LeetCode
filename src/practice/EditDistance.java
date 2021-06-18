package practice;

/*
 todo: 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数.
       你可以对一个单词进行如下三种操作：插入一个字符、删除一个字符、替换一个字符
       示例 1:
       输入: word1 = "horse", word2 = "ros"
       输出: 3
       解释:
       horse -> rorse (将 'h' 替换为 'r')
       rorse -> rose (删除 'r')
       rose -> ros (删除 'e')
 */

// 小规律：90% 的字符串问题都可以用动态规划解决，并且90%是采用二维数组

/*
 todo 步骤一、定义数组元素的含义
             我们的目的求将 word1 转换成 word2 所使用的最少操作数，定义dp[i][j]的含义为：
             当字符串word1的长度为i(取word1前i个字符），字符串word2的长度为j时（word2前j个字符），将word1转化为word2所使用的最少操作次数为dp[i][j]。
      步骤二：找出关系数组元素间的关系式
             这题的关系难找一点，但不管多难找，大部分情况下，dp[i][j]和dp[i-1][j]、dp[i][j-1]、dp[i-1][j-1]肯定存在某种关系。
             我们的目标就是，从规模小的，通过一些操作，推导出规模大的。对于这道题，我们可以对word1进行三种操作插入一个字符、删除一个字符、替换一个字符
             由于我们是要让操作的次数最小，所以我们要寻找最佳操作。那么有如下关系式：
             一、如果我们word1[i]与word2[j]相等，这个时候不需要进行任何操作，显然有dp[i][j]=dp[i-1][j-1]。
             二、如果我们word1[i]与word2 [j]不相等，这个时候我们就必须进行调整，而调整的操作有3种，我们要选择一种。三种操作对应的关系式如下（注意字符串与字符的区别）：
             （1）如果把字符word1[i]替换成与word2[j]相等，则有dp[i][j] = dp[i-1][j-1] + 1;
             （2）如果在字符串word1末尾插入一个与word2[j]相等的字符，则有dp[i][j] = dp[i][j-1] +1;
             （3）如果把字符word1[i]删除，则有dp[i][j]=dp[i-1][j] + 1;
             应该选择一种操作，使得 dp[i] [j] 的值最小，显然有
             dp[i][j] = min(dp[i-1][j-1]，dp[i][j-1]，dp[[i-1][j]]) + 1;
      步骤三、找出初始值
             由于下标不能为负，因此i-1和j-1不能为负，即i和j的值均应＞0。
             所以初始值即计算出所有的 dp[0][0….n-1] 和所有的 dp[0….m-1][0]
             当有一个字符串的长度为 0 时，转化为另外一个字符串，那就只能一直进行插入或者删除操作了
 */
public class EditDistance {
    public static int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        // dp[0][0...n2]的初始值
        for (int j = 1; j <= n2; j++)
            dp[0][j] = dp[0][j - 1] + 1;
        // dp[0...n1][0] 的初始值
        for (int i = 1; i <= n1; i++)
            dp[i][0] = dp[i - 1][0] + 1;
        // 通过公式推出 dp[n1][n2]
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                // 如果 word1[i]与word2[j]相等。第i个字符对应下标是i-1
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        int dis = minDistance("horse", "ros");
        System.out.println(dis);
    }
}
