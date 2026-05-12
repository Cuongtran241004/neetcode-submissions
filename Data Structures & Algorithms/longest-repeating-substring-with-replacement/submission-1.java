class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int res = 0;
        
        // char, frequency
        Map<Character, Integer> count = new HashMap<>();
        int maxF = 0;
        for(int r = 0; r < s.length(); r++){
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            maxF = Math.max(maxF, count.get(s.charAt(r)));

            // len = r - l + 1
            // len - maxF: có nghĩa là ký tự ngoại lai cần thay đổi
            // Chỉ hợp lệ nếu nó không vượt quá k (<= k)
            while(r - l + 1 - maxF > k){
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
