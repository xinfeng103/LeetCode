package linkedList._18;


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val==val){
            return head.next;
        }
        ListNode pre=head,cur = head.next;
        while (cur!=null && cur.val!=val){
            pre=cur;
            cur=cur.next;
        }
        if(cur!=null) pre.next=cur.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        listNode.next = node2;
        node2.next = node3;
        node3.next = node4;
        Solution solution = new Solution();
        solution.deleteNode(listNode, 5);
    }
}
