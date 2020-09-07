package greed;

public class leet605种花问题 {
    public boolean canPlaceFlowers(int[] flowerbed,int n){
        if(flowerbed == null) return false;
        int cont = 0;
        for(int i=0;i<flowerbed.length;i++){
            if(flowerbed[i] == 1){
                continue;
            }
            //前一个状态和后一个状态的考虑
            int pre = i==0?0:flowerbed[i-1];
            int next = i==flowerbed.length-1?0:flowerbed[i+1];
            //只有满足前后都为0，才能种下花
            if(pre == 0 && next == 0){
                cont++;
                //种完之后将此处标为1
                flowerbed[i] = 1;
            }
        }
        return cont>=n;
    }
}
