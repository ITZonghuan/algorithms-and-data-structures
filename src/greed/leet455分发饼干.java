package greed;

import java.util.Arrays;

public class leet455分发饼干 {
    public int findContentChildren(int[] g,int[] s){
        if(g == null || s == null) return 0;
        //贪心算法第一步就是对两个数组进行排序
        Arrays.sort(g);
        Arrays.sort(s);
        int gi=0,si=0;
        while(gi<g.length && si<s.length){
            //只有当饼干大小不小于孩子的胃口时，孩子才往后移动一位
            if(g[gi] <= s[si]){
                gi++;
            }
            //饼干一直保持后移一位
            si++;
        }
        return gi;
    }
}
