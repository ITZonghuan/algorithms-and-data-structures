package Leetcode.second;


/**
 * 链表中倒数第k个节点
 */
public class jianzhi22 {
    public ListNode getKthFromEnd(ListNode head,int k){
        ListNode slow = head, fast = head;
        //考虑加个变量t判断，代替第一个for循环
        int t = 0;
        while(fast != null){
            if(t>=k) slow = slow.next;
            fast = fast.next;
            t++;
        }
        return slow;
    }
    public class ListNode{
        int val;
        ListNode next;
        public ListNode(int x){
            this.val = x;
        }
    }
}
