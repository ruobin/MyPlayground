package algo;

public class RemoveDuplicatesFromSortedArraySolution {
    public int removeDuplicates(int[] nums) {
        int firstPointer = 0;
        int secondPointer = 1;
        while (secondPointer < nums.length) {
            if (nums[secondPointer] == nums[firstPointer]) {
                secondPointer++;
            } else {
                firstPointer++;
                nums[firstPointer] = nums[secondPointer];
                secondPointer++;
            }
        }
        return firstPointer + 1;
    }
}
