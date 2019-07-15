public class sol_70 {
    //bottom-up dp
    public int climbStairs_dp(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[]  numOfWays = new int[n + 1];
        for (int i = 0; i < 3; i++) {
            numOfWays[i] = i;
        }
        for (int i = 3; i <= n; i++) {
            numOfWays[i] = numOfWays[i-1] + numOfWays[i-2];
        }
        return numOfWays[n];
    }
}
