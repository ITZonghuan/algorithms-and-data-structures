package Leetcode.second;

/**
 * 删除链表的节点
 */
public class jianzhi18 {
    public ListNode deleteNode(ListNode head,int val){
        if(head == null) return null;
        if(head.val == val) return head.next;
        ListNode pre = head,cur = head.next;
        while(cur!=null && cur.val != val){
            pre = cur;
            cur = cur.next;
        }
        if(cur != null) pre.next = cur.next;
        return head;
    }
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
        }
    }
}
