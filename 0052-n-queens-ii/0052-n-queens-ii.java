class Solution {
    public int totalNQueens(int n) {
        return solve(n, 0, 0, 0, 0);
    }

    private int solve(int n, int row, int cols, int diag1, int diag2) {
        if (row == n) return 1;

        int count = 0;
        int mask = (1 << n) - 1;

        int available = mask & ~(cols | diag1 | diag2);

        while (available != 0) {
            int bit = available & -available;
            available -= bit;

            count += solve(
                n,
                row + 1,
                cols | bit,
                (diag1 | bit) << 1,
                (diag2 | bit) >>> 1
            );
        }

        return count;
    }
}