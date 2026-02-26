class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        
        // Pair nums2 and nums1
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums2[i];
            pairs[i][1] = nums1[i];
        }
        
        // Sort by nums2 descending
        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0;
        long maxScore = 0;
        
        for (int i = 0; i < n; i++) {
            sum += pairs[i][1];
            minHeap.offer(pairs[i][1]);
            
            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }
            
            if (minHeap.size() == k) {
                long score = sum * pairs[i][0];
                maxScore = Math.max(maxScore, score);
            }
        }
        
        return maxScore;
    }
}