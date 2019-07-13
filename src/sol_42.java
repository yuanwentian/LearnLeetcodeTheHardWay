public class sol_42 {

    //my solution dp O(n)
    public static int trapDP(int[] height) {
        int totalWater = 0;
        int n = height.length;
        int[] water = new int[n];
        //null case
        if (n == 0 || n == 1) {
            return 0;
        }
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        //edge case
        water[0] = 0;
        water[n - 1] = 0;
        //compute maxLeft[]
        maxLeft[0] = 0;
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(height[i - 1], maxLeft[i - 1]);
        }
        //compute maxRight[]
        maxRight[n-1] = 0;
        for (int i = n - 2; i > 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }
        //compute water[]
        for (int i = 1; i < n - 1; i++) {
            water[i] = Math.max(0, Math.min(maxLeft[i], maxRight[i]) - height[i]);
        }
        //computer totalWater
        for (int i = 0; i < n; i++) {
            totalWater += water[i];
        }
        return totalWater;
    }

    //two pointers
    public int trapTwoPointers(int[] height) {
        int totalWater = 0;
        int n = height.length;
        if (n == 0 || n == 1) {
            return 0;
        }
        int leftMax = height[0];
        int rightMax = height[n - 1];
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] < leftMax) {
                    totalWater += leftMax - height[left];
                } else {
                    leftMax = height[left];
                }
                left++;
            } else {
                if (height[right] < rightMax) {
                    totalWater += rightMax - height[right];
                } else {
                    rightMax = height[right];
                }
                right--;
            }
        }
        return totalWater;
    }

    // brute force
    public static int trapBruteForce(int[] height) {
        if (height.length == 0 || height.length == 1) {
            return 0;
        }
        int[] water = new int[height.length];
        int totalWater = 0;
        water[0] = 0;
        water[height.length - 1] = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int max_left = findMaxElement(height, 0, i);
            int max_right = findMaxElement(height, i + 1, height.length);
            water[i] = Math.min(max_left, max_right) - height[i];
            water[i] = Math.max(0, water[i]); // there is cases when water[i] can be less than 0;
        }
        for (int i = 0; i < water.length; i++) {
            totalWater += water[i];
        }
        return totalWater;
    }

    public static int findMaxElement(int[] nums, int i, int j) {
        int max = nums[i];
        for (int k = i + 1; k < j; k++) {
            max = Math.max(max, nums[k]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        trapBruteForce(height);
        System.out.println("finished");
    }
}
