class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Track seen numbers for rows, columns, and 3x3 boxes
        // Rows/cols/boxes are 9 in total; numbers are 1-9 (index 0 to 8)
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];
                
                // Skip empty cells
                if (val == '.') {
                    continue;
                }
                
                // Convert char digit to 0-based integer index (e.g., '5' -> 4)
                int numIdx = val - '1';
                int boxIdx = (r / 3) * 3 + (c / 3);
                
                // If the number was already seen in this row, column, or box, it's invalid
                if (rows[r][numIdx] || cols[c][numIdx] || boxes[boxIdx][numIdx]) {
                    return false;
                }
                
                // Mark the number as seen
                rows[r][numIdx] = true;
                cols[c][numIdx] = true;
                boxes[boxIdx][numIdx] = true;
            }
        }
        
        return true;
        
    }
}
