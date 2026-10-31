import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int[] freq = new int[51];
        for (int num : candidates) freq[num]++;

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(freq, target, 1, path, result);
        return result;
    }

    private void dfs(int[] freq, int remaining, int start,
                     List<Integer> path, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int num = start; num <= remaining; num++) {
            if (freq[num] == 0) continue;

            freq[num]--;
            path.add(num);

            dfs(freq, remaining - num, num, path, result);

            path.remove(path.size() - 1);
            freq[num]++;
        }
    }
}