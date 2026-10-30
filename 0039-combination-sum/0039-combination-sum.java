import java.util.*;

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    int[] candidates;
    int[] path = new int[40];
    int size;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;

        dfs(0, target);

        return ans;
    }

    private void dfs(int start, int remaining) {
        if (remaining == 0) {
            List<Integer> list = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                list.add(path[i]);
            }
            ans.add(list);
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int num = candidates[i];

            if (num > remaining) break;

            path[size++] = num;
            dfs(i, remaining - num);
            size--;
        }
    }
}