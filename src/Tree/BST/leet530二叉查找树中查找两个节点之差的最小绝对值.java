package Tree.BST;

import java.util.ArrayList;
import java.util.List;

public class leet530二叉查找树中查找两个节点之差的最小绝对值 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){};
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    List<Integer> list = new ArrayList<>();
    int minDiff = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root){
        if(root == null) return 0;
        toArray(root);
        for(int i =1;i<list.size();i++){
            minDiff = Math.min(minDiff,list.get(i)-list.get(i-1));
        }
        return minDiff;
    }
    private void toArray(TreeNode root){
        if(root == null) return;
        toArray(root.left);
        list.add(root.val);
        toArray(root.right);
    }
}
