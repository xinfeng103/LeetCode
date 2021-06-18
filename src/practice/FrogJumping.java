package practice;

/*
 todo: 问题： ⼀只⻘青蛙⼀次可以跳上1级台阶，也可以跳上2级。求该⻘青蛙跳上⼀个n级的台阶总共有多少种跳法？
 */

/*
 todo:解题思路
      1.第一步先找这个函数与下一个函数之间的关系：
      假如有n个台阶，跳上一个n级的台阶的跳法总数为f(n).我们在跳的过程中，每一次有两种跳法，即跳一个或两个台阶。
        第一种跳法：第一次我跳了一个台阶，那么还剩下n-1个台阶还没跳，剩下的n-1个台阶的跳法有f(n-1)种。
        第二种跳法：第一次跳了两个台阶，那么还剩下n-2个台阶还没，剩下的n-2个台阶的跳法有f(n-2)种。
      由此不难得出递归公式：f(n) = (n-1) + f(n-2);
      2.第二步，找出递归的结束条件
      当n <= 0时，跳法为0，即此时f(n) = 0
      当只剩下一个台阶n = 1时，那么只有一种跳法，即f(1) = 1;
      当n = 2时，此时跳法为2种，即f(2) = 2;
 */
public class FrogJumping {
    public int solve(int n) {
        if (n <= 2) return n;
        int f1 = 1, f2 = 2, sum = 0;
        for (; n > 2; n--) {
            sum = f1 + f2;
            f1 = f2;
            f2 = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 5;
        FrogJumping solution = new FrogJumping();
        int ans = solution.solve(n);
        System.out.println(ans);
    }
}
