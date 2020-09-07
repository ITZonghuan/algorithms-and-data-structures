package LinkedList;

/**
 * 快慢指针解决删除倒数第n个节点
 */
public class leet删除倒数第n个节点 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    public ListNode removeNthFromEnd(ListNode head,int n){
        ListNode fast = head;
        while(n-->0){
            fast = fast.next;
        }
        if(fast == null) return head.next;
        ListNode slow = head;
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
