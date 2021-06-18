package practice;

/*
 todo: 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。(每次只能向下或者向右移动一步)
       和机器人🤖1差不多，不过是算最优路径和，这是 leetcode 的第64题：https://leetcode-cn.com/problems/minimum-path-sum/
 */

import static java.lang.Math.min;

/*
 todo 步骤一、定义数组元素的含义
             由于我们的目的是从左上角到右下角，最小路径和是多少，那我们就定义dp[i][j]的含义为：
             当机器人从左上角走到(i,j)这个位置时，最小的路径和是dp[i][j]。那么，dp[m-1][n-1]就是我们要的答案了。
      步骤二：找出关系数组元素间的关系式
             机器人要怎么样才能到达 (i, j) 这个位置？由于机器人可以向下走或者向右走，所以有两种方式到达
                一种是从 (i-1,j) 这个位置走一步到达
                一种是从(i,j-1) 这个位置走一步到达
             不过这次不是计算所有可能路径，而是计算哪一个路径和是最小的，那么我们要从这两种方式中，选择一种，
             使得dp[i] [j] 的值是最小的，显然有dp[i][j] = min(dp[i-1][j]，dp[i][j-1])+arr[i][j]; //arr[i][j]表示网格种的值
      步骤三、找出初始值
             由于下标不能为负，因此i-1和j-1不能为负，即i和j的值均应＞0。
             所以初始值即计算出所有的 dp[0] [0….n-1] 和所有的 dp[0….m-1] [0]
             dp[0][j] = arr[0][j]+dp[0][j-1]; // 相当于最上面一行，机器人只能一直往左走,即只有一种方式，所以初值为1
             dp[i][0] = arr[i][0]+dp[i-1][0]; // 相当于最左面一列，机器人只能一直往下走
 */
public class MoveRobot_2 {
    public static int uniquePaths(int[][] arr) { // 网格为m行n列
        if (arr.length <= 0 || arr[0].length <= 0) return 0;
        int m = arr.length, n = arr[0].length;

        int[][] dp = new int[m][n];

        dp[0][0] = arr[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = arr[i][0] + dp[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = arr[0][j] + dp[0][j - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + arr[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        int ans = uniquePaths(arr);
        System.out.println(ans);
    }
}
