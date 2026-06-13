class Solution {
    // Chia để trị
    /**
    Phương pháp bottom up: khi tính toán số tiền lớn, nó cần kết quả của số tiền nhỏ
    cộng dần vào --> sử dụng dp

    Vòng for 1: duyệt qua từng bài toán con
    Vòng for 2: duyệt qua các lựa chọn (đồng xu)
    i: đóng vai trò là số tiền mục tiêu (amount)
    */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
