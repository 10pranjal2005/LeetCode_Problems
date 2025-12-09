class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int one = 2;  
        int two = 1;  
        for (int i = 3; i <= n; i++) {
            int current = one + two;
            two = one;
            one = current;
        }

        return one;
    }
}
