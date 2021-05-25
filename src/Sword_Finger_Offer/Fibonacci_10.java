package Sword_Finger_Offer;

// TODO 裴波那契数列,(n>0)
public class Fibonacci_10 {
    public long fibonacci(int n) {
        if (n < 2) {
            return n;
        }
        int a = 1, b = 1;
        for (; n > 2; n--) {
            b = b + a; // 和可能会超过long类型的最大值，是否处理看题目要求
            a = b - a;
        }
        return b;
    }

    public long fibonacci1(int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    public static void main(String[] args) {
        Fibonacci_10 solution = new Fibonacci_10();
        for (int i = 0; i < 50; i++) {
            System.out.println(solution.fibonacci(i));
            System.out.println(solution.fibonacci1(i));
            System.out.println();
        }
    }
}
