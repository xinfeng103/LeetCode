package sort;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = partition(arr, low, high);
            quickSort(arr, low, mid - 1);
            quickSort(arr, mid + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];//选第一个元素作为枢纽元
        while (low < high) {
            while (low < high && arr[high] >= pivot) high--;
            arr[low] = arr[high];//从后面开始找到第一个小于pivot的元素，放到low位置
            while (low < high && arr[low] <= pivot) low++;
            arr[high] = arr[low];//从前面开始找到第一个大于pivot的元素，放到high位置
        }
        arr[low] = pivot;//最后枢纽元放到low的位置(high也可以，最后low=high）
        return low;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        System.out.println("排序前" + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后" + Arrays.toString(arr));
    }
}
