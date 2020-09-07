package Leetcode.second;

/**
 * 反转链表
 */
public class jianzhi24 {
    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        first.next = new ListNode(2);
        first.next.next = new ListNode(3);
        ListNode node = reverseList(first);
        System.out.println(node);
    }
    public static ListNode reverseList(ListNode head){
        if(head == null) return null;
        else if(head.next == null) return head;
        ListNode temp = head.next;
        ListNode cur = reverseList(temp);
        temp.next = head;
        head.next = null;
        return cur;
    }
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int x){
            this.val = x;
        }
    }
}
