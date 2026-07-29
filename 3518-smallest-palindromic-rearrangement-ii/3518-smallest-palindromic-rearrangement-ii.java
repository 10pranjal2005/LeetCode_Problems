class Solution {
    long INF = 1000001;

    public String smallestPalindrome(String s, int k) {

        int[] cnt = new int[26];

        for (char c : s.toCharArray())
            cnt[c - 'a']++;

        int[] half = new int[26];

        for (int i = 0; i < 26; i++)
            half[i] = cnt[i] / 2;

        StringBuilder left = new StringBuilder();

        for (int pos = 0; pos < s.length() / 2; pos++) {

            boolean found = false;

            for (int c = 0; c < 26; c++) {

                if (half[c] == 0)
                    continue;

                half[c]--;

                long ways = ways(half);

                if (ways >= k) {
                    left.append((char)('a' + c));
                    found = true;
                    break;
                }

                k -= ways;
                half[c]++;
            }

            // no possible character found
            if (!found)
                return "";
        }

        String a = left.toString();
        String b = new StringBuilder(a).reverse().toString();

        String mid = "";

        if (s.length() % 2 == 1) {
            for (int i = 0; i < 26; i++) {
                if (cnt[i] % 2 == 1) {
                    mid = "" + (char)('a' + i);
                    break;
                }
            }
        }

        return a + mid + b;
    }


    long ways(int[] arr) {

        int total = 0;

        for (int x : arr)
            total += x;

        long ans = 1;

        for (int x : arr) {

            if (x == 0)
                continue;

            ans *= comb(total, x);

            if (ans >= INF)
                return INF;

            total -= x;
        }

        return ans;
    }


    long comb(int n, int r) {

        r = Math.min(r, n - r);

        long ans = 1;

        for (int i = 1; i <= r; i++) {

            ans = ans * (n - r + i) / i;

            if (ans >= INF)
                return INF;
        }

        return ans;
    }
}