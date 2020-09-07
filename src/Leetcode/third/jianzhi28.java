package Leetcode.third;

/**
 * 对称的二叉树
 */
public class jianzhi28 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }
    public boolean isSymmetric(TreeNode root){
        return root == null?true:recur(root.left,root.right);
    }
    boolean recur(TreeNode L,TreeNode R){
        if(L==null && R==null) return true;
        if(L==null || R==null || L.val != R.val) return false;
        return recur(L.left,R.right) && recur(L.right,R.left);
    }
}
