
//输入一个链表，输出该链表中倒数第k个节点。

// 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。

// 示例：
//给定一个链表: 1->2->3->4->5, 和 k = 2.
//返回链表 4->5. 


package leetcode.editor.cn;

public class LianBiaoZhongDaoShuDiKgeJieDianLcof {
    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,null)));
        Solution solution = new LianBiaoZhongDaoShuDiKgeJieDianLcof().new Solution();
        ListNode ans = solution.getKthFromEnd(head, 3);
        System.out.println(ans);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    //  Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x, ListNode next) {
            val = x;
            this.next=next;
        }
    }

    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            ListNode p1 = head, p2 = head;
            while (p1!= null && k > 0) {
                p1 = p1.next;
                k--;
            }
            if(k>0){
                return null;
            }
            while (p1 != null) {
                p1 = p1.next;
                p2 = p2.next;
            }
            return p2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}