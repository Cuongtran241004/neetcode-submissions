class Solution {
    // Brute Force
    public int evalRPN(String[] tokens) {
        // Tại sao phải dùng List - mảng tự co giãn, không cần quan tâm đến size
        // Tại sao phải dùng vòng while - for
        // While: lặp đi lặp lại nhiều lần, không biết số lần lặp
        // For: để tính các phép tính lồng vào nhau
        // Vòng for đóng vai trò tính toán tích lũy, 
        // vòng while là để đảm bảo các phép toán được thực hiện đầy đủ
        List<String> tokenList = new ArrayList<>(Arrays.asList(tokens));

        while(tokenList.size() > 1){
            for(int i = 0; i < tokenList.size(); i++){
                String token = tokenList.get(i);

                if ("+-*/".contains(token)) {
                    int a = Integer.parseInt(tokenList.get(i - 2));
                    int b = Integer.parseInt(tokenList.get(i - 1));
                    int result = 0;

                    if (token.equals("+")) {
                        result = a + b;
                    } else if (token.equals("-")) {
                        result = a - b;
                    } else if (token.equals("*")) {
                        result = a * b;
                    } else if (token.equals("/")) {
                        result = a / b;
                    }

                    // replace first number by result (accumulative result)
                    tokenList.set(i - 2, String.valueOf(result));
                    // remove second number
                    tokenList.remove(i);
                    // remove operator
                    tokenList.remove(i - 1);
                    break;
                }

                
            }
        }
        return Integer.parseInt(tokenList.get(0));
    }
}
