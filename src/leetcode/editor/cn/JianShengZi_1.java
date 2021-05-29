
/*给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每
段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是
多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18.
 */

// 示例 1：
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1

// 示例 2:
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 ×3 × 4 = 36

// 提示：
// 2 <= n <= 58


/* TODO 分析：问题目标是求解各段绳子长度乘积的最大值，也就是求解一个问题的最优解【满足动态对话的条件之一】
             假设第一刀剪在长度为i的位置，于是把绳子剪成了长度分别为i和n-i两段。
             用同样的方法把长度为i和n-i的两段分别剪成若干段，使各自的乘积最大。
             【整体问题的最优解依赖各子问题的最优解，满足动态规划求解问题的第二个特点】
             【特点3：把大问题分解成若干小问题，这些小问题之间还要相互重叠的更小的子问题】
             【由于子问题在分解大问题的过程中重复出现，为了避免重复求解子问题，可以从下往上
             先计算小问题的最优解并存储下来，再以此为基础求取大问题的最优解。从上往下分析问题，
             从下往上求解问题，是动态规划求解问题的第4个特点】
 */

package leetcode.editor.cn;
public class JianShengZi_1 {
    public static void main(String[] args){
        Solution solution = new JianShengZi_1().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int cuttingRope(int n) {
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}