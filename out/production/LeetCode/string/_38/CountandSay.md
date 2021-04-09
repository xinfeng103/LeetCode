# 38. Count and Say-外观数列

## 题目

- 给定一个正整数 n ，输出外观数列的第 n 项。  
>- 输入->   输出
>- 1->     1  
>- 2->     11  
>- 3->     21  
>- 4->    1211  
>- 5->     111221  

>- 第一项是数字 1  
>- 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"  
>- 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"  
>- 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"  
>- 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"  

## 解题思路

- 遍历
  - 重复数字则计数
  - 否则将该数字的个数和该数字存入结果串中，重置计数器