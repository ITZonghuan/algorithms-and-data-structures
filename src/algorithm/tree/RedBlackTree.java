package algorithm.tree;

public class RedBlackTree<Key extends Comparable<Key>,Value> {
    //成员变量：根结点，结点个数，两个静态常量：红、黑
    private Node root;
    private int N;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

/*
    //问题：红黑树默认构造函数中Node root初始化的color是true 还是 false？

    public RedBlackTree() {
        this.root = new Node(null,null,null,null,BLACK);
        this.N = 0;
    }
*/
    //内部结点类
    private class Node{
        //键值对，左右结点和链接结点的颜色，构造函数
        private Key key;
        private Value val;
        private Node left;
        private Node right;
        private boolean color;
        public Node(Key key, Value val, Node left, Node right, boolean color) {
            this.key = key;
            this.val = val;
            this.left = left;
            this.right = right;
            this.color = color;
        }

    }

    //判断当前结点的父指向链接是否为红色
    public boolean isRed(Node node){
        if(node == null){
            return false;
        }
        return node.color == RED;
    }

    //左旋调整
    private Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    //右旋调整
    private Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    //颜色反转，相当于完成拆分4-结点
    private void flipColor(Node h){
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    //在整个树上完成插入操作
    public void put(Key key,Value val){
        root = put(root,key,val);
        root.color = BLACK;
    }


    //在制定树中完成插入操作，并返回添加元素后新的树
    private Node put(Node h,Key key,Value val){
        if(h == null){
            N++;
            //问题：为什么new一个结点要是红色的呢？
            return new Node(key,val,null,null,RED);
        }
        int cmp = h.key.compareTo(key);
        if(cmp>0){
            h.left = put(h.left,key,val);
        }else if(cmp<0){
            h.right = put(h.right,key,val);
        }else{
            h.val = val;
        }

        if(!isRed(h.left) && isRed(h.right)){
            //左旋
            h = rotateLeft(h);
        }
        if(isRed(h.left) && isRed(h.left.left)){
            //右旋
            h = rotateRight(h);
        }
        if(isRed(h.left) && isRed(h.right)){
            //颜色反转
            flipColor(h);
        }
        return h;
    }

    //根据key，从树中找出对应的值
    public Value get(Key key){
        return get(root,key);
    }

    //从制定树x中，找出key对应的值
    private Value get(Node x,Key key){
        if(x == null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if(cmp<0){
            return get(x.left,key);
        }else if(cmp >0){
            return get(x.right,key);
        }else{
            return x.val;
        }
    }

    //获取树中元素的个数
    public int size(){
        return N;
    }

}
