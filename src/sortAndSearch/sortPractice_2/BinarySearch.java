package sortAndSearch.sortPractice_2;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1, mid;
        while (low <= high) {
            mid = high - ((high - low) >> 1);
            if (target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 6, 8, 9, 22};
        int target = 8;
        int index = binarySearch(arr, target);
        System.out.println(index);
    }
}
