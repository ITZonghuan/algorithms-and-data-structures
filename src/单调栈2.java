import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class 单调栈2 {
    public static void main(String[] args) {
        int[] heights = new int[2];
        System.out.println(Arrays.toString(heights));
    }
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        //定义一个新数组，首尾各多一位
        int[] new_heights = new int[heights.length + 2];
        System.arraycopy(heights,0,new_heights,1,heights.length);
        //for (int i = 1; i < heights.length + 1; i++) new_heights[i] = heights[i - 1];
        //System.out.println(Arrays.toString(new_heights));
        for (int i = 0; i < new_heights.length; i++) {
            //System.out.println(stack.toString());
            while (!stack.isEmpty() && new_heights[stack.peek()] > new_heights[i]) {
                int cur = stack.pop();
                res = Math.max(res, (i - stack.peek() - 1) * new_heights[cur]);
            }
            stack.push(i);
        }
        return res;
    }
}
