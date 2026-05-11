class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            // Phần tử đầu tiên > 0 --> không thể có tổng của 3 số = 0 --> dừng
            if(nums[0] > 0) break;

            // Nếu 2 phần tử kế tiếp có giá trị bằng nhau thì bỏ qua
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1, r = nums.length - 1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum > 0){
                    r--;
                }else if (sum < 0){
                    l++;
                }else{
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;

                    // Bỏ qua các phần tử trùng nhau
                    while(l < r && nums[l] == nums[l - 1]){
                        l++;
                    }
                }
            }

        }

        return res;
    }
}
