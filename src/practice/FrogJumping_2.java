package practice;

/*
 todo: 问题：一只青蛙一次可以跳上1级台阶，也可以跳上2级…也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
       分析：这道题青蛙跳台_1是一样的，只是本来每次跳有两种选择，现在有n中选择，即f(n) = f(n-1) + f(n - 2) + f(n-3)+.....+f(1);
 */

public class FrogJumping_2 {
    public static int solve(int n) {
        if (n <= 3) return n;
        int[] map = new int[n + 1];
        map[1] = 1;
        map[2] = 2;
        map[3] = map[1] + map[2] + 1;
        for (int i = 4; i <= n; i++) {
            map[i] = map[i - 1] << 1;
        }
        return map[n];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            int ans = solve(i);
            System.out.println(ans);
        }
    }
}
