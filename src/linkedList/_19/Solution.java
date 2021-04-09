package linkedList._19;


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1=head,p2=head;
        for(int i=0;i<n;i++){
            p2=p2.next;
        }
        while (p2!=null && p2.next!=null){
            p2=p2.next;
            p1=p1.next;
        }
        if (p2==null){
            return head.next;
        }
        p1.next=p1.next.next;
        return head;
    }
    public static void main(String[] args) {
//        ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        ListNode listNode = new ListNode(1,new ListNode(2));
        Solution solution = new Solution();
        solution.removeNthFromEnd(listNode,0);
    }
}
