# 80. Remove Duplicates from Sorted Array II
## 题目
- Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.


>Input: nums = [1,1,1,2,2,3]
>Output: length = 5, nums = [1,1,2,2,3] 

>Input: nums = [0,0,1,1,1,1,2,3,3]
>Output: length = 7, nums = [0,0,1,1,2,3,3]
## 解题思路
26题的升级版，由于题目要求至多两个重复值，且数组有序，因此只要当前值
与上上一个元素的值不相等即可添加到结果数组，注意k的初始值应改为1