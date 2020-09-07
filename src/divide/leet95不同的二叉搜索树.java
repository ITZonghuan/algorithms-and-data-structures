package divide;

import java.util.LinkedList;
import java.util.List;

public class leet95不同的二叉搜索树 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){};
        TreeNode(int x){this.val = x;}
        TreeNode(int x,TreeNode left,TreeNode right){
            this.val = x;
            this.left = left;
            this.right = right;
        }
    }
    public List<TreeNode> generateTrees(int n){
        if(n<1){
            return new LinkedList<TreeNode>();
        }
        return generateSubtree(1,n);
    }
    private List<TreeNode> generateSubtree(int start,int end){
        List<TreeNode> res = new LinkedList<>();
        if(start > end){
            res.add(null);
            return res;
        }
        for(int i=start;i<=end;i++){
            List<TreeNode> left = generateSubtree(start,i-1);
            List<TreeNode> right = generateSubtree(i+1,end);
            for(TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
