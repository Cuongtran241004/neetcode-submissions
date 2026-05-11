class Solution {

    public String encode(List<String> strs) {
        if(strs.isEmpty()) return "";
        StringBuilder res = new StringBuilder();
        // Lưu trữ độ dài của 1 element trong list
        List<Integer> sizes = new ArrayList<>();

        for(String str : strs){
            sizes.add(str.length());
        }

        for(int size : sizes){
            res.append(size).append(',');
        }

        res.append('#');
        for(String str : strs){
            res.append(str);
        }

        return res.toString();
    }

    public List<String> decode(String str) {
        if(str.length() == 0){
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();
        int i = 0;
        while(str.charAt(i) != '#'){
            StringBuilder cur = new StringBuilder();
            // Có thể index là số có 2, 3, 4 chữ số
            while(str.charAt(i) != ','){
                cur.append(str.charAt(i));
                i++;
            }

            sizes.add(Integer.parseInt(cur.toString()));
            i++;
        }

        // Bỏ qua dấu '#' trong string
        i++;
        for(int size : sizes){
            res.add(str.substring(i, i + size));
            i += size;
        }

        return res;
    }
}
