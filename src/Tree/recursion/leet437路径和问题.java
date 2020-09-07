package Tree.recursion;

/**
 * 找一下是否有更好的思路
 */
public class leet437路径和问题 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public int pathSum(TreeNode root,int sum){
        if(root == null) return 0;
        return pathSumStartWithRoot(root,sum) + pathSum(root.left,sum) +pathSum(root.right,sum);

    }
    public int pathSumStartWithRoot(TreeNode root,int sum){
        if(root == null) return 0;
        int res = 0;
        if(root.val == sum) res++;
        res += pathSumStartWithRoot(root.left,sum-root.val) + pathSumStartWithRoot(root.right,sum-root.val);
        return res;
    }
}
