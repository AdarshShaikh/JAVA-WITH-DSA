
class Solution {
    private final int[] rows = new int[9];
    private final int[] cols = new int[9];
    private final int[] boxes = new int[9];
    private final int FULL = (1 << 9) - 1;

    public void solveSudoku(char[][] board) {
        // Initialize bit masks
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    int bit = 1 << (board[r][c] - '1');
                    int b = (r / 3) * 3 + c / 3;

                    rows[r] |= bit;
                    cols[c] |= bit;
                    boxes[b] |= bit;
                }
            }
        }

        solve(board);
    }

    private boolean solve(char[][] board) {
        int bestR = -1, bestC = -1;
        int minCount = 10;
        int candidates = 0;

        // Choose the empty cell with the fewest candidates
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') continue;

                int b = (r / 3) * 3 + c / 3;
                int mask = FULL & ~(rows[r] | cols[c] | boxes[b]);
                int count = Integer.bitCount(mask);

                if (count == 0) return false;

                if (count < minCount) {
                    minCount = count;
                    bestR = r;
                    bestC = c;
                    candidates = mask;

                    if (count == 1) break;
                }
            }
            if (minCount == 1) break;
        }

        // No empty cells remain
        if (bestR == -1) return true;

        int b = (bestR / 3) * 3 + bestC / 3;
        int mask = candidates;

        while (mask != 0) {
            int bit = mask & -mask;
            mask -= bit;

            int digit = Integer.numberOfTrailingZeros(bit);
            board[bestR][bestC] = (char) ('1' + digit);

            rows[bestR] |= bit;
            cols[bestC] |= bit;
            boxes[b] |= bit;

            if (solve(board)) return true;

            // Undo the choice
            rows[bestR] ^= bit;
            cols[bestC] ^= bit;
            boxes[b] ^= bit;
            board[bestR][bestC] = '.';
        }

        return false;
    }
}
