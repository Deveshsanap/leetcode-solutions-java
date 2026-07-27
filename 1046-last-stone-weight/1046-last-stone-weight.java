class Solution {
    public int lastStoneWeight(int[] stones) {
         PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < stones.length; i++) {
            queue.offer(stones[i]);
        }
        while (queue.size()>1) {

            int x = queue.poll();
            int y = queue.poll();
            if (x != y) {
                queue.offer(x - y);
            }
        }

        if (queue.size() == 0) {
            return 0;
        } else {
            return queue.peek();
        }

    }
}