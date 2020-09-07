package Leetcode.third;

/**
 * 合并两个排序的链表
 */
public class jianzhi25 {
    public class ListNode{
        private int val;
        private ListNode next;
        public ListNode(int x){
            this.val = x;
        }
    }
    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        //这里有一个伪节点的思想，需要搞清楚
        ListNode cur = new ListNode(0),dum = cur;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                //l1继续往下走
                l1 = l1.next;
            }else{
                cur.next = l2;
                //l2继续往下走
                l2 = l2.next;
            }
            //cur继续往下走
            cur = cur.next;
        }
        //剩下的没走完的继续走下去
        cur.next = (l1!=null?l1:l2);
        return dum.next;
    }
}
