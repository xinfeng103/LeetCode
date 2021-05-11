package Sword_Finger_Offer;

// todo 5. 替换空格：实现一个函数，把字符数组arr（字符串）中的每个空格替换成"%20"。例如，输入：s = "We are happy."  输出："We%20are%20happy."

/* todo 分析：在要求空间复杂度为O(1)的情况下，正向替换会导致空格后面的字符多次被移动，时间复杂度为O(n^2)
             反向替换：先遍历一遍字符串，统计出字符串中空格的总数，替换后字符串的总长度为 原来的长度+2*空格数，复杂度为时间O(n)
             如果不要求空间复杂度，也可以创建一个数组用来保存替换后的字符串，正向遍历将原字符串复制到新串中，并进行空格的替换，时空复杂度都为O(n)


            TODO 相似题：两个有序数组A1和A2，A1末尾有足够的空间，合并A2到A1。
                        可以逆序将两个数组中较大的数依次复制到A1末尾

 */
class ReplaceSpace05 {
    public void replaceSpace(char[] arr, int n) {
        if (arr == null || n == 0) {
            return;
        }
        // arr 末尾有足够的空间，足以存放扩容后的字符串； n表示实际字符的长度（包括空格，不包括arr后面的空闲空间）
        int countSpace = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == ' ') {
                countSpace++;
            }
        }
        int p1 = n - 1, p2 = n + countSpace * 2 - 1;
        while (p1 != p2) {
            if (arr[p1] != ' ') {
                arr[p2--] = arr[p1--];
            } else {
                arr[p2--] = '0';
                arr[p2--] = '2';
                arr[p2--] = '%';
                p1--;
            }
        }
    }

    public static void main(String[] args) {
        ReplaceSpace05 replaceSpace = new ReplaceSpace05();
        char[] arr = {'w', 'e', ' ', 'a', 'r', 'e', ' ', 'h', 'a', 'p', 'p', 'y', ' ', ' ', ' ', ' '};
//        char [] arr = {' ',' ',' '};
        int n = 12;
        replaceSpace.replaceSpace(arr, n);
        System.out.println(arr);
    }
}
