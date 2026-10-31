class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;

        while (i < n) {
            int num = nums[i];

            if (num > 0 && num <= n && nums[num - 1] != num) {
                int temp = nums[num - 1];
                nums[num - 1] = num;
                nums[i] = temp;
            } else {
                i++;
            }
        }

        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}