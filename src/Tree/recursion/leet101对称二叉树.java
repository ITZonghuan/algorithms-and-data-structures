package Tree.recursion;

public class leet101对称二叉树 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public boolean isSymmetric(TreeNode root){
        if(root == null) return true;
        return isSymmetric(root.right,root.left);
    }
    public boolean isSymmetric(TreeNode t1,TreeNode t2){
        if(t1 == null && t2 == null) return true;
        if(t1 ==null || t2 == null) return false;
        if(t1.val != t2.val) return false;
        return isSymmetric(t1.left,t2.right) && isSymmetric(t1.right,t2.left);
    }
}
