package Tree.recursion;

public class leet104最大深度 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public int maxDepth(TreeNode root){
        if(root == null) return 0;
        //递归入门玩法：左子树最大深度和右子树最大深度的最大值+1
        return Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);
    }
}
