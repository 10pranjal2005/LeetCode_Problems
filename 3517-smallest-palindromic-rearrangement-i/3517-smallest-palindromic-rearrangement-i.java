class Solution {
    public String smallestPalindrome(String s) {

        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder left = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            int times = count[i] / 2;

            while (times > 0) {
                left.append((char) ('a' + i));
                times--;
            }
        }

        StringBuilder ans = new StringBuilder();

        ans.append(left);

        if (s.length() % 2 == 1) {
            for (int i = 0; i < 26; i++) {
                if (count[i] % 2 == 1) {
                    ans.append((char) ('a' + i));
                    break;
                }
            }
        }

        ans.append(left.reverse());

        return ans.toString();
    }
}