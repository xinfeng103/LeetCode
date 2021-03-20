# 75. Sort Colors
## 题目
- Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
- We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

>Input: nums = [2,0,2,1,1,0]
>Output: [0,0,1,1,2,2]

>Input: nums = [2,0,1]
>Output: [0,1,2]

> Input: nums = [0]
>Output: [0]

> Input: nums = [1]
>Output: [1]

## 解题思路
- 方法一：单指针，两次遍历。
  * 在第一次遍历中，将数组中所有的 0 交换到数组的头部。 
  * 在第二次遍历中，将数组中所有的 1 交换到头部的 0 之后。
  * 此时，所有的 2 都出现在数组的尾部，排完成序。
- 方法二：双指针，两次遍历。
  * 用指针p0交换 0 ，指针p1交换 1 ，初始值都为0.
  * 遍历nums，
  * 如果nums[i]=0，nums[i]与p0交换，（nums[i]=1，交换）,p1++,p0++，i不变
    + 两种情况
    + 第一，比较前p0=p1，p0交换后，p0++，p1++
    + 第二，比较前p0<p1，p0指向的位置值一定为1，交换后nums[i]一定为1，因此再执行p1与nums[i]交换，交换后p1+1
  * 如果nums[i]=1，nums[i]与p0交换，p1++，i++
  * 如果nums[i]=2，i++
- 方法三：三路快速排序法
  * 设置三个 lt, gt, i 定义：nums[0...lt-1] == 0，nums[lt...gt-1] = 1，nums[gt...n-1] == 2，遍历一遍改数列保持这个定义。

    