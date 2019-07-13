public class sol_55 {
    // greedy solution
    public static boolean canJump_greedy(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = lastPos - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
    // dynamic programming Bottom-up
    public static boolean canJump_dp(int[] nums) {
        boolean[] reach = new boolean[nums.length];
        reach[0] = true;
        for (int i = 1; i < nums.length; i++) {
            reach[i] = false;
            for (int j = i - 1; j >= 0; j--) {
                if ((reach[j] == true) && (nums[j] >= (i - j))) {
                    reach[i] = true;
                    break; //This is important to optimize the code
                }
            }
        }
        return reach[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 3};
        canJump_dp(nums);
    }
}
