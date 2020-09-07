package algorithm.sortways.test;

import algorithm.sortways.sort.Insertion;
import algorithm.sortways.sort.Merge;
import algorithm.sortways.sort.Quick;
import algorithm.sortways.sort.Shell;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class SortCompare {
    public static void main(String[] args) throws Exception{
        //1、创建一个ArrayList集合，保存读取出来的整数
        ArrayList<Integer> list = new ArrayList<Integer>();

        //2、创建缓存读取流BufferReader,读取数据，并储存到ArrayList中
        String filepath = "E:\\====java_file\\stata_algorithm\\src\\algorithm\\Bubble\\reverse_arr.txt";
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filepath)));
        String line = null;
        while ((line = reader.readLine()) != null) {
            //line是字符串，把line转换成Integer，存储到集合中
            int i = Integer.parseInt(line);
            list.add(i);
        }
        reader.close();

        //3、把ArrayList转换成数组
        Integer[] a = new Integer[list.size()];
        list.toArray(a);
        //4、调用测试代码
        //testInsertion(a);//33390毫秒
        //testShell(a);//13毫秒
        //testMerge(a);//294毫秒
        //testQuick(a); //java.lang.StackOverflowError 堆内存溢出
    }

    //测试插入排序
    private static void testInsertion(Integer[] a) {
        //1、获取执行之前的时间
        long start = System.currentTimeMillis();
        //2、执行算法
        Insertion.sort(a);
        //3、获取执行之后的时间
        long end = System.currentTimeMillis();
        System.out.println("插入排序的执行时间是：" + (end - start) + "毫秒");
    }

    //测试希尔排序
    private static void testShell(Integer[] a) {
        //1、获取执行之前的时间
        long start = System.currentTimeMillis();
        //2、执行算法
        Shell.sort(a);
        //3、获取执行之后的时间
        long end = System.currentTimeMillis();
        System.out.println("快速排序的执行时间是：" + (end - start) + "毫秒");
    }

    //测试归并排序
    private static void testMerge(Integer [] a){
        //1、获取执行之前的时间
        long start = System.currentTimeMillis();
        //2、执行算法
        Merge.sort(a);
        //3、获取执行之后的时间
        long end = System.currentTimeMillis();
        System.out.println("归并排序的执行时间是：" + (end - start) + "毫秒");
    }

    //快速排序算法测试
    private static void testQuick(Integer [] a){
        //1、获取执行之前的时间
        long start = System.currentTimeMillis();
        //2、执行算法
        Quick.sort(a);
        //3、获取执行之后的时间
        long end = System.currentTimeMillis();
        System.out.println("归并排序的执行时间是：" + (end - start) + "毫秒");
    }
}
