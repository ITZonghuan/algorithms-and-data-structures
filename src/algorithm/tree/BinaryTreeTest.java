package algorithm.tree;

import algorithm.table.linear.Queue;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree<Integer, String> tre = new BinaryTree<Integer, String>();

        //测试插入
        tre.put(3,"小华");
        tre.put(0,"小王");
        tre.put(1,"小芳");
        tre.put(2,"小美");
        tre.put(4,"小赖");
        tre.put(8,"小万");
        tre.put(15,"小w");
        tre.put(28,"小d");
        tre.put(20,"小名");
        tre.put(3,"小华2");

        //测试获取
        String s = tre.get(3);
        System.out.println("key为3的值为" + s);
        //测试删除

        tre.delete(20);

        int size = tre.size();
        System.out.println("目前元素的个数为：" + size);

        //最大的键
        System.out.println("最大的键为：" + tre.max());

        //最小的键
        System.out.println("最大的键为：" + tre.min());

        //前序遍历
        Queue<Integer> preQueue = tre.prergodic();
        System.out.println("前序遍历：");
        for (Integer i : preQueue) {
            String value = tre.get(i);
            System.out.println(value + "---" + i);
        }

        //中序遍历
        Queue<Integer> midQueue = tre.midrgodic();
        System.out.println();
        System.out.println("中序遍历：");
        for (Integer i : midQueue) {
            String value = tre.get(i);
            System.out.println(value + "---" + i);
        }
        //后序遍历
        Queue<Integer> lastQueue = tre.lastrgodic();
        System.out.println();
        System.out.println("后序遍历：");
        for (Integer i : lastQueue) {
            String value = tre.get(i);
            System.out.println(value + "---" + i);
        }
        //层序遍历
        Queue<Integer> layerQueue = tre.layerErgodic();
        System.out.println();
        System.out.println("层序遍历：");
        for (Integer i : layerQueue) {
            String value = tre.get(i);
            System.out.println(value + "---" + i);
        }

        //二叉树深度
        System.out.println("二叉树的深度为：" + tre.maxDepth());
    }
}
