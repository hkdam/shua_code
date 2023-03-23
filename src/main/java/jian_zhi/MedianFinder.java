package jian_zhi;

import java.util.PriorityQueue;


public class MedianFinder {

        private PriorityQueue<Integer> maxHeap;
        private PriorityQueue<Integer> minHeap;

        public MedianFinder() {

            this.maxHeap = new PriorityQueue<>((a, b) -> (b-a));
            this.minHeap = new PriorityQueue<>((a, b) -> (a-b));
        }


        public void addNum(int num) {

            if(maxHeap.isEmpty() || num <= maxHeap.peek()){
                maxHeap.offer(num);
                if(maxHeap.size() - 1 > minHeap.size())
                    minHeap.offer(maxHeap.poll());
            }else {
                minHeap.offer(num);
                if (minHeap.size() > maxHeap.size())
                    maxHeap.offer(minHeap.poll());
            }
        }

        public double findMedian() {

            if(maxHeap.size() > minHeap.size())
                return maxHeap.peek();
            else
                return (maxHeap.peek() + minHeap.peek())/2.0;
        }
}

