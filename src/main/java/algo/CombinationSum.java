package algo;

import java.util.*;

public class CombinationSum {

    static List<List<Integer>> results = new ArrayList<List<Integer>>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<Integer>();
        findNextFitElement(list, 0, 0, candidates, target);
        return results;
    }
    
    static List<Integer> findNextFitElement(List<Integer> currentList, int currentSum, int currentIndex, int[] candidates, int target) {
        if (currentSum < target) {
            for (int i = currentIndex; i < candidates.length; i++) {
                int nextSum = currentSum + candidates[i];
                if (nextSum > target)
                    break;
                List<Integer> nextList = new ArrayList<Integer>(currentList);
                nextList.add(candidates[i]);
                findNextFitElement(nextList, nextSum, i, candidates, target);
            }
        }
        if (currentSum == target) {
            results.add(currentList);
            return currentList;
        }
        else
            return null;
    }
    
    public static void main(String[] args) {
        int[] candidates = { 2, 3, 5};
        combinationSum(candidates, 8);
        for (List<Integer> list : results) {
            for (Integer i : list) {
                System.out.print(i);
            }
            System.out.println("");
        }
    }
}
