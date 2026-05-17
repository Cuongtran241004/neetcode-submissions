class MinStack {
/**
* push(): thêm phần tử vào đỉnh của Stack
* pop(): xóa phần tử ở đỉnh và return value
* peek(): xem phần tử ở đỉnh
*/
    private Stack<Integer> stack;
    
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    // Return min value nhưng vẫn phải giữ lại toàn bộ các value trong stack
    // stack không hỗ trợ cơ chế duyệt qua từng element nên phải dùng 1 array là tmp
    public int getMin() {
        Stack<Integer> tmp = new Stack<>();
        int min = stack.peek();

        while(!stack.isEmpty()){
            min = Math.min(min, stack.peek());
            tmp.push(stack.pop());
        }

        while(!tmp.isEmpty()){
            stack.push(tmp.pop());
        }

        return min;
    }
}
