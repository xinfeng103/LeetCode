package sortAndSearch.sortPractice_2;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partation(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    static int partation(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) high--;
            arr[low] = arr[high];//从后面开始找到第一个小于pivot的元素，放到low位置
            while (low < high && arr[low] <= pivot) low++;
            arr[high] = arr[low];//从前面开始找到第一个大于pivot的元素，放到high位置
        }
        arr[low] = pivot;
        return low;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 4, 6, 5, 1};
        System.out.println("排序前" + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后" + Arrays.toString(arr));
    }
}
