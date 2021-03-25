# 189. Rotate Array
## 题目
- Given an array, rotate the array to the right by k steps, where k is non-negative.
  * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
  * Could you do it in-place with O(1) extra space?
   

>Input: nums = [1,2,3,4,5,6,7], k = 3
>Output: [5,6,7,1,2,3,4]

>Input: nums = [-1,-100,3,99], k = 2
>Output: [3,99,-1,-100]

## 解题思路
- 环装替换
   * 题解
     https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-yuan-di-huan-wei-xiang-xi-tu-jie/
- 数组翻转
  * 先翻转整个数组
  * 翻转前k个元素
  * 翻转后面的元素
- 使用额外的数组