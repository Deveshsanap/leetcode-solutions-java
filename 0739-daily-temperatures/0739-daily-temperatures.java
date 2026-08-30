class Solution {
     public class pair {
        int temperature;
        int index;

        public pair(int temperature, int index) {
            this.temperature = temperature;
            this.index = index;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answers = new int[temperatures.length];
        Deque<pair> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && stack.peek().temperature < temperatures[i]) {
                answers[stack.peek().index] = i - stack.peek().index;
                stack.pop();
            }
            stack.push(new pair(temperatures[i], i));
        }
        return answers;
    }
}