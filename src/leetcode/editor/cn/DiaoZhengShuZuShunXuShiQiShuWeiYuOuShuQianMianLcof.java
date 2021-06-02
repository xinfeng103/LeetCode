
//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，
// 所有偶数位于数组的后半部分。

// 示例：
//输入：nums =[1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 

// 0 <= nums.length <= 50000 
// 1 <= nums[i] <= 10000 


package leetcode.editor.cn;

public class DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof {
    public static void main(String[] args) {
        Solution solution = new DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] exchange(int[] nums) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                if ((nums[left] & 1) != 0) {
                    left ++;
                    continue;
                }
                if ((nums[right] & 1) != 1) {
                    right --;
                    continue;
                }
                int tmp = nums[left];
                nums[left]=nums[right];
                nums[right]=tmp;
                left++;right--;
            }
            return nums;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}