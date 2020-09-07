package Leetcode.third;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * "之"字形打印二叉树
 */
public class jianzhi32_3 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root){
        if(root != null) return new ArrayList<>(0);
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.add(root);
        //flag对应到每次打印一层是否需要反转
        boolean flag = true;
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            for(int i = queue.size();i>0;i--){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            if(!flag) list = reverse(list);
            flag = !flag;
            res.add(list);
        }
        return res;

    }
    //转置数组
    public List<Integer> reverse(List<Integer> list){
        List<Integer> res = new ArrayList<>();
        for(int i = list.size()-1;i>=0;i--){
            res.add(list.get(i));
        }
        return res;
    }
}
