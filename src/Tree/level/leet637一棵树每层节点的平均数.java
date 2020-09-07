package Tree.level;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leet637一棵树每层节点的平均数 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public List<Double> averageOfLevels(TreeNode root){
        List<Double> res = new ArrayList();
        if(root == null) return res;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int cnt = que.size();
            double sum = 0;
            for(int i=0;i<cnt;i++){
                TreeNode node = que.poll();
                sum += node.val;
                if(node.left != null) que.add(node.left);
                if(node.right != null) que.add(node.right);
            }
            res.add(sum/cnt);
        }
        return res;
    }
}
