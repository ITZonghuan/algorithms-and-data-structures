package Leetcode.third;

/**
 * 树的子结构
 * 递归思想！！！理解透
 */
public class jianzhi26 {
    public boolean isSubStructure(TreeNode A,TreeNode B){
        return (A != null && B != null) && (recur(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B));
    }
    /**
     * 判断树 A中以 n_A为根节点的子树 是否包含树 B
     * @param A 二叉树
     * @param B 二叉树
     * @return true/false
     */
    boolean recur(TreeNode A,TreeNode B){
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left,B.left) && recur(A.right,B.right);
    }
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }
}
