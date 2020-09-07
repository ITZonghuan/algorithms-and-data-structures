package Double_pointer;

/**
 * 归并两个有序数组
 */
public class leet88 {
    public void merge(int[] nums1,int m,int[] nums2,int n){
        int index1 = m-1,index2 = n-1;
        int indexmax = m+n-1;
        // 从后往前遍历
        while(index1 >=0 || index2>=0){
            if(index1 < 0){ // 数组一已经全部转移完毕
                nums1[indexmax--] = nums2[index2--];
            }else if(index2 < 0){ // 数组二已经全部转移完毕
                nums1[indexmax--] = nums1[index1--];
            }else if(nums1[index1]>nums2[index2]){
                nums1[indexmax--] = nums1[index1--];
            }else{
                nums1[indexmax--] = nums2[index2--];
            }
        }
    }
}
