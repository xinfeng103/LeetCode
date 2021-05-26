package Sword_Finger_Offer;

/* TODO 12. 矩阵中的路径：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
            路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
            如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
            例如 a b c e
                s f c s
                a d e e 这样的3 X 4 矩阵中包含一条字符串”bcced”的路径，但是矩阵中不包含”abcb”路径，
            因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
    */

/* TODO 解题思路:  回溯法：
    1. 将matrix字符串映射为一个字符矩阵（index = i * cols + j）
    2. 遍历matrix的每个坐标，与str的首个字符对比，如果相同，用flag做标记，
    matrix的坐标分别上、下、左、右移动（判断是否出界或者之前已经走过[flag的坐标为1]），
    再和str的下一个坐标相比，直到str全部对比完，即找到路径，否则找不到。
    */


public class Problem12 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix.length == 0 || str.length == 0)
            return false;
        int[][] flag = new int[rows][cols];

        // 遍历每一个字符，判断从当前字符开始能否找到符合条件的路径
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (search(matrix, rows, cols, i, j, str, 0, flag))
                    return true;
            }
        }
        return false;
    }

    public boolean search(char[] matrix, int rows, int cols,
                          int i, int j, char[] str, int index, int[][] flag) {
        // 将矩阵坐标转换为matrix的索引，以获取matrix中的元素
        int matrixIndex = i * cols + j;

        // 越界，或当前字符已被标记（不可重复使用），或当前字符与str即待匹配串中的相应字符不相等，均返回false
        if (i < 0 || j < 0 || i >= rows || j >= cols || flag[i][j] == 1 || matrix[matrixIndex] != str[index])
            return false;

        // 已检索完所有字符，即找到了路径
        if (index >= str.length - 1)
            return true;

        // 标记当前字符为已访问
        flag[i][j] = 1;

        // 标记当前字符后，继续递归判断str中的下一个字符，如果找到路径返回true；
        if (search(matrix, rows, cols, i + 1, j, str, index + 1, flag) ||
                search(matrix, rows, cols, i - 1, j, str, index + 1, flag) ||
                search(matrix, rows, cols, i, j + 1, str, index + 1, flag) ||
                search(matrix, rows, cols, i, j - 1, str, index + 1, flag))
            return true;
        // 否则matrix中当前字符标志修改为未访问
        flag[i][j] = 0;
        return false;
    }

    public static void main(String[] args) {
        Problem12 solution = new Problem12();
        char[] matrix = new char[]{
                'a', 'b', 'c', 'e',
                's', 'f', 'c', 's',
                'a', 'd', 'e', 'e'
        };
        if (solution.hasPath(matrix, 3, 4, new char[]{'b', 'c', 'c', 'e', 'd'})){
            System.out.println("存在路径");
        }else {
            System.out.println("不存在路径");
        }
    }
}
