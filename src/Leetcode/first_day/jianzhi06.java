package Leetcode.first_day;



import java.util.LinkedList;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值(用数组返回)
 */
public class jianzhi06 {
    public int[] reversePrint(ListNode head){
        LinkedList<Integer> stack = new LinkedList<Integer>();
        while(head != null){
            stack.addLast(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for(int i = 0; i<res.length;i++){
            res[i] = stack.removeLast();
        }
        return res;
    }
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
        }
    }
}
