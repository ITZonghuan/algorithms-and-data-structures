package Tree.recursion;

public class leet110平衡二叉树 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    private  boolean isbal = true;
    public boolean isBalanced(TreeNode root){
        maxDepth(root);
        return isbal;
    }
    public  int maxDepth(TreeNode root){
        if(root == null) return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if(Math.abs(l - r) > 1) isbal = false;
        return Math.max(l,r) + 1;
    }
}
