package Sword_Finger_Offer;
/* todo 4. 二维数组中的查找：
    在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下
    递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */

/* todo 分析：选取数组右上角的数字，如果该数字等于要查找的数字，则查找过程结束；
             如果该数字大于要查找的数字，则剔除这个数字所在的列；
             如果该数字小于要查找的数字，则剔除这个数字所在的行。

 */
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            int cur = matrix[row][col];
            if (cur == target) {
                return true;
            } else if (cur > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        int target = 20;
        boolean ans = solution.findNumberIn2DArray(matrix, target);
        System.out.println(ans);
    }
}


