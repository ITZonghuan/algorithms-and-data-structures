package LinkedList;

public class leet206链表反转 {
    public class ListNode{
        int val;
        ListNode next;
        public ListNode(int x){
            val = x;
        }
    }
    public ListNode reverseList(ListNode head){
        //终止条件
        if(head == null || head.next == null) return head;
        ListNode headNext = head.next;
        //返回值
        ListNode newHead = reverseList(headNext);
        headNext.next = head;
        head.next = null;
        return newHead;
    }
}
