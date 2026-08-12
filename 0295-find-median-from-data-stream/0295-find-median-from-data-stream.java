class MedianFinder {
     PriorityQueue<Integer> secondHalf = new PriorityQueue<>();
    PriorityQueue<Integer> firstHalf = new PriorityQueue<>((a, b) -> (Integer.compare(b, a)));
    public void addNum(int num) {
          if (firstHalf.isEmpty()) {
            firstHalf.offer(num);
        } else if (num <= firstHalf.peek()) {
            firstHalf.offer(num);
        } else {
            secondHalf.offer(num);
        }

        if (firstHalf.size() > secondHalf.size() + 1) {
            secondHalf.offer(firstHalf.poll());
        }

        if (secondHalf.size() > firstHalf.size()) {
            firstHalf.offer(secondHalf.poll());
        }
    }
    
    public double findMedian() {
       
        if (firstHalf.size() > secondHalf.size()) {
            return firstHalf.peek();
        }

        return (firstHalf.peek() + secondHalf.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */