package Leetcode.third;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树中和为某一值得路径
 */
public class jianzhi34 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root,int sum){
        recur(root,sum);
        return res;
    }
    void recur(TreeNode root,int tar){
        if(root == null) return;
        path.add(root.val);
        tar -= root.val;
        if(tar == 0 && root.left ==null && root.right ==null){
            res.add(new LinkedList<>(path));
        }
        recur(root.left,tar);
        recur(root.right,tar);
        path.removeLast();

    }
}
