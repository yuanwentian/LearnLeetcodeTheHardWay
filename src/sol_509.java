public class sol_509 {
    //Bottom-up DP
    public int fib_dp(int N) {
        int[] F = new int[N + 1];
        if (N == 0 || N == 1) return N;
        F[0] = 0;
        F[1] = 1;
        for (int i = 2; i <= N; i++) {
            F[i] = F[i-1] + F[i-2];
        }
        return F[N];
    }
}
