class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n < 0) {
            x = 1 / x;
            if (n == Integer.MIN_VALUE) {
                n++;
                return x * myPow(x, -n);
            }
            n = -n;
        }
        if (n % 2 == 0) {
            double half = myPow(x, n / 2);
            return half * half; //more efficient than x^n
        } else {
            return x * myPow(x, n - 1); //first make power even 
        }
    }
}