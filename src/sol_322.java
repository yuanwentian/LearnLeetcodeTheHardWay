public class sol_322 {
    //dp, notice that using amount + 1 to initialize
    public int coinChange_dp(int[] coins, int amount) {
        if (amount == 0 || coins == null) {
            return 0;
        }
        int[] numOfCoins = new int[amount + 1];
        numOfCoins[0] = 0;
        for (int i = 1; i <= amount; i++) {
            numOfCoins[i] = amount + 1;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && numOfCoins[i - coins[j]] != -1) {
                    numOfCoins[i] = Math.min(numOfCoins[i], numOfCoins[i - coins[j]] + 1);
                }
            }
        }
        if (numOfCoins[amount] == amount + 1) {
            return -1;
        }
        return numOfCoins[amount];
    }
}