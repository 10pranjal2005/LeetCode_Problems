class RecentCounter {

    private int[] times;
    private int start;
    private int end;

    public RecentCounter() {
        times = new int[10000]; // Based on constraints: up to 10^4 calls
        start = 0;
        end = 0;
    }

    public int ping(int t) {
        times[end++] = t;

        while (times[start] < t - 3000) {
            start++;
        }

        return end - start;
    }
}
