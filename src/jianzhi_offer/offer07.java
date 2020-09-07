package jianzhi_offer;

import java.util.ArrayList;
import java.util.List;

public class offer07 {
    public static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int x){
            this.val = x;
        }
    }
    public static TreeNode buildTree(int[] preorder,int[] inorder){
        if(preorder == null || inorder == null) return null;
        if(preorder.length == 0 || inorder.length ==0) return null;
        int root = preorder[0];
        int inindex = -1, preindex = -1;

        //下一次循环的输入
        List<Integer> preorderlistleft = new ArrayList<>();
        List<Integer> preorderlistright = new ArrayList<>();
        List<Integer> inorderlistleft = new ArrayList<>();
        List<Integer> inorderlistright = new ArrayList<>();

        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == root){
                inindex = i;
            }
        }
        for (int i = 0; i < inorder.length; i++) {
            if(i<inindex){
                inorderlistleft.add(inorder[i]);
            }else if(i > inindex){
                inorderlistright.add(inorder[i]);
            }
        }
        for (int j = 0; j < preorder.length; j++) {
            if(j<inindex){
                preorderlistleft.add(preorder[j]);
            }else if(j>inindex){
                preorderlistright.add(preorder[j]);
            }
        }
        TreeNode left = buildTree(preorderlistleft.stream().mapToInt(Integer::valueOf).toArray(),inorderlistleft.stream().mapToInt(Integer::valueOf).toArray());
        TreeNode right = buildTree(preorderlistright.stream().mapToInt(Integer::valueOf).toArray(),inorderlistright.stream().mapToInt(Integer::valueOf).toArray());
        TreeNode Root = new TreeNode(root);
        Root.left = left;
        Root.right = right;
        return Root;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        System.out.println(buildTree(preorder,inorder).val);
    }
}
