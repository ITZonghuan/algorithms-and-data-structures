package Tree.recursion;

public class leet572子树 {
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
      }
      public boolean isSubtree(TreeNode s,TreeNode t){
         if(s == null) return false;
         return isSubtreeWithRoot(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);
      }
      public boolean isSubtreeWithRoot(TreeNode s,TreeNode t){
         if(s == null  && t == null) return true;
         if(s == null || t == null) return false;
         if(s.val != t.val) return false;
         return isSubtreeWithRoot(s.left,t.left) && isSubtreeWithRoot(s.right,t.right);
      }
}
