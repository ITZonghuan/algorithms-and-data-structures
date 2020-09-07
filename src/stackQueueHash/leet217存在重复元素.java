package stackQueueHash;

import java.util.HashSet;
import java.util.Set;

public class leet217存在重复元素 {
    public boolean containsDuplicate(int[] nums){
        Set<Integer> set = new HashSet();
        for(int i:nums){
            set.add(i);
        }
        return set.size()<nums.length?true:false;
    }
}
