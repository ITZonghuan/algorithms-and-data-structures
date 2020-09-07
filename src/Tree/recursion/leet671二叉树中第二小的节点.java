package Tree.recursion;

public class leet671二叉树中第二小的节点 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }
    public int findSecondMinimumValue(TreeNode root){
        if(root == null) return -1;
        if(root.left == null && root.right == null) return -1;
        int leftval = root.left.val;
        int rightval = root.right.val;
        if(leftval == root.val)  leftval = findSecondMinimumValue(root.left);
        if(rightval == root.val)  rightval = findSecondMinimumValue(root.right);
        if(leftval != -1 && rightval != -1) return Math.min(leftval,rightval);
        if(leftval != -1) return leftval;
        return rightval;
    }
}
