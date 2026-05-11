class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Binary Search
        // 1. duyệt qua 1 phần tử
        // 2. Giả sử phần tử vừa duyệt qua là num1
        // 3. Tìm phần tử còn lại bằng cách sử dụng BS để tìm giá trị tmp = target - num1
        for(int i = 0; i < numbers.length; i++){
            int l = i + 1, r = numbers.length - 1;
            int tmp = target - numbers[i];
            while(l <= r){
                int mid = l + (r - l)/2;
                if(numbers[mid] == tmp){
                    return new int[] {i + 1, mid + 1};
                }else if (numbers[mid] > tmp){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
        }

        return new int[0];
    }
}
