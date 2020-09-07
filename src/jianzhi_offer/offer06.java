package jianzhi_offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class offer06 {
    public class ListNode{
        private int val;
        private ListNode next;
        public ListNode(int x){
            this.val = x;
        }
    }
    public int[] reversePrint(ListNode head){
        List<Integer> list = new ArrayList<>();
        if(head == null) return new int[0];
        if(head.next == null) return new int[]{head.val};
        ListNode newHead = reverse(head);
        list.add(newHead.val);
        ListNode node = newHead;
        while (node.next != null){
            node = node.next;
            list.add(node.val);
        }
        //List 转为 int[]
        int[] res = list.stream().mapToInt(Integer::valueOf).toArray();
        return res;
    }
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode node = head.next;
        ListNode newHead = reverse(node);
        node.next = head;
        head.next = null;
        return newHead;
    }
}
