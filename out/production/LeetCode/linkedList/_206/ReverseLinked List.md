# 206. Reverse Linked List

## 题目

- Given the head of a singly linked list, reverse the list, and return the reversed list.

> Input: head = [1,2,3,4,5]
> Output: [5,4,3,2,1]

> Input: head = []
> Output: []

## 解题思路

- 在遍历链表时，将当前节点的next指针改为指向前一个节点。由于节点没有引用其前一个节点，因此必须事先存储其前一个节点。在更改引用之前，还需要存储后一个节点。最后返回新的头引用。
  
  