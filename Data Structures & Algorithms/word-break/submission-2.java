class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // dp[i] đại diện cho chuỗi con từ index i đến cuối
        boolean[] dp = new boolean[s.length() + 1];

        // chuỗi rỗng được coi là phân tách thành công --> true
        dp[s.length()] = true;
        
        for(int i = s.length() - 1; i >= 0; i--){
            for(String w : wordDict){
                // KIỂM TRA ĐIỀU KIỆN KHỚP TỪ
                // 1. (i + w.length()) <= s.length(): chuỗi s còn đủ độ dài để chứa w hay không
                // 2. s.substring(i, i + w.length()).equals(w): 
                if((i + w.length()) <= s.length() &&
                s.substring(i, i + w.length()).equals(w)){
                    dp[i] = dp[i + w.length()];
                }

                // TỐI ƯU:
                if(dp[i]){
                    break;
                }
            }
        }

        return dp[0];
    }
}
