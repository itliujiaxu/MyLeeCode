import java.util.List;

/*23. 合并K个升序链表
        给你一个链表数组，每个链表都已经按升序排列。
        请你将所有链表合并到一个升序链表中，返回合并后的链表。
        示例 1：
            输入：lists = [[1,4,5],[1,3,4],[2,6]]
            输出：[1,1,2,3,4,4,5,6]
            解释：链表数组如下：
            [
            1->4->5,
            1->3->4,
            2->6
            ]
            将它们合并到一个有序链表中得到。
            1->1->2->3->4->4->5->6
        示例 2：
            输入：lists = []
            输出：[]
        示例 3：
            输入：lists = [[]]
            输出：[]

        提示：
            k == lists.length
            0 <= k <= 10^4
            0 <= lists[i].length <= 500
            -10^4 <= lists[i][j] <= 10^4
            lists[i] 按 升序 排列
            lists[i].length 的总和不超过 10^4*/
public class MergeKLists23 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1,new ListNode(4,new ListNode(5)));
        ListNode list2 = new ListNode(1,new ListNode(3,new ListNode(4)));
        ListNode list3 = new ListNode(2,new ListNode(6));
        ListNode[] lists = {list1,list2,list3};
        ListNode result = mergeKLists(lists);
        System.out.println();
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        for (int i = 0; i < lists.length; i++) {
            result = mergeTwoList(result,lists[i]);
        }
        return result;
    }
    public static ListNode mergeTwoList(ListNode n1, ListNode n2){
        if(n1 == null){
            return n2;
        }else if(n2 == null){
            return n1;
        }else if(n1.val <= n2.val){
            n1.next = mergeTwoList(n1.next,n2);
            return n1;
        }else{
            n2.next = mergeTwoList(n1,n2.next);
            return n2;
        }

    }
}
