# 461. 汉明距离
## 题目
两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
给出两个整数 x 和 y，计算它们之间的汉明距离。

## 解题思路
- 异或记为xor，得到的结果即两个数不同位的个数
- 统计xor中1的个数