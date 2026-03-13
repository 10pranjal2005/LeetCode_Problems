class Solution {

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        long left = 1;
        long right = (long)1e18;
        long ans = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (canFinish(mid, mountainHeight, workerTimes)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private boolean canFinish(long time, int mountainHeight, int[] workerTimes) {

        long total = 0;

        for (int w : workerTimes) {

            long low = 0, high = (long) Math.sqrt(2 * time / w) + 2;

            while (low <= high) {
                long mid = (low + high) / 2;
                long cost = (long) w * mid * (mid + 1) / 2;

                if (cost <= time) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            total += high;

            if (total >= mountainHeight) return true;
        }

        return total >= mountainHeight;
    }
}