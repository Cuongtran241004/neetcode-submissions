// Bottom - up
class Solution {
    // Rule: bạn chỉ được đi xuống hoặc sang phải
    // Count" số cách đi ô hiện tại = way of(ô phía trên) + way of(ô bên trái)
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        // base case - chỉ có 1 cách duy nhất để đi đến đích từ ô phía trên hoặc ô bên trái
        dp[m - 1][n - 1] = 1;

        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                dp[i][j] += dp[i + 1][j] + dp[i][j + 1]; 
            }
        }

        return dp[0][0];

    }
}
