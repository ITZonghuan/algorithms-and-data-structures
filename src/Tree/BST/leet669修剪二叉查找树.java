package Tree.BST;

/**
 * 二叉查找树（BST）：
 * 根节点大于等于左子树所有节点，小于等于右子树所有节点。
 * 二叉查找树中序遍历有序。
 */
public class leet669修剪二叉查找树 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public TreeNode trimBST(TreeNode root,int L,int R){
        if(root == null) return null;
        if(root.val > R){
            return trimBST(root.left,L,R);
        }else if(root.val < L){
            return trimBST(root.right,L,R);
        }else{
            root.left = trimBST(root.left,L,R);
            root.right = trimBST(root.right,L,R);
        }
        return root;
    }
}
