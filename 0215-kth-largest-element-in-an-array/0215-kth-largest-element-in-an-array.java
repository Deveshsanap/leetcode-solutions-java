class Solution {
    public int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            if (queue.size()<k) {
                queue.offer(arr[i]);
            }else if (arr[i]>queue.peek()) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
      return queue.peek();
    }
}