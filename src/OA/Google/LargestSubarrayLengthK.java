package OA.Google;

public class LargestSubarrayLengthK {
    public int[] mySubArray(int[] A, int k) {
        int len = A.length;
        int startIndex = 0;
        int[] largestSubarray = new int[k];
        for (int i = 0; i < len - k; i++) {
            for (int j = 0; j < k; j++) {
                if (A[i+j] > A[startIndex+j]) {
                    startIndex = i;
                    break;
                }
            }
        }
        for (int i = 0; i < A.length - k; i++) {
            largestSubarray[i] = A[startIndex + i];
        }
        return largestSubarray;
    }

    public static int[] subArray(int[] A, int k) {
        int[] largestSubarray = new int[k];
        int startIndex = 0;
        for (int i = 0; i < A.length - k; i++) {
            for (int j = 0; j < k; j++) {
                if (A[i+j] > A[startIndex+j]) {
                    startIndex = i;
                    break;
                }
            }
        }
        for (int i = 0; i < A.length - k; i++) {
            largestSubarray[i] = A[startIndex + i];
        }
        return largestSubarray;
    }
}