package Leetcode._0625;

/**
 * 二叉搜索树与双向链表
 */
public class jianzhi36 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node(){}
        public Node(int _val){
            this.val = _val;
        }
        public Node(int _val,Node _left,Node _right){
            this.val = _val;
            this.left = _left;
            this.right = _right;
        }
    }
    Node head,pre;
    public Node treeToDoublyList(Node root){
        if(root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    public void dfs(Node cur){
        if(cur == null) return;
        //左
        dfs(cur.left);
        //pre用于记录双向链表中位于cur左侧的节点，即上一次迭代中的cur，当pre==null时，此时cur为头节点
        if(pre == null) head = cur;
        else pre.right = cur;

        cur.left = pre;
        //根
        pre = cur;
        //右
        dfs(cur.right);
    }
}
