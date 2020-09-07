package Tree.level;
/**
 * 前序遍历为 root -> left -> right，后序遍历为 left -> right -> root。
 * 可以修改前序遍历成为 root -> right -> left，
 * 那么这个顺序就和后序遍历正好相反
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class leet145非递归实现二叉树的后序遍历 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> sta = new Stack<>();
        sta.push(root);
        while(!sta.isEmpty()){
            TreeNode node = sta.pop();
            if(node == null) continue;
            res.add(node.val);
            sta.push(node.left);
            sta.push(node.right);
        }
        Collections.reverse(res);
        return res;
    }
}
