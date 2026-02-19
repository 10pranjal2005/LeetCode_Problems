class Solution {
    public int countBinarySubstrings(String s) {
        int prevGroup = 0;     // previous group length
        int currGroup = 1;     // current group length
        int count = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currGroup++;
            } else {
                count += Math.min(prevGroup, currGroup);
                prevGroup = currGroup;
                currGroup = 1;
            }
        }

        // Add last comparison
        count += Math.min(prevGroup, currGroup);

        return count;
    }
}
