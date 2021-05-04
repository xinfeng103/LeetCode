package math._46;

//46. 计数质数

class Solution {
    /*
    申请一个长度为length的数组用来存储对应的数是不是素数。
    用一个变量count来统计素数的个数，如果是合数就不需要统计，
    如果是素数，count加1，然后再把这个素数的2倍，3倍……都标记为非素数
     */
    public int countPrimes(int n) {
        boolean[] notPrimes = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            //如果不是素数就不需要统计
            if (notPrimes[i])
                continue;
            count++;
            //到这一步说明当前值是素数，需要将他的2倍，3倍……都标记为非素数
            for (int j = i * 2; j < n; j += i)
                notPrimes[j] = true;
        }
        return count;
    }

    //暴力解法
    public int countPrimes1(int n) {
        if (n < 3) {
            return 0;
        }
        int count = 1;
        for (int i = 3; i < n; i+=2) {
            count += isPrimes(i) ? 1 : 0;
        }
        return count;
    }

    public boolean isPrimes(int n) {
        for (int i = 3; i <= Math.sqrt(n); i+=2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int ans = solution.countPrimes(10);
        System.out.println(ans);
    }
}
