package Sword_Finger_Offer;

/* TODO 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
        输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，
        数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 */

/* TODO 思路：
    中间元素和最后一个元素比较，
    如果中间元素小于最后一个元素，则一定是右边有序数组里的元素，且中间元素不确定是不是最小值，范围缩小为[low,mid],
    如果中间元素大于最后一个元素，则一定是左边数组中的元素，且中间元素一定不是最小值，范围缩小为[mid+1,high],
    如果中间元素等于最后一个元素，不能确定其是哪边数组的元素，范围缩小为[low,high-1]
 */
public class Min_11 {
    int Min(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (numbers[mid] < numbers[high]) {// 这说明numbers[mid]是最小值右侧的元素，因此我们可以忽略二分查找区间的右半部分。
                high = mid; // numbers[mid] < numbers[high]，不能确定numbers[mid]是不是最小值，不能跳过
            } else if (numbers[mid] > numbers[high]) { //明numbers[mid]是最小值左侧的元素，因此我们可以忽略二分查找区间的左半部分。
                low = mid + 1; // numbers[mid] > numbers[high]，说明numbers[mid]一定不是最小值，可以跳过
            } else { // numbers[mid] = numbers[high]，此时无论numbers[mid]是不是最小值，都有一个它的「替代品」numbers[mid]，因此我们可以忽略二分查找区间的右端点。
                high -= 1;
            }
        }
        return numbers[low];
    }

    public static void main(String[] args) {
        Min_11 solution = new Min_11();
        int[] arr = new int[]{1, 2, 1};
        System.out.println(solution.Min(arr));
    }
}
