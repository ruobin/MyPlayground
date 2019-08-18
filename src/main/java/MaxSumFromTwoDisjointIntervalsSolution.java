public class MaxSumFromTwoDisjointIntervalsSolution {

    public int solution(int[] A, int K, int L) {
        if (K + L > A.length) return -1;

        int sum = 0;
        if (K + L == A.length) {
            for (int i = 0; i < A.length; i++) {
                sum += A[i];
            }
            return sum;
        }

        //k first, L second
        for (int i = 0; i <= A.length - L - K; i++) {
            for (int j = A.length - L; j >= i + K; j--) {
                int sumK = 0;
                int sumL = 0;

                for (int k = 0; k < K; k++) {
                    sumK += A[i + k];
                }
                for (int l = 0; l < L; l++) {
                    sumL += A[j + l];
                }
                sum = Math.max(sumK + sumL, sum);
            }
        }

        //if K equals L, then no need to calculate the same math again
        if (K == L) return sum;

        //L first, K second
        for (int m = 0; m <= A.length - L - K; m++) {
            for (int n = A.length - K; n >= m + L; n--) {
                int sumL = 0;
                int sumK = 0;

                for (int l = 0; l < L; l++) {
                    sumL += A[m + l];
                }
                for (int k = 0; k < K; k++) {
                    sumK += A[n + k];
                }
                sum = Math.max(sumK + sumL, sum);
            }
        }

        return sum;
    }

}
