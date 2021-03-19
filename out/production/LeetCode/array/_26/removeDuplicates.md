# 26. Remove Duplicates from Sorted Array
## 题目
- Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.  
- The order of elements can be changed. It doesn't matter what you leave beyond the new length.

>Input: nums = [1,1,2]
>Output: length = 2, nums = [1,2] 

>Input: nums = [0,0,1,1,1,2,2,3,3,4]
>Output: length = 5, nums = [0,1,2,3,4]
## 解题思路
把不等于val的元素都重新从头安排，此题与283题Move Zeroes基本相同