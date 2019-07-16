public class sol_4 {
    public double findMedianSortedArrays_myFirstSubmittedExample(int[] nums1, int[] nums2) {
        double median = 0;
        //since it asks the runtime complexity to be O(log(m+n)), we consider binary search tree
        // nums1: left1, right1,
        // nums2: left2, right2,
        // nums1: 2, 5,
        // nums2: 1, 3, 4
        int len1 = nums1.length; int len2 = nums2.length;
        median = len1 <= len2 ? findMedianSortedArraysHelper(nums1, nums2) : findMedianSortedArraysHelper(nums2, nums1);
        return median;
    }

    public double findMedianSortedArraysHelper(int[] nums1, int[] nums2) {
        int len1 = nums1.length; int len2 = nums2.length;
        int half = (len1 + len2 + 1) / 2;
        boolean odd = ((len1 + len2) % 2 == 1) ? true : false;
        double median = 0;
        // null case
        if (len1 == 0) {
            //means there is zero number in the nums1
            median = odd ? nums2[len2/2] : ((double)nums2[len2/2 - 1] + (double)nums2[len2/2])/2;
            return median;
        }
        // 1
        // 2, 3, 4, 5, 6, 7 half = 4 aPart = 2, bPart = 2
        int aPart = (half) / 2;
        double left1, right1, left2, right2, leftMax, rightMin;
        if (aPart > len1) {
            aPart = len1;
        }
        while (aPart >= 0 && aPart <= half) {
            int bPart = half -aPart;
            left1 = (aPart == 0) ? Math.min(nums1[0], nums2[0]) : nums1[aPart - 1];
            right1 = (aPart == len1) ? Math.max(nums1[len1 - 1], nums2[len2 - 1]) : nums1[aPart];
            left2 = (bPart == 0) ? Math.min(nums1[0], nums2[0]) : nums2[bPart - 1];
            right2 =  (bPart == len2) ? Math.max(nums1[len1 - 1], nums2[len2 - 1]) : nums2[bPart];
            System.out.println("aPart: " + aPart + ", left1: " + left1 + ", right1: " + right1 + ", left2: " + left2 + ", right2: " + right2);
            if ((left1 <= right2) && (left2 <= right1)) {
                leftMax = Math.max(left1, left2);
                rightMin = Math.min(right1, right2);
                System.out.println("odd: " + odd + ", aPart: " + aPart + ", bPart: " + bPart +", leftMax: " + leftMax + ", rightMin: " + rightMin);
                median = odd ? leftMax : (leftMax + rightMin) / 2;
                return median;
            } else if (left1 > right2) {
                aPart = aPart - 1;
            } else if (left2 > right1) {
                aPart = aPart + 1;
            }
        }
        return median;
    }
}
