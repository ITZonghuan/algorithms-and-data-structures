package dp.斐波那契数列;

public class leet213强盗在环形街区抢劫 {
    public int rob(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        //环形街区的核心在于取0->n-2 和 1 -> n-1 的最大值
        return Math.max(rob(nums,0,n-2),rob(nums,1,n-1));
    }
    //环形街区抢劫的核心在于定义一个抢劫函数，传入起始位置和终止位置
    //把它当做不封闭的街区对待
    private int rob(int[] nums,int first,int last){
        int per1 = 0,per2 = 0;
        //for循环，从头到尾
        for(int i = first;i <= last;i++){
            int cur = Math.max(per2,per1 + nums[i]);
            per1 = per2;
            per2 = cur;
        }
        return per2;
    }
}
