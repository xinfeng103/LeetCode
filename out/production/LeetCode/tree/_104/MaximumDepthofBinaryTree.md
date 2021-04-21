# 104. Maximum Depth of Binary Tree

## 题目

- 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。


## 解题思路

- 递归。
  - node=null , return 0
  - 否则，return max(左子树深度，右子树深度)+1