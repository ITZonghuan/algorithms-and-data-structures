package Tree.Trie;

import java.sql.SQLOutput;

public class leet208实现一个Trie {

    //测试类
    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("start");
        t.insert("end");
        t.insert("begin");
        //System.out.println(t.search("star"));
        System.out.println(t.startsWith("sta"));
        System.out.println(t.startsWith("str"));
        System.out.println(t.startsWith("end"));
    }

    public static class Trie{
        //节点类
        private class Node{
            Node[] childs = new Node[26];
            boolean isLeaf;
        }

        //new一个空的根节点
        private Node root = new Node();

        //初始化
        public Trie(){}

        //插入
        public void insert(String word){
            insert(word,root);
        }

        //复写insert方法
        private void insert(String word,Node node){
            if(node == null) return;
            if(word.length() == 0){
                node.isLeaf = true; //true/false 代表是否为叶子节点,存放整个单词
                return;
            }
            int index = indexForChar(word.charAt(0));
            if(node.childs[index] == null){
                node.childs[index] = new Node();
            }
            insert(word.substring(1),node.childs[index]);
        }

        private int indexForChar(char c){
            return c - 'a';
        }

        //查找，有则返true，无返回false
        public boolean search(String word){
            return search(word,root);
        }

        //复写查找方法
        private boolean search(String word,Node node){
            if(node == null) return false;
            if(word.length() == 0) return node.isLeaf;
            int index = indexForChar(word.charAt(0));
            return search(word.substring(1),node.childs[index]);
        }

        public boolean startsWith(String prefix){
            return startsWith(prefix,root);
        }

        //复写startsWith方法
        private boolean startsWith(String prefix,Node node){
            if(node == null) return false;
            if(prefix.length() == 0) return true;
            int index = indexForChar(prefix.charAt(0));
            return startsWith(prefix.substring(1),node.childs[index]);
        }
    }
}
