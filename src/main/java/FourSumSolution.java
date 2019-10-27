import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSumSolution {

    List<List<Integer>> results = new ArrayList<List<Integer>>();

    public List<List<Integer>> fourSum(int[] numbs, int target) {
        Arrays.sort(numbs);
        findNSum(numbs, 0, 4, target, new ArrayList());
        return results;
    }

    private void findNSum(int[] numbs, int startIndex, int N, int target, List intermediateResults) {
        if (numbs.length < N) return;

        if (N == 2) {
            int left = startIndex;
            int right = numbs.length - 1;
            while (left < right) {
                if (numbs[left] + numbs[right] == target) {

                    intermediateResults.add(numbs[left]);
                    intermediateResults.add(numbs[right]);
                    results.add(new ArrayList(intermediateResults));
                    intermediateResults.remove(intermediateResults.size() - 1);
                    intermediateResults.remove(intermediateResults.size() - 1);


                    //de-duplicate
                    while (numbs[left] == numbs[left + 1] && left + 1 < right) {
                        left++;
                    }
                    while (numbs[right] == numbs[right - 1] && right - 1 > left) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (numbs[left] + numbs[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        } else {
            for (int i = startIndex; i < numbs.length - N + 1; i++) {
                if (i == startIndex || numbs[i - 1] != numbs[i]) {
                    intermediateResults.add(numbs[i]);
                    findNSum(numbs, i + 1, N - 1, target - numbs[i], intermediateResults);
                    intermediateResults.remove(intermediateResults.size() - 1);
                }
            }
        }
    }
}
