class Solution {
    private static final int[][] directions = {
        {1, 0}, // đi xuống
        {-1, 0}, // đi lên
        {0, 1}, // sang phải 
        {0, -1}}; // sang trái

    /**
    Ý tưởng: Tìm 
    */
    public int numIslands(char[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int islands = 0;

        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(grid[r][c] == '1'){
                    dfs(grid, r, c);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int r, int c){
        // bỏ qua nếu grid[r][c] == '0'
        if (r < 0 || c < 0 || r >= grid.length ||
            c >= grid[0].length || grid[r][c] == '0') {
            return;
        }

        // Chuyển grid[r][c] = '1' ==> '0'
        // Nhấn chìm ô hiện tại
        grid[r][c] = '0';
        // duyệt qua 4 direction (lên, xuống, trái. phải)
        for (int[] dir : directions) {
            dfs(grid, r + dir[0], c + dir[1]);
        }
    }
}
