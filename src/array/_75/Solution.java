package array._75;

import java.util.Arrays;

class Solution {
    public void sortColors(int[] nums) {
        int p0 = 0, p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int tmp = nums[p0];
                nums[p0] = nums[i];
                nums[i] = tmp;
                if (nums[i] == 1) {  //或 if (p0 < p1)
                    tmp = nums[p1];
                    nums[p1] = nums[i];
                    nums[i] = tmp;
                }
                p1++;
                p0++;
            } else if (nums[i] == 1) {
                int tmp = nums[p1];
                nums[p1] = nums[i];
                nums[i] = tmp;
                p1++;
            }
        }
    }

    public void sortColors1(int[] nums) {
        int n = nums.length;

        int lt = -1;
        int gt = n;
        int i = 0;

        while (i < gt) {
            if (nums[i] == 0) {
                lt += 1;
                int tmp = nums[lt];
                nums[lt] = nums[i];
                nums[i] = tmp;
                i += 1;
            } else if (nums[i] == 2) {
                gt -= 1;
                int tmp = nums[gt];
                nums[gt] = nums[i];
                nums[i] = tmp;
            } else {
                i += 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        Solution solution = new Solution();
        solution.sortColors1(nums);
        System.out.println("修改后的数组为:" + Arrays.toString(nums));

    }
}
