# 387. First Unique Character in a String
## 题目
- Given a string s, return the first non-repeating character in it and return its index. If it does not exist, return -1.

> Input: s = "leetcode"  
> Output: 0

> Input: s = "loveleetcode"  
> Output: 2

> Input: s = "aabb"  
> Output: -1
## 解题思路
- 哈希表+两次遍历
- 用数组代替哈希表，效率更高
