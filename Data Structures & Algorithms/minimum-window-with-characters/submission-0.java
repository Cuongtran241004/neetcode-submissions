class Solution {
    /**
    * 
    */
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() < t.length()) return "";

        // Lưu trữ số lần xuất hiện của các char trong t
        int[] mapT = new int[58];
        for(char c : t.toCharArray()){
            mapT[c - 'A']++;
        }

        int l = 0, minLen = Integer.MAX_VALUE;
        int startIdx = -1;
        
        int count = t.length();
        for(int r = 0; r < s.length(); r++){
            int rightIdx = s.charAt(r) - 'A';

            // Nếu char này nằm trong t
            if(mapT[rightIdx] > 0){
                count--;
            }

            mapT[rightIdx]--;
            
            while(count == 0){
                if(r - l + 1 < minLen){
                    minLen = r - l + 1;
                    startIdx = l;
                }

                int leftIdx = s.charAt(l) - 'A';
                mapT[leftIdx]++;

                if(mapT[leftIdx] > 0){
                    count++;
                }

                l++;
            }
        }

        return startIdx == -1 ? "" : s.substring(startIdx, startIdx + minLen);
    }
}
