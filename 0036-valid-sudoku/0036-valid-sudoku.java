class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] boxes = new int[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char currentVal = board[i][j];

                if (currentVal == '.') {
                    continue;
                }

                int num = currentVal - '1';
                int mask = 1 << num;

                if ((rows[i] & mask) != 0) {
                    return false;
                }
                rows[i] |= mask;

                if ((cols[j] & mask) != 0) {
                    return false;
                }
                cols[j] |= mask;

                int boxIndex = (i / 3) * 3 + (j / 3);
                if ((boxes[boxIndex] & mask) != 0) {
                    return false;
                }
                boxes[boxIndex] |= mask;
            }
        }

        return true;
    }
}

