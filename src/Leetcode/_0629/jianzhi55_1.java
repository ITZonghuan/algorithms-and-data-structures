package Leetcode._0629;

/**
 * 二叉树的深度
 * 后序遍历/深搜
 */
public class jianzhi55_1 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x){
            this.val = x;
        }
    }
    public int maxDepth(TreeNode root){
        if(root == null ) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
}
