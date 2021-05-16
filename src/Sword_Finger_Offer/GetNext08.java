package Sword_Finger_Offer;

import com.sun.source.tree.Tree;

/*
TODO 题目：给定一棵二叉树和其中一个节点，如何找出中序遍历序列的下一个节点？
 树中的节点除了有两个分别指向左、右节点的指针，还有一个节点指向父节点的指针。
 */
public class GetNext08 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode father;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode getNext(TreeNode pNode){
        if (pNode==null){
            return null;
        }
        // 右节点不为空
        if(pNode.right!=null){
            pNode=pNode.right;
            while ((pNode.left!=null)){
                pNode=pNode.left;
            }
            return pNode;
        }

        // 右节点为空，父节点不为空
        while (pNode.father!=null){
            // 是左孩子则返回父节点
            if(pNode.father.left==pNode){
                return pNode.father;
            }
            // 非左孩子，向上找父节点，重复此过程
            pNode=pNode.father;
        }
        // 其他情况返回null
        return null;
    }
}

