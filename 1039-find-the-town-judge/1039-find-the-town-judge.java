class Solution {
  public int findJudge(int n, int[][] trust) {
    int[] count = new int[n + 1]; // 1-indexed array

    // For each trust relation [a, b]:
    for (int[] t : trust) {
      --count[t[0]];  // a trusts someone → cannot be judge → decrement
      ++count[t[1]];  // b is trusted by someone → increment
    }

    // Judge must have n - 1 net trust points
    for (int i = 1; i < n + 1; ++i)
      if (count[i] == n - 1)
        return i;

    return -1;
  }
}
