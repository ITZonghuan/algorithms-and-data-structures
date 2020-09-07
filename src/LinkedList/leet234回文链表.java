package LinkedList;

public class leet234回文链表 {
    public class ListNode{
        int val;
        ListNode next;
        public ListNode(int x){
            x = val;
        }
    }
    public boolean isPalindrome(ListNode head){
        if(head == null || head.next == null) return true;
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //奇偶判断
        if(fast != null) slow = slow.next;
        cut(head,slow);
        return isEqual(head,reverse(slow));
    }
    private void cut(ListNode head,ListNode slow){
        ListNode node = head;
        while(node.next != slow){
            node = node.next;
        }
        node.next = null;
    }
//    private void cut(ListNode head,ListNode slow){
//        while(head.next != slow){
//            head = head.next;
//        }
//        head.next = null;
//    }
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode next = head.next;
        ListNode newHead = reverse(next);
        next.next = head;
        head.next = null;
        return newHead;
    }
    private boolean isEqual(ListNode l1,ListNode l2){
        while(l1 != null && l2 != null){
            if(l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }
}
