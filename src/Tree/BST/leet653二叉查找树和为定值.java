package Tree.BST;

import java.util.ArrayList;
import java.util.List;

public class leet653二叉查找树和为定值 {
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
    int sum = 0;
    public boolean findTarget(TreeNode root,int k){
        if(root == null) return false;
        toArray(root);
        int i = 0,j = list.size() - 1;
        while(i<j){
            sum = list.get(i) + list.get(j);
            if(sum == k) return true;
            if(sum < k){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }
    private void toArray(TreeNode root){
        if(root == null) return;
        toArray(root.left);
        list.add(root.val);
        toArray(root.right);
    }
}
