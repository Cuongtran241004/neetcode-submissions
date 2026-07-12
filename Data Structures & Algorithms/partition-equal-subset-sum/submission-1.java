class Solution {
    /**
    * Bẻ đôi sum của nums = target
    * Tìm xem có tồn tại một tập hợp con nào trong mảng có tổng
    * đúng bằng target hay không?
    * dp[j] = true: có thể chọn một vài số trong mảng để cộng lại = j
    * dp[j] = false: hiện tại chưa có cách nào để tổng = j
    */
    public boolean canPartition(int[] nums) {
        if(sum(nums) % 2 != 0){
            return false;
        }

        int target = sum(nums) / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for(int i = 0; i < nums.length; i++){
            for(int j = target; j >= nums[i]; j--){
                dp[j] = dp[j] || dp[j -  nums[i]];
            }
        }

        return dp[target];
    }

    private int sum(int[] nums){
        int total = 0;

        for(int num : nums){
            total += num;
        }

        return total;
    }
}
