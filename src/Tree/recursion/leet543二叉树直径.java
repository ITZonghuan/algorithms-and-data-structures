package Tree.recursion;

public class leet543二叉树直径 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root){
        if(root == null) return 0;
        maxDepth(root);
        return max;
    }
    public int maxDepth(TreeNode root){
        if(root == null) return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        max = Math.max(max,l + r);
        return Math.max(l,r) + 1;
    }
}
