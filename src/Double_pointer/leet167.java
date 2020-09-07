package Double_pointer;

import java.util.Arrays;

//两数之后
public class leet167 {
    public static void main(String[] args) {
        int[] numbers = new int[]{2,7,11,15};
        int[] ints = twoSum(numbers, 9);
        //Java中输出数组的方法：Arrays.toString(int[] a)
        /**
         * Arrays常用的方法有：
         * 1、Arrays.copeOf(arr,arr.length); 复制数组
         * 2、Arrays.toString(int[] a); 输出数组
         * 3、Arrays.sort(int[] a); 数组排序
         * 补充：Arrays实现多维数组排序：
         * Arrays.sort(arr, new Comparator<int[]>() {
         *             @Override
         *             public int compare(int[] o1, int[] o2) {
         *                 if (o1[0]!=o2[0]){
         *                     return o1[0]-o2[0];
         *                 }else {
         *                     if (o1[1]!=o2[1]){
         *                         return o1[1]-o2[1];
         *                     }else {
         *                         return o1[2]-o2[2];
         *                     }
         *                 }
         *             }
         *         });
         *
         * 4、Arrays.asList(a,b,c);  // 将当前组合变为list
         */

        System.out.println(Arrays.toString(ints));
    }
    public static int[] twoSum(int[] numbers,int target){
        if(numbers == null) return null;
        //双指针，定义两个指针，一个头，一个尾
        int i = 0,j = numbers.length - 1;
        //终止条件是，i==j时，说明已经遍历完了
        while(i<j){
            int sum = numbers[i] + numbers[j];
            if(sum == target){
                //返回一个数组，大括号{}里面填写元素的值
                //return new int[]{1,2};
                return new int[]{i+1,j+1};
            }else if(sum < target){
                i++;
            }else{
                j--;
            }
        }
        return null;
    }
}
