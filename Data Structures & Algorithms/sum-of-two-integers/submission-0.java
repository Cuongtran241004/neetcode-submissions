class Solution {
    // XOR: 0 ^ 0 = 0, 1 ^ 0 = 1, 0 ^ 1 = 1, 1 ^ 1 = 0 (1 + 1 = 0 nhớ 1)
    // AND: chỉ xuất hiện khi cả 2 bit đều là 1
    public int getSum(int a, int b) {
        while(b != 0){
            int carry = (a & b) << 1;
            a ^= b;
            b = carry;
        }

        return a;
    }
}
