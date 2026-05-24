class Solution {
    // x xor 0 = x
    // x xor x = 0
    // thứ tự có thể giao hoán
    // Nếu số nào xuất hiện 2 lần thì tự khắc sẽ bị triệt tiêu
    public int missingNumber(int[] nums) {
        int n = nums.length;

        int res = n;
        for(int i = 0; i < n; i++){
            res ^= i ^ nums[i];
        }

        return res;
    }
}
