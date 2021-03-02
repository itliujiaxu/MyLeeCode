/*2. 两数相加
给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。

请你将两个数相加，并以相同形式返回一个表示和的链表。

你可以假设除了数字 0 之外，这两个数都不会以 0开头。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-two-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class AddTwoNumbersLeeCode2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2,new ListNode(4,new ListNode(3)));
        ListNode l2 = new ListNode(5,new ListNode(6,new ListNode(4)));
        ListNode getNode = addTwoNumbers(l1,l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        int mid = 0;
        ListNode a = new ListNode(0);
        ListNode aa = a;
        while(l1!=null||l2!=null){
            int val1 = l1!=null?l1.val:0;
            int val2 = l2!=null?l2.val:0;
            int val = val1+val2+mid;
            ListNode ln = new ListNode(val%10);
            aa.next = ln;
            aa = ln;
            mid = val/10;
            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;
        }
        return a.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
