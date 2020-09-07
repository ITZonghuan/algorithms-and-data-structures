package Leetcode._0629;

/**
 * 二叉搜索树的第k大节点
 * 二叉树中序遍历倒序为递减序列
 */
public class jianzhi54 {
    private int res,n;
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }
    public int kthLargest(TreeNode root,int k){
        n = k;
        dfs(root);
        return res;
    }
    public void dfs(TreeNode node){
        if(node == null || n==0) return;
        dfs(node.right);
        if(--n == 0){
            res = node.val;
            return;
        }
        dfs(node.left);
    }
}
