class Solution {
    public int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }

        boolean[] isNotPrime = new boolean[n];

        for (int p = 3; p * p < n; p += 2) {
            if (!isNotPrime[p]) {
                for (int i = p * p; i < n; i += (2 * p)) {
                    isNotPrime[i] = true;
                }
            }
        }

        int count = 1;
        for (int i = 3; i < n; i += 2) {
            if (!isNotPrime[i]) {
                count++;
            }
        }

        return count;
    }
}