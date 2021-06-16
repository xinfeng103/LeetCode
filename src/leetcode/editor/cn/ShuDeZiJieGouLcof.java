
//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
// B是A的子结构， 即 A中有出现和B相同的结构和节点值。
// 例如: 
//给定的树 A:
//  3
// / \ 
// 4 5 
// / \ 
// 1 2 
//给定的树 B：
//  4
// / 
// 1 
//返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。 

// 示例 1：
// 输入：A = [1,2,3], B = [3,1]
//输出：false

// 示例 2：
// 输入：A = [3,4,5,1,2], B = [4,1]
//输出：true


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ShuDeZiJieGouLcof {
    public static void main(String[] args) {
        Solution solution = new ShuDeZiJieGouLcof().new Solution();
        TreeNode treeNodeA = new TreeNode(1);
        treeNodeA.left = new TreeNode(0);
        treeNodeA.right = new TreeNode(1);
        treeNodeA.left.left=new TreeNode(-4);
        treeNodeA.left.right=new TreeNode(-3);
        TreeNode treeNodeB = new TreeNode(1);
        treeNodeB.left = new TreeNode(-4);
        solution.isSubStructure(treeNodeA, treeNodeB);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
// Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
        }
        boolean recur(TreeNode A, TreeNode B) {
            if(B == null) return true;
            if(A == null || A.val != B.val) return false;
            return recur(A.left, B.left) && recur(A.right, B.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}