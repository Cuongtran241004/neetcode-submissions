class Solution {
    /**
    1. ĐỒNG BỘ HÓA CHUỖI CHẴN VÀ LẺ --> BIẾN INPUT THÀNH CHUỖI LẺ
    2. SỬ DỤNG GƯƠNG ĐỐI XỨNG
    */
    public int countSubstrings(String s) {
        int res = 0;
        int[] p = manacher(s);
        for(int i : p){
            res += (i + 1) / 2;
        }
        return res;
    }

    public int[] manacher(String s){
        // Tiền xử lý: aba --> #a#b#a#
        StringBuilder t = new StringBuilder("#");
        for(char c : s.toCharArray()){
            t.append(c).append("#");
        }

        int n = t.length();
        int[] p = new int[n];
        // p[i] cho biết: từ tâm i, ta có thể mở rộng sang trái p[i] ký tự
        // sang phải p[i] ký tự để tạo thành 1 chuỗi đối xứng hoàn hảo
        int l = 0, r = 0;
        for(int i = 0; i < n; i++){
            p[i] = (i < r) ? Math.min(r - i, p[l + (r - i)]) : 0;
            while(i + p[i] + 1 < n && i - p[i] - 1 >= 0 &&
                t.charAt(i + p[i] + 1) == t.charAt(i - p[i] - 1)){
                    p[i]++;
                }

            if(i + p[i] > r){
                l = i - p[i];
                r = i + p[i];
            }    
        }

        return p;
    }
}
