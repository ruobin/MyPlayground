package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumSolution {

    public List<List<Integer>> threeSum(int[] nums) {
        //sort nums [-4, -1, -1, 0, 1, 2],
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        //for int m at i, find two int that equals -m in the rest part, also de-duplicate
        for (int i = 0; i < nums.length-2; i++) {
            int m = nums[i];
            int low = i+1;
            int high = nums.length-1;

            //de-duplicate
            if (i-1>=0 && nums[i] == nums[i-1]) {
                continue;
            }

            while(low < high) {

                if(nums[low] + nums[high] == -m) {
                    result.add(Arrays.asList(m, nums[low], nums[high]));

                    //de-duplicate
                    while(nums[low] == nums[low+1] && low+1<high) {
                        low++;
                    }
                    while(nums[high] == nums[high-1] && high-1>low) {
                        high--;
                    }

                    high--;
                    low++;
                } else if(nums[low] + nums[high] > -m) {
                    high--;
                } else{
                    low++;
                }
            }
        }
        return result;
    }
}
