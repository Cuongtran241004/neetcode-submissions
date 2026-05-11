class Solution {
    public boolean isValidSudoku(char[][] board) {
        // tracking bitmask của từng row, col, square
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] squares = new int[9];

        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                if(board[r][c] == '.') continue;

                // convert char to int
                int val = board[r][c] - '0';
                // dịch bit sang trái 1 giá trị bằng val
                int mask = 1 << val;
                // (r / 3) * 3: cho biết ở tầng thứ mấy
                // c + 3: xác định value ở ô nào   
                // 0  1  2
                // 3  4  5
                // 6  7  8
                int sIdx = (r / 3) * 3 + (c / 3);
                if((rows[r] & mask) != 0
                ||  (cols[c] & mask) != 0
                ||  (squares[sIdx] & mask) != 0)
                {
                    return false;
                }

                rows[r] |= mask;
                cols[c] |= mask;
                squares[sIdx] |= mask;
            }
        }
        return true;
    }
}
