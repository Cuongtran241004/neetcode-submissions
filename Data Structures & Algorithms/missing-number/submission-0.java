class Solution {
    public int missingNumber(int[] nums) {
        // [0, n] nên ban đầu gán n = res = nums.length
        int res = nums.length;

        for(int i = 0; i < nums.length; i++){
            res += i - nums[i];
        }

        return res;
    }
}
