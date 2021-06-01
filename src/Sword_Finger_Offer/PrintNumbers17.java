package Sword_Finger_Offer;

//输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
// 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

/*
TODO 本题的主要考点是大数越界情况下的打印。需要解决以下三个问题：
   - 无论是 short / int / long ... 任意变量类型，数字的取值范围都是有限的。因此，大数的表示应用字符串 String 类型
   - 像int类型那样直接+1操作复杂且效率低，观察可知生成的列表实际上n位0-9的全排列，可通过递归生成数字的 String 列表。
   - 基于分治算法的思想，先固定高位，向低位递归，当个位已被固定时，添加数字的字符串。
     例如当 n=2 时（数字范围 1−99 ），固定十位为 0 - 9 ，按顺序依次开启递归，固定个位
     0 - 9 ，终止递归并添加数字字符串。
 */
public class PrintNumbers17 {
    static class Solution{
        StringBuilder res;
        int nine = 0, start, n;
        char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        public String printNumbers(int n) {
            this.n = n;
            res = new StringBuilder(); // 数字集字符串
            num = new char[n]; // 定义长度为 n 的字符列表, 保存当前数字
            start = n - 1;
            dfs(0); // 开启全排列递归
            res.deleteCharAt(res.length() - 1); // 删除最后多余的逗号
            return res.toString(); // 转化为字符串并返回
        }
        void dfs(int x) {
            if(x == n) { // 终止条件：已固定完所有位
                String s = String.valueOf(num).substring(start);
                if(!s.equals("0")) res.append(s + ",");
                if(n - start == nine) start--;
                return;
            }
            for(char i : loop) { // 遍历 ‘0‘ - ’9‘
                if(i == '9') nine++;
                num[x] = i; // 固定第 x 位为 i
                dfs(x + 1); // 开启固定第 x + 1 位
            }
            nine--;
        }

    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String ans = solution.printNumbers(2);
        System.out.println(ans);
    }
}


