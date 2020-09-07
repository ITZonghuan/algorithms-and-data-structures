package Leetcode._0630;

/**
 * 二叉搜索树的最近公共祖先
 */
public class jianzhi68_1 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x){
            this.val = x;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        if(p.val > q.val){
            //保证p.val<q.val
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        while(root != null){
            if(root.val < p.val){
                //p、q都在root的右子树中
                root = root.right;
            }else if(root.val > q.val){
                //p、q都在root的左子树中
                root = root.left;
            }else break;
        }
        return root;
    }

}
