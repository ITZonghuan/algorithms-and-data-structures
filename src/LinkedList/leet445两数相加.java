package LinkedList;

import java.util.Stack;

public class leet445两数相加 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        Stack<Integer> sta1 = buildStack(l1);
        Stack<Integer> sta2 = buildStack(l2);
        int carry = 0;
        ListNode head = new ListNode(-1);
        while(!sta1.isEmpty() || !sta2.isEmpty() || carry !=0){
            int x = sta1.isEmpty()?0:sta1.pop();
            int y = sta2.isEmpty()?0:sta2.pop();
            int sum = x + y + carry;
            ListNode node = new ListNode(sum % 10);
            node.next = head.next;
            head.next = node;
            carry = sum/10;
        }
        return head.next;
    }
    private Stack<Integer> buildStack(ListNode ln){
        Stack<Integer> stack = new Stack();
        while(ln != null ){
            stack.add(ln.val);
            ln = ln.next;
        }
        return stack;
    }
}
