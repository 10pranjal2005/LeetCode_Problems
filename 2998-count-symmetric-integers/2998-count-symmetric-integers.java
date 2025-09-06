/*
class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (isSymmetric(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isSymmetric(int num) {
        String s = String.valueOf(num);
        int n = s.length();

        if (n % 2 != 0) {
            return false;
        }

        int mid = n / 2;
        int firstHalfSum = 0;
        int secondHalfSum = 0;

        for (int i = 0; i < mid; i++) {
            firstHalfSum += s.charAt(i) - '0'; //convert to int form @ [-'0']
        }

        for (int i = mid; i < n; i++) {
            secondHalfSum += s.charAt(i) - '0'; //convert to int form @ [-'0']
        }

        return firstHalfSum == secondHalfSum;
    }
}
*/
class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (i >= 10 && i <= 99) {
                int firstDigit = i / 10;
                int secondDigit = i % 10;
                if (firstDigit == secondDigit) {
                    count++;
                }
            } 
            else if (i >= 1000 && i <= 9999) {
                int firstHalf = i / 100;
                int secondHalf = i % 100;

                int firstHalfSum = (firstHalf / 10) + (firstHalf % 10);
                int secondHalfSum = (secondHalf / 10) + (secondHalf % 10);

                if (firstHalfSum == secondHalfSum) {
                    count++;
                }
            }
        }
        return count;
    }
}