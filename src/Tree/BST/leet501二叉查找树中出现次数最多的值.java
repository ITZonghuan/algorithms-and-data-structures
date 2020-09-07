package Tree.BST;

import java.util.ArrayList;
import java.util.List;

public class leet501二叉查找树中出现次数最多的值 {
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
    private int curNum = 1;
    private int maxNum = 1;
    private TreeNode preNode = null;
    List<Integer> list = new ArrayList<>();
    public int[] findMode(TreeNode root){
        if(root == null) return new int[0];
        inOrder(root,list);
        int[] res = new int[list.size()];
        for(int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
    private void inOrder(TreeNode root,List<Integer> list){
        if(root == null) return;
        inOrder(root.left,list);
        if(preNode != null){
            if(preNode.val == root.val){
                curNum++;
            }else{
                curNum = 1;
            }
        }
        if(curNum > maxNum){
            maxNum = curNum;
            list.clear();
            list.add(root.val);
        }else if(curNum == maxNum){
            list.add(root.val);
        }
        preNode = root;
        inOrder(root.right,list);
    }
}
