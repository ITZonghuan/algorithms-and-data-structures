package Tree.BST;

public class leet109有序链表构造平衡二叉树 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){};
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    public TreeNode sortedListToBST(ListNode head){
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        ListNode pre = preMid(head);
        ListNode node = pre.next;
        pre.next = null;//断开链表
        TreeNode root = new TreeNode(node.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(node.next);
        return root;
    }
    private ListNode preMid(ListNode head){
        if(head == null) return null;
        ListNode slow = head,fast = head.next;
        ListNode pre = head;
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return pre;
    }
}
