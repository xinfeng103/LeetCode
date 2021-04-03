# 7. Reverse Integer

## 题目

- Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the
  signed 32-bit integer range [-231, 231 - 1], then return 0.

- Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

> Input: x = 123  
> Output: 321

> Input: x = -123  
> Output: -321

> Input: x = 120  
> Output: 21

> Input: x = 0  
> Output: 0

## 解题思路

- 123=(((1*10)+2)*10)+3   
  -->    
  321=(((3*10)+2)*10)+1  
  - 设翻转后的数字为revNum
  - 循环将原数除以10，并记录余数
  - revNum=revNum*10+余数(参照上面两个数字理解)
