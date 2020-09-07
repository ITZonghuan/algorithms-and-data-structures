package Tree.BST;

public class leet538把二叉搜索树转换为累加树 {
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
    private int sum = 0;
    public TreeNode convertBST(TreeNode root){
        plus(root);
        return root;
    }
    private void plus(TreeNode root){
        if(root == null) return;
        plus(root.right);
        sum += root.val;
        root.val = sum;
        plus(root.left);
    }
}
