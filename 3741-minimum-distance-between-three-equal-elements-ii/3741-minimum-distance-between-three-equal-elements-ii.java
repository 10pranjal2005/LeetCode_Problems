import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        int min = Integer.MAX_VALUE;
        
        for (List<Integer> list : map.values()) {
            if (list.size() < 3) continue;
            
            for (int i = 0; i + 2 < list.size(); i++) {
                int dist = 2 * (list.get(i + 2) - list.get(i));
                min = Math.min(min, dist);
            }
        }
        
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}