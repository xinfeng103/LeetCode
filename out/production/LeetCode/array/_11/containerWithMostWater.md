# 11. Container With Most Water
## 题目
- Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
- Notice that you may not slant the container.


>Input: height = [1,8,6,2,5,4,8,3,7]
>Output: 49
>![img.png](img.png)
 
> Input: height = [1,1]
>Output: 1
 
> Input: height = [4,3,2,1,4]
>Output: 16
 
> Input: height = [1,2,1]
>Output: 2

## 解题思路
- 双指针[对撞指针]