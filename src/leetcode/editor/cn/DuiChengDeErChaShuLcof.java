//请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//    1
//   / \
//  2   2
// / \ / \ 
// 3 4 4 3
//但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//   1
//  / \
//  2 2
//  \ \
//  3 3
//
// 
//
// 示例 1： 
//
// 输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
//
// 输入：root = [1,2,2,null,3,null,3]
//输出：false 


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class DuiChengDeErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new DuiChengDeErChaShuLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
// Definition for a binary tree node.
//    public class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode(int x) {
//            val = x;
//        }
//    }

    /*
    本题考查的是二叉树的递归。
    递归判断两个子树是否互为镜像。
    两个子树互为镜像当且仅当：
    1.两个子树的根节点值相等；
    2.第一棵子树的左子树和第二棵子树的右子树互为镜像，且第一棵子树的右子树和第二棵子树的左子树互为镜像；
     */
    class Solution {
        // 1. 递归
        public boolean isSymmetric(TreeNode root) {
            return root == null ? true : recur(root.left, root.right);
        }

        boolean recur(TreeNode L, TreeNode R) {
            if (L == null && R == null) return true;
            if (L == null || R == null || L.val != R.val) return false;
            return recur(L.left, R.right) && recur(L.right, R.left);
        }

        // 2. 队列辅助，迭代
//        public boolean isSymmetric(TreeNode root) {
//            if(root==null) return true;
//            Queue<TreeNode> queue = new LinkedList<>();
//            queue.offer(root.left);
//            queue.offer(root.right);
//
//            while (!queue.isEmpty()){
//                TreeNode t1 = queue.poll();
//                TreeNode t2 = queue.poll();
//
//                if(t1==null && t2==null) continue;
//                if(t1==null || t2 ==null ) return false;
//                if(t1.val != t2.val) return false;
//
//                queue.offer(t1.left);
//                queue.offer(t2.right);
//
//                queue.offer(t1.right);
//                queue.offer(t2.left);
//            }
//            return true;
//        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}