/*
class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count=0;
        for (int i=low;i<=high;i++) {
            if (isSymmetric(i)) {
                count++;
            }
        }
        return count;
    }
    private boolean isSymmetric(int num) {
        String s = String.valueOf(num);
        int n = s.length();
        if (n%2!=0) {
            return false;
        }

        int mid=n/2;
        int Sum1=0;
        int Sum2=0;

        for (int i=0;i<mid;i++) {
            Sum1+=s.charAt(i) - '0'; //convert to int form @ [-'0']
        }

        for (int i=mid;i<n;i++) {
            Sum2+=s.charAt(i) - '0'; //convert to int form @ [-'0']
        }

        return Sum1==Sum2;
    }
}
*/
class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (i >= 10 && i <= 99) {
                int digit1 = i / 10;
                int digit2 = i % 10;
                if (digit1 == digit2) {
                    count++;
                }
            } 
            else if (i >= 1000 && i <= 9999) {
                int half1 = i / 100;
                int half2 = i % 100;

                int sum1 = (half1 / 10) + (half1 % 10);
                int sum2 = (half2 / 10) + (half2 % 10);

                if (sum1 == sum2) {
                    count++;
                }
            }
        }
        return count;
    }
}