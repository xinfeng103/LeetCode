package Sword_Finger_Offer;

import java.util.Stack;

/*
    TODO 6.输入一个链表的头节点，从尾到头逆序打印每个节点的值
 */
public class PrintListReversingly06 {
    // TODO 方法一：基于栈
    public void PrintListReversingly(ListNode linkList) {
        Stack<Integer> stack = new Stack<Integer>();
        ListNode node = linkList;
        while (node != null) {
            stack.push(node.value);
            node = node.next;
        }
        System.out.println("基于栈：");
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    // TODO 方法二：递归
    public void PrintListReverseRecursively(ListNode linkList) {
        ListNode node = linkList;
        if (node != null) {
            if (node.next != null) {
                PrintListReverseRecursively(node.next);
            }
            System.out.print(node.value + " ");
        }
    }

    public static void main(String[] args) {
        PrintListReversingly06 solution = new PrintListReversingly06();
        ListNode linkList = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        solution.PrintListReversingly(linkList);
        solution.PrintListReverseRecursively(linkList);
    }
}

class ListNode {
    int value;
    ListNode next;

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}
