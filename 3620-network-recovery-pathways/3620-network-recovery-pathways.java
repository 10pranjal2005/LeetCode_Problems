import java.util.*;

class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        List<int[]>[] graph = new ArrayList[n];
        int[] indegree = new int[n];
        int maxCost = 0;

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0], v = e[1], c = e[2];
            graph[u].add(new int[]{v, c});
            indegree[v]++;
            maxCost = Math.max(maxCost, c);
        }

        // Topological sort of the original DAG
        int[] topo = new int[n];
        Queue<Integer> q = new LinkedList<>();
        int[] deg = indegree.clone();

        for (int i = 0; i < n; i++)
            if (deg[i] == 0)
                q.offer(i);

        int idx = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            topo[idx++] = u;

            for (int[] e : graph[u]) {
                if (--deg[e[0]] == 0)
                    q.offer(e[0]);
            }
        }

        int lo = 0, hi = maxCost, ans = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (can(mid, graph, topo, online, k, n)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }

    private boolean can(int minEdge,
                        List<int[]>[] graph,
                        int[] topo,
                        boolean[] online,
                        long k,
                        int n) {

        long INF = Long.MAX_VALUE / 4;
        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        dist[0] = 0;

        for (int u : topo) {
            if (dist[u] == INF)
                continue;

            if (u != 0 && u != n - 1 && !online[u])
                continue;

            for (int[] e : graph[u]) {
                int v = e[0], c = e[1];

                if (c < minEdge)
                    continue;

                if (v != 0 && v != n - 1 && !online[v])
                    continue;

                dist[v] = Math.min(dist[v], dist[u] + c);
            }
        }

        return dist[n - 1] <= k;
    }
}