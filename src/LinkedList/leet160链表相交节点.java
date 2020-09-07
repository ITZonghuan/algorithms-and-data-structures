package LinkedList;

public class leet160链表相交节点 {
    public class ListNode{
        int val;
        ListNode next;
        public ListNode(int x){
            val = x;
            next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA,ListNode headB){
        ListNode NodeA = headA,NodeB = headB;
        while(NodeA != NodeB){
            NodeA = (NodeA == null?headB:NodeA.next);
            NodeB = (NodeB == null?headA:NodeB.next);
        }
        return NodeA;
    }
}
