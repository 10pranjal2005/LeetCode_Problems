class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        
        Map<Integer, Integer> freq = new HashMap<>();
        
        // Count occurrences
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        // Check if frequencies are unique
        Set<Integer> seen = new HashSet<>();
        
        for (int count : freq.values()) {
            if (!seen.add(count)) {   // add() returns false if already present
                return false;
            }
        }
        
        return true;
    }
}