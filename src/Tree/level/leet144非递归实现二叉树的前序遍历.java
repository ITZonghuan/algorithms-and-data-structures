package Tree.level;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 层次遍历使用 BFS 实现，利用的就是 BFS（Queue）一层一层遍历的特性；
 * 而前序、中序、后序遍历利用了 DFS 实现。
 */
public class leet144非递归实现二叉树的前序遍历 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    //使用递归算法实现二叉树前序遍历
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root){
        if(root == null) return res;
        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return res;
    }


    //使用迭代算法实现
    public List<Integer> preOrderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> sta = new Stack<>();
        if(root == null) return res;
        sta.add(root);
        while(!sta.isEmpty()){
            TreeNode node = sta.pop();
            if(node == null) continue;
            res.add(node.val);
            sta.push(node.right);
            sta.push(node.left);
        }
        return res;
    }
}
