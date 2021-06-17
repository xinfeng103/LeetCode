
//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
// 示例 1：
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]

// 示例 2：
// 输入：matrix =[[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]

// 限制：
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100


package leetcode.editor.cn;

import java.util.Arrays;

public class ShunShiZhenDaYinJuZhenLcof {
    public static void main(String[] args) {
        int[][] matrix=new int[][]{
                {1,2,3},{4,5,6},{7,8,9}
        };
        Solution solution = new ShunShiZhenDaYinJuZhenLcof().new Solution();
        int[] ans = solution.spiralOrder(matrix);
        System.out.println(Arrays.toString(ans));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return new int[0];
            }

            int rows = matrix.length, columns = matrix[0].length;
            int[] res = new int[rows * columns];
            int index = 0;

            int dir = 1;
            int row = 0, col = 0;  // 当前元素坐标
            int top = 0, right = columns - 1, bottom = rows - 1, left = 0;  // 控制边界
            while (top <= bottom && left <= right) {
                res[index++] = matrix[row][col];
                switch (dir) {
                    case 1:
                        if (col == right) {
                            dir = 2;
                            top++;
                            row++;
                            continue;
                        }
                        col++;
                        break;
                    case 2:
                        if (row == bottom) {
                            dir = 3;
                            right--;
                            col--;
                            continue;
                        }
                        row++;
                        break;
                    case 3:
                        if (col == left) {
                            dir = 4;
                            bottom--;
                            row--;
                            continue;
                        }
                        col--;
                        break;
                    case 4:
                        if (row == top) {
                            dir = 1;
                            left++;
                            col++;
                            continue;
                        }
                        row--;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}