package LinkedList;

public class leet83删除重复节点 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    public ListNode deleteDuplicates(ListNode head){
        if(head == null || head.next ==null) return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val?head.next:head;
    }
}
