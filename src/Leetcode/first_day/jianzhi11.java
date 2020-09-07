package Leetcode.first_day;

/**
 * 旋转数组的最小数字
 */

public class jianzhi11 {
    public int minArray(int[] numbers){
        int i =0,j=numbers.length-1;
        while(i<j){
            int m = (i+j)/2;
            if(numbers[m]>numbers[j]){
                i = m +1;
            }else if(numbers[m]<numbers[j]){
                j = m;
            }else{
                j--;
            }
        }
        return numbers[i];
    }
}
