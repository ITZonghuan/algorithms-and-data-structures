package Leetcode.leetcode;

import java.util.Iterator;

public class leet24 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        //head.next = new ListNode(2);
        //head.next.next = new ListNode(3);
        ListNode fin = swapPairs(head);
        System.out.println(fin);
        /**
        for (Integer integer : fin) {
            System.out.print(integer + "->");
        }
         */

    }
    public static class ListNode implements Iterable<Integer> {
        private ListNode head;
        private int val;
        private ListNode next;
        public ListNode(int x){
            this.val = x;
        }

        @Override
        public Iterator<Integer> iterator() {
            return new LIterator();
        }

        public class LIterator implements Iterator {
            private ListNode n;
            public LIterator(){
                this.n = head;
            }
            @Override
            public boolean hasNext() {
                return next!=null;
            }

            @Override
            public Object next() {
                return n.next.val;
            }
        }
    }
    public static ListNode swapPairs(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}
