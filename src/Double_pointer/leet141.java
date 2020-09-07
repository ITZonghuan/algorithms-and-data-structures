package Double_pointer;

/**
 * 判断链表是否有环？
 */
public class leet141 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    public boolean hasCycle(ListNode head){
        if(head == null) return false;
        //快慢指针，双指针，初始化慢指针为头结点，快指针为头结点的下一个结点
        ListNode l1 = head,l2 = head.next;
        while(l2 !=null && l2.next != null){
            if(l1 == l2) return true;
            l1 = l1.next;
            l2 = l2.next.next;
        }
        return false;
    }
}
