import java.util.ArrayList;
import java.util.List;

/*234. 回文链表
        请判断一个链表是否为回文链表。

        示例 1:
            输入: 1->2
            输出: false
        示例 2:
            输入: 1->2->2->1
            输出: true
        进阶：
        你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？*/
public class IsPalindromeLeeCode234 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(2,new ListNode(1))));
        System.out.println(isPalindrome(head));
    }
    //快慢指针
    public static boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        //使用快慢指针定位中间节点
        ListNode fast = head;
        ListNode low = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            low = low.next;
        }
        //得到中间节点
        ListNode mid = low;
        //将后半段链表反转
        ListNode back = reverseList(mid.next);
        //判断是否回文
        boolean result = true;
        ListNode n1 = head;
        ListNode n2 = back;
        while(result && n2!=null){
            if(n1.val != n2.val){
                result = false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        //还原链表
        mid.next = reverseList(back);
        return result;
    }
    public static ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }
    //=====================================================================================
    //将值复制到数组中后用双指针法
//    public static boolean isPalindrome(ListNode head) {
//        List<Integer> nums = new ArrayList<Integer>();
//        ListNode currentNode = head;
//        while (currentNode != null){
//            nums.add(currentNode.val);
//            currentNode = currentNode.next;
//        }
//        int first = 0;
//        int last = nums.size()-1;
//        while(first<=last){
//            if(!nums.get(first++).equals(nums.get(last--))){
//                return false;
//            }
//        }
//        return true;
//    }

}
