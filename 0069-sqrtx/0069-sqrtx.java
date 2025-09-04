class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        long r = x;
        while (r > x / r) { 
            r = (r + x / r) / 2; //Newton's fromuale to calculate SQRT
        }
        return (int) r;
    }
}
