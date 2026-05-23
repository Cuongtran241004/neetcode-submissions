class Solution {
    public int reverseBits(int n) {
        int res = 0;

        for(int i = 0; i < 32; i++){
            // n >> i: dịch bit thứ i về bên phải
            // & 1 để giữ lại bit cuối cùng
            // value của bit chỉ chứa 0 hoặc 1;
            int bit = (n >> i) & 1;
            res += bit << (31 - i);
        }
        return res;
    }
}
