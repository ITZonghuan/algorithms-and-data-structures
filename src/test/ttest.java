package test;

public class ttest {
    public static void main(String[] args) {
        String content = "b";
        System.out.println(getSingle(content));
    }
    static char getSingle(String content) {
        char[] chars = content.toCharArray();
        int L = 0, R = chars.length - 1;
        while (L + 2 < R) {
            int mid = (L + R) / 2;
            if ((mid & 1) == 1) {
                //奇数,看前面
                if (chars[mid - 1] == chars[mid]) L = mid + 1;
                else R = mid - 1;
            } else {
                //偶数,看后面
                if (chars[mid + 1] == chars[mid]) L = mid + 2;
                else R = mid;
            }
        }
        char result = 0;
        for (int i = L; i <= R; i++) {
            result ^= chars[i];
        }
        return result;
    }
}
