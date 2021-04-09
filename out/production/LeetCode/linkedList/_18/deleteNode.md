# 剑指 Offer 18. 删除链表的节点

## 题目

- 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。返回删除后的链表的头节点。

> 输入: head = [4,5,1,9], val = 5
> 输出: [4,1,9]

> 输入: head = [4,5,1,9], val = 1
> 输出: [4,5,9]

## 解题思路

- 定位节点： 遍历链表，直到 head.val == val 时跳出，即可定位目标节点。
- 修改引用： 设节点 cur 的前驱节点为 pre ，后继节点为 cur.next ；则执行 pre.next = cur.next ，即可实现删除 cur 节点。
  - 特例处理： 当应删除头节点 head 时，直接返回 head.next 即可。
  - 初始化： pre = head , cur = head.next 。
  - 定位节点： 当 cur 为空 或 cur 节点值等于 val 时跳出。
    - 保存当前节点索引，即 pre = cur 。
    - 遍历下一节点，即 cur = cur.next 。
  - 删除节点： 若 cur 指向某节点，则执行 pre.next = cur.next ；若 cur 指向null ，代表链表中不包含值为 val 的节点。
  - 返回值： 返回链表头部节点 head 即可。

  