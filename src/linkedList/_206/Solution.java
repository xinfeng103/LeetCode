package linkedList._206;


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
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode p1=head.next,p2=p1.next;
        head.next=null;
        while (p2!=null && p2.next!=null){
            p1.next=head;
            head=p1;
            p1=p2;
            p2=p2.next;
        }
        p1.next=head;
        head=p1;
        p1=p2;
        if (p1!=null){
            p1.next=head;
            head=p1;
        }
        return head;
    }

    public ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
//        ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        ListNode listNode = new ListNode(1,new ListNode(2));
        Solution solution = new Solution();
        solution.reverseList(listNode);
    }
}
