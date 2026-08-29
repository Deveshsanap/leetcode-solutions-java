class Solution {
    public int evalRPN(String[] tokens) {
          int a;
            int b;
            Deque<Integer> stack=new ArrayDeque<>();
            for (int i = 0; i < tokens.length; i++) {
                 switch (tokens[i]) {
                    case "+":
                        b=stack.pop();
                        a=stack.pop();
                        stack.push(a+b);
                        break;
                    case "*":
                        b=stack.pop();
                        a=stack.pop();
                        stack.push(a*b);
                        break;
                    case "/":
                        b=stack.pop();
                        a=stack.pop();
                        stack.push(a/b);
                        break;
                    case "-":
                        b=stack.pop();
                        a=stack.pop();
                        stack.push(a-b);
                        break;
                 
                    default:
                        stack.push(Integer.parseInt(tokens[i]));
                 }
            }
            return stack.peek();
    }
}