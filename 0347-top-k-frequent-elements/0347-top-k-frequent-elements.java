class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[k];
        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {

                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(
                (a, b) -> Integer.compare(b.getValue(), a.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry);
        }
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> pair = queue.poll();
            arr[i] = pair.getKey();
        }
        return arr;
    }
}