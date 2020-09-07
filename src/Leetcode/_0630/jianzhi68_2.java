package Leetcode._0630;
/**
 * 二叉树的最近公共祖先
 * 递归
 */
public class jianzhi68_2 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x){
            this.val = x;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left == null && right == null) return null;
        if(left == null) return right;
        if(right == null) return left;
        return root;//均不为空
    }
}
