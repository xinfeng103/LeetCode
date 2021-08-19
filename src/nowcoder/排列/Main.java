package nowcoder.排列;

import java.util.Arrays;
import java.util.Scanner;

// 给定长度为 m 的序列 T ,求一个长度为 n 且字典序最小的排列.并且要求序列 T 为所求排列的子序列.题目保证这样的排列一定存在.
//S 是 T 的子序列,当且仅当 S 是 T 通过删除任意数量元素所得到的.
//字典序是单词在字典中的排列顺序，先比较第一个字母，然后比较第二个字母，依次类推。
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] T = new int[m];
        int[] dict = new int[n + 1];
        int[] remainder = new int[n - m];
        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            T[i] = num;
            dict[num] = 1;
        }
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (dict[i] == 0) {
                remainder[index++] = i;
            }
        }
        int[] ans = new int[n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n - m) {
            if (T[i] < remainder[j]) {
                ans[k++] = T[i++];
            } else {
                ans[k++] = remainder[j++];
            }
        }
        while (i < m) {
            ans[k++] = T[i++];
        }
        while (j < n - m) {
            ans[k++] = remainder[j++];
        }
        for (int val : ans) {
            System.out.print(val + " ");
        }
    }
}
