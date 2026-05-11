class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int product = 1;
        int zeroCount = 0;
        for(int num : nums){
            if(num != 0){
                product *= num;
            }else{
                zeroCount++;
            }
        }

        if(zeroCount >= 2){
            return new int[n];
        }

        int[] res = new int[n];
        for(int i = 0 ; i < n; i++){
            if(zeroCount == 0){
                res[i] = product / nums[i];
            }else{
                res[i] = (nums[i] == 0) ? product : 0;
            }
        }
        return res;
    }
}  
