package Tree.BST;

public class leet230寻找二叉查找树的第k个元素 {
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
    private int count = 0;
    private int value = 0;

    public int kthSmallest(TreeNode root,int k){
        inOrder(root,k);
        return value;
    }
    private void inOrder(TreeNode root,int k){
        if(root == null) return;
        inOrder(root.left,k);
        count++;
        if(count == k){
            value = root.val;
            return;
        }
        inOrder(root.right,k);
    }
}
