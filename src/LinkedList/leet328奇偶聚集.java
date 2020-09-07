package LinkedList;

public class leet328奇偶聚集 {
    public class ListNode{
        int val;
        ListNode next;
        public ListNode(){}
        public ListNode(int x){
            val = x;
        }
        public ListNode(int x,ListNode next){
            this.val = x;
            this.next = next;
        }
    }
    public ListNode oddEvenList(ListNode head){
        if(head ==null || head.next == null || head.next.next ==null){
            return head;
        }
        ListNode odd = head,even = head.next,oldEven = even;
        while(even != null && even.next != null){
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = oldEven;
        return head;
    }
}
