# 27. Remove Element
## 题目
- Given an array nums and a value val, remove all instances of that value in-place and return the new length.
- The order of elements can be changed. It doesn't matter what you leave beyond the new length.

>Input: nums = [3,2,2,3], val = 3   
>Output: length = 2, nums = [2,2] 

> Input: nums = [0,1,2,2,3,0,4,2], val = 2  
>Output: length = 5, nums = [0,1,4,0,3]
## 解题思路
把不等于val的元素都重新从头安排，此题与283题Move Zeroes基本相同