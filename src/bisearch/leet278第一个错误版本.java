package bisearch;

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
public class leet278第一个错误版本 {
    public int firstBadVersion(int n){
        int l = 0, h = n-1;
        while(l < h){
            int mid = l + (h-l)/2;
            if(isBadVersion(mid)){
                h = mid;
            }else{
                l = mid +1;
            }
        }
        return h;
    }
    public boolean isBadVersion(int version){
        return Math.random()>version?true:false;
    }
}
