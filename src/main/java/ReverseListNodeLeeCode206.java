
/*206. 反转链表
反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class ReverseListNodeLeeCode206 {
    public static void main(String[] args) {
        //递归解析
        //https://mp.weixin.qq.com/s/_6XSZSurfM2W92ZrTUWJvQ
        ListNode a = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,null))));
//        ListNode b = reverseList(a);
        ListNode b = whileList(a);
        System.out.println();
    }
    /*迭代
    * 1.curr.next = prev(curr:1->null) prev = curr(prev:1->null) curr = n(curr:2->3->4->null)
    * 2.curr.next = prev(curr:2->1->null)  prev = curr(prev:2->1->null) curr = n(curr:3->4->null)
    * 3.curr.next = prev(curr:3->2->1->null) prev = curr(prev:3->2->1->null) curr = n(curr:4->null)
    * 4.curr.next = prev(curr:4->3->2->1->null) prev = curr(prev:4->3->2->1->null) curr = n(curr:null) 结束循环返回prev
    * */
    private static ListNode whileList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr!=null){
            ListNode n = curr.next;
            curr.next = prev;
            prev = curr;
            curr = n;
        }
        return prev;
    }

    /* 递归
     * 从后往前
     * 1.    node:4->null    head:3->4->null  head.next.next(node:4->[null])  head.next.next = head（node:4->3->4->null）  head.next=null(node:4->3->null)
     * 2.    node:4->3->null head:2->3->4->null  head.next.next(node:4->3->[null])   head.next.next=head(node:4->3->2->3->4->null)   head.next = null(node:4->3->2->null)
     * 3.    以此类推
     * */
    public static ListNode reverseList(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newListNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newListNode;

    }
}
