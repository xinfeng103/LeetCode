package search;

import java.util.Arrays;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        if (arr.length == 0) return -1;
        int low = 0, high = arr.length - 1, mid;
        while (low < high) {
            mid = high - ((high - low) >> 1);
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -low;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 5, 6, 8, 9};
        int index = binarySearch(arr, 5);
        System.out.println(index);
    }
}
