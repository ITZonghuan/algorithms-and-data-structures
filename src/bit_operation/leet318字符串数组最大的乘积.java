package bit_operation;

public class leet318字符串数组最大的乘积 {
    public int maxProduct(String[] words){
        int len = words.length;
        int[] temp = new int[words.length];
        for(int i = 0;i<len;i++){
            for(char c:words[i].toCharArray()){
                temp[i] |= (1 << (c - 'a'));
            }
        }
        int max = 0;
        for(int j=0;j<len;j++){
            for(int k =j+1;k<len;k++){
                if((temp[j] & temp[k]) == 0){
                    max = Math.max(max,words[j].length()*words[k].length());
                }
            }
        }
        return max;
    }
}
