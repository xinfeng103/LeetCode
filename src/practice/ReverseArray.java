package practice;

import java.util.Arrays;

public class ReverseArray {
    public static void reverse(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int tmp = arr[low];
        arr[low] = arr[high];
        arr[high] = tmp;
        reverse(arr, ++low, --high);
    }

    public static void main(String[] args) {
        int[] arr = null;
        System.out.println("反转前" + Arrays.toString(arr));
        if (arr == null) {
            System.out.println("数组为null");
            return;
        }
        int low = 0, high = arr.length - 1;
        reverse(arr, low, high);
        System.out.println("反转后" + Arrays.toString(arr));
    }
}
