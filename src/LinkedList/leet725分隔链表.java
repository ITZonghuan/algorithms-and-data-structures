package LinkedList;

public class leet725分隔链表 {
    public class ListNode{
        int val;
        ListNode next;
        public ListNode(int x){
            val = x;
        }
    }
    public ListNode[] splitListToParts(ListNode root,int k){
        int N = 0;
        ListNode cur = root;
        while(cur != null){
            N++;
            cur = cur.next;
        }
        int mod = N % k;
        int num = N / k;
        cur = root;
        ListNode[] res = new ListNode[k];
        for(int i=0;cur !=null && i<k;i++){
            res[i] = cur;
            int size = num + (mod-- >0 ?1:0);
            for(int j = 0;j<size-1;j++){
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return res;
    }
}
