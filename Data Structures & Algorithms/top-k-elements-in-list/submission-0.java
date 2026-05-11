class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Đếm frequency của 1 element
        Map<Integer, Integer> count = new HashMap<>();
        for(int num : nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // Chuyển Map thành arr --> sort theo frequency
        List<int[]> arr = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : count.entrySet()){
            arr.add(new int[] { entry.getValue(), entry.getKey()});
        }
        arr.sort((a, b) -> b[0] - a[0]);

        // Lấy top k có frequency cao nhất
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = arr.get(i)[1];
        }

        return res;
    }
}
