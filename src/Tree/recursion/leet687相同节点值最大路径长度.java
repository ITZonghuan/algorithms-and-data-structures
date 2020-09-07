package Tree.recursion;

import org.junit.Assert;
import org.junit.Test;

public class leet687相同节点值最大路径长度 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    private int path = 0;
    public int longestUnivaluePath(TreeNode root){
        dfs(root);
        return path;
    }
    private int dfs(TreeNode root){
        if(root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int leftpath = (root.left != null && root.left.val == root.val)?left+1:0;
        int rightpath = (root.right != null && root.right.val == root.val)?right+1:0;
        path = Math.max(path,leftpath + rightpath);
        return Math.max(leftpath,rightpath);
    }
}
