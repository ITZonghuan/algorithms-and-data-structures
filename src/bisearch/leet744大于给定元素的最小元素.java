package bisearch;

public class leet744大于给定元素的最小元素 {
    public char nextGreatestLetter(char[] letters,char target){
        int l = 0,h = letters.length - 1;
        while(l <= h){
            int mid = l +(h-l) / 2;
            if(letters[mid] <= target){
                l = mid +1;
            }else{
                h = mid -1;
            }
        }
        return l<=letters.length-1?letters[l]:letters[0];
    }
}
