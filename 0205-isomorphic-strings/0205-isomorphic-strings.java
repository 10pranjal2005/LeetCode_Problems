class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] a = new int[256];
        int[] b = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            char y = t.charAt(i);

            if (a[x] == 0 && b[y] == 0) {
                a[x] = y;
                b[y] = x;
            } else {
                if (a[x] != y || b[y] != x) return false;
            }
        }
        return true;
    }
}
