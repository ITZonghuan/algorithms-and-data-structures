package Tree.BST;

public class leet108从有序数组中构造二叉查找树 {
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
    public TreeNode sortedArrayToBST(int[] nums){
        if(nums == null) return null;
        return toBST(nums,0,nums.length-1);
    }
    private TreeNode toBST(int[] nums,int s,int e){
        if(s > e) return null;
        int mid = s + (e - s)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = toBST(nums,s,mid-1);
        root.right = toBST(nums,mid+1,e);
        return root;
    }
}
