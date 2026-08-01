class Solution {
    // java chỉ cung cấp minHeap, nhưng bài toàn này thì cần maxHeap 
    // --> Convert stone trong stones thành -stone
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int s : stones){
            minHeap.offer(-s);
        }

        while(minHeap.size() > 1){
            int first = minHeap.poll();
            int second = minHeap.poll();
            if(second > first){
                // - (second - first)
                minHeap.offer(first - second);
            }
        }
        
        minHeap.offer(0);

        return -1 * minHeap.peek();
    }
}
