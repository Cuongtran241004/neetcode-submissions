class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Sử dụng HashMap
        // Value - Position 
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < numbers.length; i++){
            int tmp = target - numbers[i];
            if(map.containsKey(tmp)){
                return new int[]{map.get(tmp) + 1, i + 1};
            }

            map.put(numbers[i], i);
        }
        return new int[0];
    }
}
