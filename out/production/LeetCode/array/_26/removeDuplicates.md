# 26. Remove Duplicates from Sorted Array
## 题目
- Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.  


>Input: nums = [1,1,2]
>Output: length = 2, nums = [1,2] 

>Input: nums = [0,0,1,1,1,2,2,3,3,4]
>Output: length = 5, nums = [0,1,2,3,4]
## 解题思路
变量k保存最后一个不重复值的下标，遍历数组nums，如果当前值
不等于nums[k]，将当前值添加到不重复元组中，最后k指向
最后一个不重复值，k+1即元组个数。本题与27，283类似，这几题
都是用一个变量k保存最后一个符合条件的值的下标，然后根据所给条件遍历数组。