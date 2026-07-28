package in.Graph;

import java.util.*;

public class CheapestFlightsWithinKStops787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adjList = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] flight: flights){
            int u = flight[0];
            int v = flight[1];
            int w = flight[2];
            adjList.get(u).add(new int[]{v, w});
        }
        Queue<int[]> pq = new LinkedList<>();
        int[] dist = new int[n+1];
        Arrays.fill(dist, (int)1e9);
        dist[src] = 0;
        pq.add(new int[]{0,src});
        int stop =0;
        while(pq.size()>0 && stop<=k){
            int size = pq.size();
            while(size-- >0){
                int[] currNode = pq.poll();
                for(int[] it: adjList.get(currNode[1])){
                    int node = it[0];
                    int wei = it[1];
                    if(currNode[0]+wei>=dist[node]) continue;
                    dist[node] = currNode[0] + wei;
                    pq.add(new int[]{dist[node], node});
                }
            }
            stop++;
        }
        return dist[dst] == (int)1e9? -1: dist[dst];
    }
}
