package algo;

public class IndicesDistanceSolution {

    public int solution(int[] A) {
        int largestDistance = 0;
        int length = A.length;
        for (int i = 0; i < length - 1; i++) {
            int valueDelta = Math.abs(A[i + 1] - A[i]);
            for (int j = i + 1; j < length; j++) {
                if (Math.abs(A[j] - A[i]) <= valueDelta) {
                    valueDelta = Math.abs(A[j] - A[i]);
                    largestDistance = Math.max(largestDistance, j - i);
                }
            }
        }
        return largestDistance;
    }
}
