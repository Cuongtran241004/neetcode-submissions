class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);

        int res = 0, streak = 0;
        int i = 0, curr = nums[0];
        while(i < nums.length){
            if(curr != nums[i]){
                curr = nums[i];
                streak = 0;
            }
            while(i < nums.length && curr == nums[i]){
                i++;
            }
            streak++;
            curr++;
            res = Math.max(streak, res);
        }

        return res;
    }
}
