class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> jewelSet = new HashSet<>();
        
        // Store all jewels in a set for O(1) lookup
        for (char j : jewels.toCharArray()) {
            jewelSet.add(j);
        }

        int count = 0;
        // Count how many stones are jewels
        for (char s : stones.toCharArray()) {
            if (jewelSet.contains(s)) {
                count++;
            }
        }

        return count;
    }
}