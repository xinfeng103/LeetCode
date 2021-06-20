package sort;

import java.util.Arrays;

public class MergeSort {
    public static int[] mergeSort(int[] nums, int low, int high) {
        if (low == high)
            return new int[]{nums[low]};

        int mid = low + (high - low) / 2;
        int[] leftArr = mergeSort(nums, low, mid); //左有序数组
        int[] rightArr = mergeSort(nums, mid + 1, high); //右有序数组
        int[] newNum = new int[leftArr.length + rightArr.length]; //新有序数组

        int k = 0, i = 0, j = 0;
        while (i < leftArr.length && j < rightArr.length) {
            newNum[k++] = leftArr[i] < rightArr[j] ? leftArr[i++] : rightArr[j++];
        }
        while (i < leftArr.length)
            newNum[k++] = leftArr[i++];
        while (j < rightArr.length)
            newNum[k++] = rightArr[j++];
        return newNum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 6, 5};
        System.out.println("排序前" + Arrays.toString(arr));
        int[] ans = mergeSort(arr, 0, arr.length - 1);
        System.out.println("排序后" + Arrays.toString(ans));
    }
}
