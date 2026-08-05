class Solution {
    public int leastInterval(char[] tasks, int n) {
        // 1. Count frequency
        int[] count = new int[26];
        for(char task : tasks){
            count[task - 'A']++;
        }

        // 2. (remaining_count, task_id)
        List<int[]> arr = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            if(count[i] > 0){
                arr.add(new int[] {count[i], i});
            }
        }


        // 3. Maintain time = 0
        // idle = -1
        int time = 0;
        // Lịch trình thực tế
        List<Integer> processed = new ArrayList<>();
        while(!arr.isEmpty()){
            // Lưu task_id có count lớn nhất
            int maxi = -1;
            // Kiểm tra cửa sổ cooldown trong khoảng n time gần nhất
            for(int i = 0; i < arr.size(); i++){
                boolean ok = true;
                // Kiểm tra xem trong khoảng thời gian từ time - n
                for(int j = Math.max(0, time - n); j < time; j++){
                    if(j < processed.size() && 
                        processed.get(j) == arr.get(i)[1]){
                            // tác vụ này đã xuất hiện trong khoảng n time --> vi phạm
                            ok = false;
                            break;
                    }
                }

                // nếu ok = false --> bỏ qua task này
                if(!ok) continue;

                // Nếu task hợp lệ, chọn task có count lớn nhất
                if(maxi == -1 || arr.get(maxi)[0] < arr.get(i)[0]){
                    maxi = i;
                }
            }

            time++;
            // Mặc định là idle
            int cur = -1;
            // Nếu có maxi thì có nghĩa là tìm được task hợp lệ
            if(maxi != -1){
                cur = arr.get(maxi)[1];
                arr.get(maxi)[0]--;
                if(arr.get(maxi)[0] == 0){
                    arr.remove(maxi);
                }
            }
            processed.add(cur);
        }

        return time;
    }
}
