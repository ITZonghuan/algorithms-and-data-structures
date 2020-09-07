package Tree.Trie;

/**
 * 深刻理解这里面复写的sum()方法
 */
public class leet677实现一个Trie用来求前缀和 {
    class MapSum{
        private class Node{
            Node[] child = new Node[26];
            int val;
        }
        private Node root = new Node();

        public MapSum(){

        }
        public void insert(String key,int val){

        }
        //复写insert
        private void insert(String key,Node node,int val){
            if(node == null) return;
            if(key.length() == 0){
                node.val = val;
                return;
            }
            int index = indexForChar(key.charAt(0));
            if(node.child[index] == null){
                node.child[index] = new Node();
            }
            insert(key.substring(1),node.child[index],val);
        }
        private int indexForChar(char c){
            return c - 'a';
        }

        public int sum(String prefix){
            return sum(prefix,root);
        }

        //复写sum方法,此方法实在没有理解
        private int sum(String prefix,Node node){
            if(node == null) return 0;
            if(prefix.length() != 0){
                int index = indexForChar(prefix.charAt(0));
                return sum(prefix.substring(1),node.child[index]);
            }
            int sum = node.val;
            for(Node child:node.child){
                sum += sum(prefix,child);
            }
            return sum;
        }

    }
}
