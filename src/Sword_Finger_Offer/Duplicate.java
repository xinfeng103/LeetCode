package Sword_Finger_Offer;

// 3. 数组中重复的数字

class Duplicate {
    // 题目一. 如果数组中有重复数字返回true，否则返回false。

    // 方法1 哈希表
    public boolean isDuplicate(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return false;
        }
        var dict = new boolean[n];
        for (int val : arr) {
            if (!dict[val]) {
                dict[val] = true;
            } else {
                return true;
            }
        }
        return false;
    }

    // 方法2 原地哈希
    // 如果数组中没有重复的数字，排序后数字i将出现在下标为i的位置，遍历数组，用交换的方式将数字放到正确的位置
    public boolean isDuplicate2(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            int curVal = arr[i];
            while (curVal != i) {
                if (curVal == arr[curVal]) {
                    return true;
                } else {
                    arr[i] = arr[curVal];
                    arr[curVal] = curVal;
                    curVal = arr[i];
                }
            }
        }
        return false;
    }

    // 用原地哈希的方法时间复杂度为O(n)，空间复杂度为O(1)，可以找出一个重复数字就返回，也可以找到所有重复数字
    // 除此之外，还可以用排序，哈希，计数，集合等方法
    public static void main(String[] args) {
        Duplicate duplicate = new Duplicate();
        int[] arr = new int[]{2, 3, 1, 0, 2};
        System.out.println(duplicate.isDuplicate2(arr));
    }
}
