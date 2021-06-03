package Sword_Finger_Offer;

import leetcode.editor.cn.LianBiaoZhongDaoShuDiKgeJieDianLcof;

//判断链表是否有环，如果有环返回环的入口点
public class LinkedListRing {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(7);
        ListNode node5 = new ListNode(8);
        ListNode node6 = new ListNode(9);
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, node1)));
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node1;
        ListNode ans = solution.EntryNodeOfLoop(head);
        System.out.println(ans.val);
    }

    //  Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public LinkedListRing.ListNode EntryNodeOfLoop(LinkedListRing.ListNode pHead) {
            if (pHead == null) {
                return null;
            }
            // 设置快慢指针，快指针一次走两步，慢指针一次走一步
            LinkedListRing.ListNode fast = pHead;
            LinkedListRing.ListNode low = pHead;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                low = low.next;
                if (fast == null || fast.next == null) {
                    return null;
                }
                if (fast == low) {
                    break;
                }
            }

//            do {
//                // 快指针先走一步
//                fast = fast.next;
//                // 若fast为null，表示没环，直接return空
//                if (fast == null) {
//                    return null;
//                }
//                // 若不为null，再向前走一步
//                fast = fast.next;
//                // 慢指针向前走一步
//                low = low.next;
//            } while (fast != null && fast != low);

            // low指针指向链表头节点，fast指针不变，还是在相遇点
            // 两个指针速度均为1，向前走，再次相遇的点就是环入口节点
            low = pHead;
            while (low != fast) {
                low = low.next;
                fast = fast.next;
            }
            return low;
        }
    }


}

