//请完成一个函数，输入一个二叉树，该函数输出它的镜像。 
//
// 例如输入： 
//
//   4
//  /  \
//  2   7
// / \ / \ 
// 1 3 6  9
//镜像输出： 
//
//    4
//   / \
//  7   2
// / \ / \ 
// 9 6 3 1
//
// 
//
// 示例 1： 
//
// 输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]


package leetcode.editor.cn;

import java.util.Stack;

public class ErChaShuDeJingXiangLcof{
    public static void main(String[] args){
        Solution solution = new ErChaShuDeJingXiangLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
// Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
        // 1. 递归
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftRoot = mirrorTree(root.right);
        TreeNode rightRoot = mirrorTree(root.left);
        root.left = leftRoot;
        root.right = rightRoot;
        return root;
    }


    // 辅助栈（或队列，此处用的是栈）
//    public TreeNode mirrorTree(TreeNode root) {
//        if(root==null){
//            return null;
//        }
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        while (!stack.empty()){
//            TreeNode node = stack.pop();
//            // 交换当前节点的左右子树
//            TreeNode tmp = node.left;
//            node.left=node.right;
//            node.right=tmp;
//            // 将当前节点的孩子节点入栈
//            if(node.left!=null) stack.push(node.left);
//            if(node.right!=null) stack.push(node.right);
//        }
//        return root;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}