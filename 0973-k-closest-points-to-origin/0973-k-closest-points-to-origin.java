class Solution {
    public int[][] kClosest(int[][] points, int k) {
         PriorityQueue<int[]> queue = new PriorityQueue<>(
                (a, b) -> {
                    int distanceA = a[0] * a[0] + a[1] * a[1];
                    int distanceB = b[0] * b[0] + b[1] * b[1];

                    return Integer.compare(distanceB, distanceA);
                });
        for (int i = 0; i < points.length; i++) {
            if (queue.size() < k) {
                queue.offer(points[i]);
            }else{
                int [] top=queue.peek();
                int [] current=points[i];
                int Topdistance=top[0]*top[0]+top[1]*top[1];
                int CurrentDistance=current[0]*current[0]+current[1]*current[1];
                if (CurrentDistance<Topdistance) {
                    queue.poll();
                    queue.offer(current);
                }
            }
        }
        int [][] ans =new int[k][2];
       for (int j = 0;j<k; j++) {
            ans[j]=queue.poll();
       }
       return ans;
    }
}