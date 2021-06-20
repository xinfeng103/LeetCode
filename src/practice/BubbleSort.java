package practice;

import sort.QuickSort;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = n - 1; i > 0; i--) {
            boolean isExchange = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    isExchange = true;
                }
            }
            if (!isExchange) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9, 6, 5, 3, 2, 1};
        System.out.println("排序前" + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("排序后" + Arrays.toString(arr));
    }
}
