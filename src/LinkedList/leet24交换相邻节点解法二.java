package LinkedList;

public class leet24交换相邻节点解法二 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    public ListNode swapPairs(ListNode head){
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode pre = node;
        while(pre.next != null && pre.next.next != null){
            ListNode l1 = pre.next,l2 = pre.next.next;
            ListNode nextNode = l2.next;
            l2.next = l1;
            l1.next = nextNode;
            pre.next = l2;
            pre = l1;
        }
        return node.next;
    }
}
