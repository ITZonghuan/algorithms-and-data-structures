package Leetcode.top100;

public class leet02 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode (int x){
            val = x;
        }
    }
    public ListNode addTwoNumber(ListNode l1,ListNode l2){
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        //进位变量
        int carry = 0;
        while(l1 != null || l2 != null){
            int x = (l1 == null ? 0: l1.val);
            int y = (l2 == null ? 0: l2.val);
            int sum = x + y + carry;

            //变换进位值和目前的和
            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            //当前节点移动下一位
            cur = cur.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        //如果计算完之后 发现还需要进位一次
        if(carry == 1){
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
}
