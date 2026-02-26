class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        long total = 0;
        
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
        
        int left = 0;
        int right = n - 1;
        
        // Fill initial heaps
        for (int i = 0; i < candidates && left <= right; i++) {
            leftHeap.offer(costs[left++]);
        }
        
        for (int i = 0; i < candidates && left <= right; i++) {
            rightHeap.offer(costs[right--]);
        }
        
        // Hire k workers
        for (int i = 0; i < k; i++) {
            
            if (rightHeap.isEmpty() || 
               (!leftHeap.isEmpty() && leftHeap.peek() <= rightHeap.peek())) {
                
                total += leftHeap.poll();
                
                if (left <= right) {
                    leftHeap.offer(costs[left++]);
                }
            } else {
                
                total += rightHeap.poll();
                
                if (left <= right) {
                    rightHeap.offer(costs[right--]);
                }
            }
        }
        
        return total;
    }
}