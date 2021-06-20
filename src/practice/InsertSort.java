package practice;

import java.util.Arrays;

public class InsertSort {
    public static void insertSort(int[] arr) {
        int n = arr.length;
        int i, j, cur;
        for (i = 1; i < n; i++) {
            cur = arr[i];
            j = i - 1;
            while (j >= 0 && arr[j] > cur) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = cur;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 9, 2, 1};
        System.out.println("排序前" + Arrays.toString(arr));
        insertSort(arr);
        System.out.println("排序后" + Arrays.toString(arr));
    }
}
