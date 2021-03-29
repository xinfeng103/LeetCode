# 136. Single Number
## 题目
- Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

>Input: nums = [2,2,1]
>Output: 1

>Input: nums = [4,1,2,1,2]
>Output: 4

>Input: nums = [1]
>Output: 1

## 解题思路
- 去重，去重后的累加和乘以2，减去去重前的累加和
- 使用集合存储数字。遍历数组中的每个数字，如果集合中没有该数字，则将该数字加入集合，如果集合中已经有该数字，则将该数字从集合中删除，最后剩下的数字就是只出现一次的数字。
- 使用哈希表计数，然后遍历
- 位运算，遍历，逐个按位异或，2^2=0，1^2=1
