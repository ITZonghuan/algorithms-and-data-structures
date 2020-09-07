package Leetcode.third;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下打印二叉树
 */
public class jianzhi32 {
    public int[] levelOrder(jianzhi28.TreeNode root){
        if(root == null) return new int[0];
        int[] res;
        List<Integer> list = new ArrayList<>();
        Queue<jianzhi28.TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            //poll() @return the head of this queue, or {@code null} if this queue is empty
            jianzhi28.TreeNode node = queue.poll();
            list.add(node.val);
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
        Integer[] arr = list.toArray(new Integer[list.size()]);
        res = new int[arr.length];
        for(int i = 0;i<arr.length;i++){
            res[i] = arr[i];
        }
        return res;
    }
}
