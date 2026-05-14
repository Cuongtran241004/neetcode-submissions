class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n - k + 1];

        // lưu các index của nums
        Deque<Integer> queue = new LinkedList<>();
        int l = 0, r = 0;        

        while(r < n){
            // Nếu queue không empty và phần tử last bé hơn phần tử được add vào
            while(!queue.isEmpty() && nums[queue.getLast()] < nums[r]){
                queue.removeLast();
            }

            queue.addLast(r);

            if(l > queue.getFirst()){
                queue.removeFirst();
            }

            if(r + 1 >= k){
                output[l] = nums[queue.getFirst()];
                l++;
            }

            r++;

        }

        return output;
    }
}
