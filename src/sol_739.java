import java.util.Stack;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class sol_739 {
//    This problem has 3 answers
//    1. Brute Force
//    2. Stack
//    3. Optimized Stack (Considering calculated values)

    // 72 73 59 69 78
    public static int[] dailyTemperatures_method2(int[] T) {
        int len = T.length;
        int[] ans = new int[len];
        Stack<Integer> stack = new Stack();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) stack.pop();
//            if (Stack.isEmpty()) ans[i] = 0;
//            ans[i] = Stack.pop() - i;
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] expectedAns = new int[]{1, 1, 4, 2, 1, 1, 0, 0};
        int[] actualAns = dailyTemperatures_method2(T);
        for (int i = 0; i < T.length; i++) {
            System.out.println("expectedAns" + i + ": " + expectedAns[i] + ", actualAns "  + i + ": " + actualAns[i]);
        }
    }
}
