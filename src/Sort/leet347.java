package Sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 桶排序
 */
public class leet347 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,3,3,2,2,3,2};
        Integer[] res = topKFrequent(nums,2);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
    public static Integer[] topKFrequent(int[] nums, int k){
        Map<Integer,Integer> map = new HashMap<>();
        //频次统计
        for(int num:nums){
            //map的getOrDefault方法
            map.put(num,map.getOrDefault(num,1));
        }
        List[] buckets = new ArrayList[nums.length + 1]; //不可能出现0次
        //map.keySet()
        for(int i:map.keySet()){
            int value = map.get(i);
            //桶排序的思想就是当前索引值代表该索引处元素的频数
            if(buckets[value] == null) buckets[value] = new ArrayList();
            buckets[value].add(i);
        }
        List<Integer> topK = new ArrayList<>();
        for(int i = buckets.length - 1;i>=0 && topK.size()<=k;i--){
            if(buckets[i] == null) continue;
            if(buckets[i].size() < k){
                topK.addAll(buckets[i]);
            }else{
                topK.addAll(buckets[i].subList(0,k-topK.size()));
            }
        }
        Integer[] res = new Integer[k];
        //list.toArray(int[] a)方法，将集合变为数组
        return topK.toArray(res);
    }
}

