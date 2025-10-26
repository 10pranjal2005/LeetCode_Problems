import java.util.Queue;
import java.util.ArrayDeque;

class RecentCounter {

    private Queue<Integer> requests;

    public RecentCounter() {
        requests = new ArrayDeque<>();
    }
    
    public int ping(int t) {
        requests.offer(t);
        
        int minTime = t - 3000;
        
        while (!requests.isEmpty() && requests.peek() < minTime) {
            requests.poll();
        }
        
        return requests.size();
    }
}