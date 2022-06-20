package algo;

import java.util.*;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);
        findCombination(0, candidates, target, res, new ArrayList<>());

        return res;
    }

    public void findCombination(int idx, int[] candidates, int target, List<List<Integer>> res, List<Integer> ans) {
        if (target == 0) {
            res.add(new ArrayList<>(ans));
        }

        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue;
            } else if (target < candidates[i]) {
                return;
            } else {
                ans.add(candidates[i]);
                findCombination(i + 1, candidates, target - candidates[i], res, ans);
                ans.remove(ans.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        int[] candidates = { 2, 5, 2, 1, 2 }; // {1,2,2,2,5}
        List<List<Integer>> results = new CombinationSum2().combinationSum2(candidates, 5);
        for (List<Integer> list : results) {
            for (Integer i : list) {
                System.out.print(i);
            }
            System.out.println("");
        }
    }
}
