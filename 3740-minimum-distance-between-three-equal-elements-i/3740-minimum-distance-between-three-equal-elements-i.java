class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] != nums[j]) continue;

                for (int k = j + 1; k < n; k++) {
                    if (nums[i] == nums[k]) {
                        int distance = Math.abs(i - j) 
                                     + Math.abs(j - k) 
                                     + Math.abs(k - i);

                        minDistance = Math.min(minDistance, distance);
                    }
                }
            }
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}