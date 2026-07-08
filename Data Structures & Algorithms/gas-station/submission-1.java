class Solution {
    // gas[i]: lượng gas tại trạm i
    // cost[i]: lượng gas cần thiết để đi từ trạm i đến trạm i + 1
    // gain[i] = gas[i] - cost[i]; - lượng gas ròng thu được tại mỗi trạm
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int start = n -1, end = 0;
        int tank = gas[start] - cost[start];
        while(start > end){
            if(tank < 0){
                // Lùi dxp về quá khứ để tích lũy đủ gas còn thiếu
                start--;
                tank += gas[start] - cost[start];
            }else{
                tank += gas[end] - cost[end];
                // Tiến về phía trước vì gas vẫn còn đủ
                end++;
            }
        }

        return tank >= 0 ? start : -1;
    }
}
