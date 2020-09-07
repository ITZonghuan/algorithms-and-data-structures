package Arrays;

/**
 * 此题目太具有特俗性了，只能特俗记忆
 */
public class leet667数组相邻差值的个数 {
    public int[] constructArray(int n,int k){
        int[] res = new int[n];
        res[0] = 1;
        for(int i = 1,temp = k;i<=k;i++,temp--){
            res[i] = (i & 1) == 1?res[i-1]+temp:res[i-1]-temp;
        }
        for(int i=k+1;i<n;i++){
            res[i] = i+1;
        }
        return res;
    }
}
