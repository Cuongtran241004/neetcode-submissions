class Solution {
    public int longestConsecutive(int[] nums) {
        // Using set to remove duplicate value
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        
        int longest = 0;
        for(int num : set){
            // Chỉ chạy thuật toán nếu như số này không phải
            // đứng đầu chuỗi
            if(!set.contains(num - 1)){
                int length = 1;
                while(set.contains(num + length)){
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}
