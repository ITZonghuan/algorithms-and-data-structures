package algorithm.tree;

import algorithm.table.linear.Queue;

import java.util.Iterator;

public class BinaryTree<key extends Comparable<key>,value>{
    private Node root;
    private int N;


    private class Node{
        private key key;
        private value value;
        private Node left;
        private Node right;
        private Node(key key,value value,Node left,Node right){
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
/*
    //构造函数
    public BinaryTree(){
        this.root = new Node(null,null,null,null);
        this.N = 0;
    }
*/
    //向树中插入一个键值对,root能代表整个树
    public void put(key key,value value){
        root = put(root, key, value);
    }

    //给指定树x上，添加一个键值对，并返回添加后的新树
    private Node put(Node x,key key,value value){
        //如果不存在根结点
        if(x==null){
            N++;
            return new Node(key,value,null,null);
        }
        //如果存在根节点，就需要进行与根结点键值的比较
        int cmp = key.compareTo(x.key);
        if(cmp > 0){
            x.right = put(x.right, key, value);
        }else if(cmp <0){
            x.left = put(x.left,key,value);
        }else{
            x.value = value;
        }
        return x;
    }

    //根据key，从树中找出对应的值
    public value get(key key){
        return get(root,key);
    }

    //从制定树x中，找出key对应的值
    public value get(Node x,key key){
        //如果当前结点为null
        if(x == null){
            return null;
        }
        //如果当前结点不为null
        int cmp = key.compareTo(x.key);
        if(cmp > 0){
            return get(x.right,key);
        }else if(cmp <0){
            return get(x.left,key);
        }else{
            return x.value;
        }
    }

    //根据key，删除树中的对应的键值对
    public void delete(key key){
        delete(root,key);
    }

    //删除制定树x上的键为key的键值对，并返回删除后的新树
    private Node delete(Node x,key key){
        //判断当前结点是否为空
        if(x == null){
            return null;
        }
        //当前结点不为空
        int cmp = key.compareTo(x.key);
        if(cmp > 0){
            x.right = delete(x.right, key);
        }else if(cmp <0){
            x.left = delete(x.left,key);
        }else{
            N--;
            //找到当前结点右子树中最小的结点
            if(x.right == null){
                return x.left;
            }else if(x.left == null){
                return x.right;
            }

            Node minNode = x.right;
            while(minNode.left != null){
                minNode = minNode.left;
            }

            //删除当前结点右子树的最小结点
            Node n = x.right;
            while(n.left != null){
                if(n.left.left == null){
                    n.left = null;
                }else{
                    n = n.left;
                }
            }

            //让x结点的左子树成为minNode的左子树
            minNode.left = x.left;
            //让x结点的右子树成为minNode的右子树
            minNode.right = x.right;
            //当前结点变为minNode
            x = minNode;
        }
        return x;
    }

    //获取树中元素个数
    public int size(){
        return N;
    }

    //查找整个树中最小的键
    public key min(){
        return min(root).key;
    }

    //返回键最小的结点
    public Node min(Node x){
        if(x.left != null){
            return min(x.left);
        }else{
            return x;
        }
    }
    //查找整个树中最大的键
    public key max(){
        return max(root).key;
    }

    public Node max(Node x){
        if(x.right != null){
            return max(x.right);
        }else{
            return x;
        }
    }

    //前序遍历
    public Queue<key> prergodic(){
        Queue<key> keys = new Queue<>();
        prergodic(root,keys);
        return keys;
    }
    public void prergodic(Node x,Queue<key> keys){
        if(x == null){
            return;
        }
        //把此时结点的值放入队列中
        keys.enqueue(x.key);

        if(x.left != null){
            prergodic(x.left,keys);
        }

        if(x.right != null){
            prergodic(x.right,keys);
        }
    }

    //中序遍历
    public Queue<key> midrgodic(){
        Queue<key> keys = new Queue<>();
        midrgodic(root,keys);
        return keys;
    }
    public void midrgodic(Node x,Queue<key> keys){
        //判断二叉查找树是否为空
        if(x == null){
            return;
        }

        if(x.left != null){
            midrgodic(x.left,keys);
        }
        keys.enqueue(x.key);
        if(x.right != null){
            midrgodic(x.right,keys);
        }
    }

    //右序遍历
    public Queue<key> lastrgodic(){
        Queue<key> keys = new Queue<>();
        lastrgodic(root,keys);
        return keys;
    }
    public void lastrgodic(Node x,Queue<key> keys){
        //判断二叉查找树是否为空
        if(x == null){
            return;
        }

        if(x.right != null) {
            lastrgodic(x.right, keys);
        }
        if(x.left != null){
            lastrgodic(x.left, keys);
        }
        keys.enqueue(x.key);
    }

    //层序遍历
    public Queue<key> layerErgodic(){
        Queue<key> keys = new Queue<key>();
        Queue<Node> nodes = new Queue<Node>();
        nodes.enqueue(root);
        while(!nodes.isEmpty()){
            Node n = nodes.dequeue();
            keys.enqueue(n.key);
            if(n.left != null){
                nodes.enqueue(n.left);
            }
            if(n.right != null){
                nodes.enqueue(n.right);
            }
        }
        return keys;
    }

    //计算二叉树的最大深度
    public int maxDepth(){
        return maxDepth(root);
    }
    public int maxDepth(Node x){
        if(x == null){
            return 0;
        }
        int max = 0;
        int maxL = 0;
        int maxR = 0;
        if(x.left != null){
            maxL = maxDepth(x.left);
        }
        if(x.right != null){
            maxR = maxDepth(x.right);
        }
        max = maxL>maxR?(maxL+1):(maxR+1);
        return max;
    }
}
