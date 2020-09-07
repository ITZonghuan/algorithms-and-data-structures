package Tree.level;

import java.util.LinkedList;
import java.util.Queue;

public class leet513得到左下角的节点 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public int findBottomLeftValue(TreeNode root){
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            root = que.poll();
            if(root.right != null) que.add(root.right);
            if(root.left != null) que.add(root.left);
        }
        return root.val;
    }
}
