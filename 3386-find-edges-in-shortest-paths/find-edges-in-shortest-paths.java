class Solution {
    public boolean[] findAnswer(int n, int[][] edges) {
        ArrayList<int[]>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }
        long[] dist0 = dijkstra(0, graph, n);
        long[] distN = dijkstra(n - 1, graph, n);
        boolean[] answer = new boolean[edges.length];
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            if(dist0[u] != Long.MAX_VALUE &&
               distN[v] != Long.MAX_VALUE &&
               dist0[u] + w + distN[v] == dist0[n - 1]){
                answer[i] = true;
            }
            if(dist0[v] != Long.MAX_VALUE &&
               distN[u] != Long.MAX_VALUE &&
               dist0[v] + w + distN[u] == dist0[n - 1]){
                answer[i] = true;
            }
        }
        return answer;
    }
    public long[] dijkstra(int src, ArrayList<int[]>[] graph, int n) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[1], b[1])
        );
        pq.add(new long[]{src, 0});
        while(!pq.isEmpty()){
            long[] curr = pq.poll();
            int node = (int)curr[0];
            long d = curr[1];
            if(d != dist[node]){
                continue;
            }
            for(int i = 0; i < graph[node].size(); i++){
                int next = graph[node].get(i)[0];
                int weight = graph[node].get(i)[1];
                if(dist[node] + weight < dist[next]){
                    dist[next] = dist[node] + weight;
                    pq.add(new long[]{next, dist[next]});
                }
            }
        }
        return dist;
    }
}