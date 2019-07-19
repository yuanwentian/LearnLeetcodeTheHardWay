public class sol_4 {
    //binary search
    public static double findMedianSortedArrays_third(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
    }

    public static double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
        if (aStart > A.length - 1) return B[bStart + k - 1];
        if (bStart > B.length - 1) return A[aStart + k - 1];
        if (k == 1) return Math.min(A[aStart], B[bStart]);

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (aStart + k/2 - 1 < A.length) aMid = A[aStart + k/2 - 1];
        if (bStart + k/2 - 1 < B.length) bMid = B[bStart + k/2 - 1];

        if (aMid < bMid)
            return getkth(A, aStart + k/2, B, bStart,       k - k/2);// Check: aRight + bLeft
        else
            return getkth(A, aStart,       B, bStart + k/2, k - k/2);// Check: bRight + aLeft
    }
    //second code
    class Solution {
        public double findMedianSortedArrays_second(int[] nums1, int[] nums2) {
            double median = 0;
            int len1 = nums1.length; int len2 = nums2.length;
            double leftMax, rightMin;
            //swap nums1 and nums2 if len1 > len2
            if (len1 > len2) {
                int[] temp = nums1;
                nums1 = nums2;
                nums2 = temp;
                len1 = nums1.length;
                len2 = nums2.length;
            }
            //compute median;
            int start = 0; int end = len1; int half = (len1 + len2 + 1) / 2;
            int aPart = (start + end) / 2; int bPart = half - aPart;
            boolean odd = ((len1 + len2) % 2 == 1);
            while (start <= end) {
                aPart = (start + end) / 2;
                bPart = half - aPart;
                System.out.println("aPart: " + aPart + ", bPart: " + bPart);
                if (aPart < end && nums1[aPart] < nums2[bPart - 1]) {
                    start = aPart + 1;
                    System.out.println("1");
                } else if (aPart > start && nums1[aPart - 1] > nums2[bPart]) {
                    end = aPart - 1;
                    System.out.println("2");
                } else {
                    System.out.println("3");
                    if (aPart == 0) {
                        leftMax = nums2[bPart - 1];
                    } else if (bPart == 0) {
                        leftMax = nums1[aPart - 1];
                    } else {
                        leftMax = Math.max(nums1[aPart - 1], nums2[bPart - 1]);
                    }
                    // if total length is odd
                    if (odd) {
                        median = leftMax;
                        return median;
                    } else {
                        if (aPart == len1) {
                            rightMin = nums2[bPart];
                        } else if (bPart == len2) {
                            rightMin = nums1[aPart];
                        } else {
                            rightMin = Math.min(nums1[aPart], nums2[bPart]);
                        }
                        median = (leftMax + rightMin) / 2;
                        return median;
                    }
                }
            }
            return median;
        }
    }

    //first code;
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

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 6, 7, 11};
        int[] nums2 = {2, 5, 8, 9, 10};
        double median = findMedianSortedArrays_third(nums1, nums2);
        System.out.println(median);
    }
}
