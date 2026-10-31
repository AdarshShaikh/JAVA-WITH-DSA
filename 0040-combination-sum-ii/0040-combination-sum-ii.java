import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] candidates, int remaining, int start,
                           List<Integer> path, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int num = candidates[i];

            // Skip duplicate choices at the same recursion level
            if (i > start && num == candidates[i - 1]) continue;

            // Sorted array allows early termination
            if (num > remaining) break;

            path.add(num);
            backtrack(candidates, remaining - num, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }
}