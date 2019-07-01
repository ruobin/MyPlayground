import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSumSolution {

    List<List<Integer>> results = new ArrayList<List<Integer>>();

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        findNSum(nums, 0, 4, target, new ArrayList());
        return results;
    }

    private void findNSum(int[] nums, int startIndex, int N, int target, List intermediateResults) {
        if (nums.length < N) return;

        if (N == 2) {
            int left = startIndex;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {

                    intermediateResults.add(nums[left]);
                    intermediateResults.add(nums[right]);
                    results.add(new ArrayList(intermediateResults));
                    intermediateResults.remove(intermediateResults.size() - 1);
                    intermediateResults.remove(intermediateResults.size() - 1);


                    //de-duplicate
                    while (nums[left] == nums[left + 1] && left + 1 < right) {
                        left++;
                    }
                    while (nums[right] == nums[right - 1] && right - 1 > left) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        } else {
            for (int i = startIndex; i < nums.length - N + 1; i++) {
                if (i == startIndex || nums[i - 1] != nums[i]) {
                    intermediateResults.add(nums[i]);
                    findNSum(nums, i + 1, N - 1, target - nums[i], intermediateResults);
                    intermediateResults.remove(intermediateResults.size() - 1);
                }
            }
        }
    }
}
