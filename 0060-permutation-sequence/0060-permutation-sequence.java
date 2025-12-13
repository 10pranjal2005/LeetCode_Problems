class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> a = new ArrayList<>();
        int f = 1;

        for (int i = 1; i <= n; i++) {
            a.add(i);
            f *= i;
        }

        k--; // zero-based
        StringBuilder s = new StringBuilder();

        for (int i = n; i > 0; i--) {
            f /= i;
            int idx = k / f;
            s.append(a.get(idx));
            a.remove(idx);
            k %= f;
        }

        return s.toString();
    }
}
