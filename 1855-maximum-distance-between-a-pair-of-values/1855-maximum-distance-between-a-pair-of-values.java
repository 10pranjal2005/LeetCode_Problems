class Solution {
    public int maxDistance(int[] num1, int[] num2) {
        int i = 0;
        int j = 0;
        int maxDist = 0;
        while (i < num1.length && j < num2.length) {
            if (num1[i] <= num2[j]) {
                maxDist = Math.max(maxDist, j - i);
                j++;  
            } 
            else {
                i++;  
            }
        }
        return maxDist;
    }
}