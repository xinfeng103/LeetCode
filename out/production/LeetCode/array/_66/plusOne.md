# 66. Plus One
## 题目
- Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.

- The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.

- You may assume the integer does not contain any leading zero, except the number 0 itself.


>Input: digits = [1,2,3]  
>Output: [1,2,4]

>Input: digits = [4,3,2,1]  
>Output: [4,3,2,2]

## 解题思路
- 只要+1求余数，余数不等于0，说明没有进位，直接返回。如果余数等于0，说明有进位，遍历前一个数字，加1再求余数，以此循环。
- 如果for循环都遍历完了，说明最高位也有进位，则重新建立一个数组，初始化为0，将第一位设置为1就可以了，因为，99、999之类的数字加一为100、1000
