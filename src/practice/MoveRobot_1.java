package practice;

/*
 todo: 问题：一个机器人位于一个 m x n 网格的左上角，机器人每次只能向下或者向右移动一步。
            机器人试图达到网格的右下角。问总共有多少条不同的路径？
            这是 leetcode 的 62 号题：https://leetcode-cn.com/problems/unique-paths/
 */

/*
 todo 步骤一、定义数组元素的含义
             由于我们的目的是从左上角到右下角一共有多少种路径，那我们就定义dp[i][j]的含义为：
             当机器人从左上角走到(i,j)这个位置时，一共有dp[i][j]种路径。那么，dp[m-1][n-1]就是我们要的答案了。
      步骤二：找出关系数组元素间的关系式
             机器人要怎么样才能到达 (i, j) 这个位置？由于机器人可以向下走或者向右走，所以有两种方式到达
                一种是从 (i-1,j) 这个位置走一步到达
                一种是从(i,j-1) 这个位置走一步到达
             因为是计算所有可能的步骤，所以是把所有可能走的路径都加起来，所以关系式是dp[i][j]=dp[i-1][j]+dp[i][j-1]。
      步骤三、找出初始值
             由于下标不能为负，因此i-1和j-1不能为负，即i和j的值均应＞0。
             所以初始值即计算出所有的 dp[0] [0….n-1] 和所有的 dp[0….m-1] [0]
             dp[0] [0….n-1] = 1; // 相当于最上面一行，机器人只能一直往左走,即只有一种方式，所以初值为1
             dp[0…m-1] [0] = 1; // 相当于最左面一列，机器人只能一直往下走
 */
public class MoveRobot_1 {
    public static int uniquePaths(int m, int n) { // 网格为m行n列
        if (m <= 0 || n <= 0) return 0;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int ans = uniquePaths(3, 3);
        System.out.println(ans);
    }
}
