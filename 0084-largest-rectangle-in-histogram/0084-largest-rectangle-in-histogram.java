class Solution {
      class Pair {
        int height;
        int index;

        Pair(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }
    public int largestRectangleArea(int[] heights) {
         Deque<Pair> stack = new ArrayDeque<>();
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {

            while (!stack.isEmpty() &&
                   heights[i] < stack.peek().height) {

                Pair popped = stack.pop();

                int height = popped.height;

                int leftBoundary;

                if (stack.isEmpty()) {
                    leftBoundary = -1;
                } else {
                    leftBoundary = stack.peek().index;
                }

                int width = i - leftBoundary - 1;

                int area = height * width;

                maxArea = Math.max(maxArea, area);
            }

            stack.push(new Pair(heights[i], i));
        }

        while (!stack.isEmpty()) {

            Pair popped = stack.pop();

            int height = popped.height;

            int leftBoundary;

            if (stack.isEmpty()) {
                leftBoundary = -1;
            } else {
                leftBoundary = stack.peek().index;
            }

            int width = heights.length - leftBoundary - 1;

            int area = height * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}