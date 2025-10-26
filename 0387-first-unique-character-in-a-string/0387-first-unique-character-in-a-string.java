class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();
        if (n == 0) return -1;

        int[] counts = new int[26];
        char[] chars = s.toCharArray(); 

        for (char c : chars) {
            counts[c - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            if (counts[chars[i] - 'a'] == 1) return i;
        }

        return -1;
    }
}
