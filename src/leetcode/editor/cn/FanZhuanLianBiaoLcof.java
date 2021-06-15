//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。 
//
// 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
// Related Topics 链表 
// 👍 243 👎 0


package leetcode.editor.cn;

public class FanZhuanLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new FanZhuanLianBiaoLcof().new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        solution.reverseList(head);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
// Definition for singly-linked list.
//    public static class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode(int x) {
//            val = x;
//        }
//        ListNode(int x,ListNode next){
//            val = x;
//            this.next=next;
//        }
//    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            while (cur!=null){
                ListNode nextTemp=cur.next;
                cur.next=pre;
                pre=cur;
                cur=nextTemp;
            }
            return pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}