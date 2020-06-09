package algo;

public class MaximumValueWithinTheWindow {

    static int windowSize = 3;

    static int[] A = {3, 1, 2, 5, 4};

    public static long[] getMaximumValueWithinTheWindow(long[] A, int windowSize) {

        int windowStart = 0;
        int windowEnd = windowSize - 1;

        long[] result = new long[A.length - windowSize + 1];

        while (windowEnd < A.length) {
            long maxInWindow = A[windowStart];
            for (int i = windowStart + 1; i <= windowEnd; i++) {
                maxInWindow = Math.max(maxInWindow, A[i]);
            }
            result[windowStart] = maxInWindow;

            windowStart++;
            windowEnd++;
        }
        return result;
    }
}
