class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int ROWS = grid.length, COLS = grid[0].length;
        int fresh = 0, time = 0;

        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(grid[r][c] == 1){
                    fresh++;
                }
                if(grid[r][c] == 2){
                    q.offer(new int[]{r, c});
                }
            }
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(fresh > 0 && !q.isEmpty()){
            int length = q.size();
            for(int i = 0; i < length; i++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for(int[] dir : directions){
                    int row = r + dir[0];
                    int col = c + dir[1];
                    if(row >= 0 && row < ROWS &&
                     col >= 0 && col < COLS &&
                     grid[row][col] == 1){
                        grid[row][col] = 2;
                        q.offer(new int[]{row, col});
                        fresh--;
                     }
                }
            }
            time++;
        }

        return fresh == 0 ? time : -1;
    }
}
