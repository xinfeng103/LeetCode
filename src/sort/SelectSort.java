package sort;

import java.util.Arrays;

public class SelectSort {
    public static void selectSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) min = j;
            }
            if (min != i) {
                int tmp = arr[min];
                arr[min] = arr[i];
                arr[i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        System.out.println("排序前" + Arrays.toString(arr));
        selectSort(arr);
        System.out.println("排序后" + Arrays.toString(arr));
    }
}
