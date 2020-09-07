package Leetcode._0629;

/**
 * 两个链表的第一个公共节点
 */
public class jianzhi52 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
            this.next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA,ListNode headB){
        if(headA == null || headB == null){
            return null;
        }
        ListNode node1 = headA,node2 = headB;
        while(node1 != node2){
            node1 = node1 != null ? node1.next:headB;
            node2 = node2 != null ? node2.next:headA;
        }
        return node1;
    }
}
