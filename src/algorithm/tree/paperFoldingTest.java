package algorithm.tree;

import algorithm.table.linear.Queue;

public class paperFoldingTest {
    public static void main(String[] args) {
        //模拟折纸过程，产生树
        Node<String> tree3 = createTree(3);
        //遍历树，打印每个结点
        printTree(tree3);
    }

    //通过模拟对折N次纸，产生树
    public static Node<String> createTree(int N){
        //定义一个根节点
        Node<String> root = null;
        for (int i = 0; i < N; i++) {
            //1.当前是第一次对折
            if(i == 0){
                root = new Node<String>("down",null,null);
                continue;
            }
            //2.当前不是第一次对折
            //定义一个存放结点的辅助队列，通过层序遍历的思想，找到叶子节点，叶子节点添加自子节点
            Queue<Node> queue = new Queue<>();
            queue.enqueue(root);
            //循环遍历队列
            while(!queue.isEmpty()){
                //从队列中弹出一个结点
                Node<String> tmp = queue.dequeue();
                //如果有左子结点，就把左子节点弹入队列中
                if(tmp.left!=null){
                    queue.enqueue(tmp.left);
                }
                //如果有右子结点，就把右子结点弹入队列中
                if(tmp.right!=null){
                    queue.enqueue(tmp.right);
                }
                //如果同时没有左子结点和右子结点，那么证明该结点是叶子结点，只需要给该结点添加左子结点和右子结点即可
                if(tmp.left==null && tmp.right == null){
                    tmp.left = new Node<String>("down", null, null);
                    tmp.right = new Node<String>("up", null, null);
                }
            }
        }
        return root;
    }


    //遍历树，打印树中每个结点到控制台
    public static void printTree(Node<String> root){
        if(root == null){
            return;
        }
        if(root.left != null){
            printTree(root.left);
        }
        System.out.print(root.item + " ");
        if(root.right != null){
            printTree(root.right);
        }
    }

    //结点类
    private static class Node<T>{
        private T item;
        private Node left;
        private Node right;
        public Node(T item, Node left, Node right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }
}
