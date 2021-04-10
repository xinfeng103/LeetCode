package linkedList._25;


// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null) {
//            return l2;
//        }
//        if (l2 == null) {
//            return l1;
//        }
//        ListNode p;
//        if (l1.val < l2.val) {
//            p = l1;
//            l1 = l1.next;
//        } else {
//            p = l2;
//            l2 = l2.next;
//        }
//        ListNode p1 = p;
//        while (l1 != null && l2 != null) {
//            if (l1.val < l2.val) {
//                p.next = l1;
//                l1 = l1.next;
//            } else {
//                p.next = l2;
//                l2 = l2.next;
//            }
//            p = p.next;
//        }
//        p.next = l1 != null ? l1 : l2;
//        return p1;
//    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0), cur = dum;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        Solution solution = new Solution();
        l1 = solution.mergeTwoLists(l1, l2);
        System.out.println(l1.toString());
    }
}
