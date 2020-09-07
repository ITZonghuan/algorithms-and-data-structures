package Tree.level;
/**
 * 不用递归的此题解法不是很好记忆
 * 中序遍历记为：不断压左、弹记当前、转为右边
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leet94非递归实现二叉树的中序遍历 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> sta = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !sta.isEmpty()){
            while(cur != null){
                sta.push(cur);
                cur = cur.left;
            }
            TreeNode node = sta.pop();
            res.add(node.val);
            cur = node.right;
        }
        return res;
    }
}
