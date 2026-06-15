class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0') return 0;

        int n = s.length();
        int[] dp = new int[n + 1];

        // BASE CASE
        dp[0] = 1; // chuỗi rỗng
        dp[1] = 1; // có 1 ký tự và ký tự đầu tiên khác '0'

        for(int i = 2; i <= n; i++){
            // Cách 1: xét 1 ký tự đơn lẻ (i - 1)
            int oneDigit = s.charAt(i - 1) - '0'; 
            if(oneDigit >= 1 && oneDigit <= 9){
                dp[i] += dp[i - 1]; // Lấy số cách của chuỗi ngay trước nó
            }
            // Cách 2: xét cặp 2 ký tự 
            // (ghép ký tự trước đó: i - 2 và ký tự hiện tại: i - 1)
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2]; // Cộng thêm số cách của chuỗi trước đó nữa
            }
        }

        return dp[n];
    }
}
