class MinStack {

    Deque<Integer> minStack = new ArrayDeque<>();
        Deque<Integer> mainStack = new ArrayDeque<>();
    public MinStack() {
    }
    
    public void push(int value) {
        mainStack.push(value);
        if (minStack.isEmpty() || minStack.peek() >= value) {
            minStack.push(value);
        }
    }
    
    public void pop() {
            if (mainStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        mainStack.pop();
    }
    
    public int top() {
                return mainStack.peek();

    }
    
    public int getMin() {
                return minStack.peek() ;

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */