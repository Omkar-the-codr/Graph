package in.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTime743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adjList = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge: times){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adjList.get(u).add(new int[]{v, w});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[0]-b[0]);
        int[] dist = new int[n+1];
        Arrays.fill(dist, (int)1e9);
        dist[k] = 0;

        pq.add(new int[]{0, k});

        while(pq.size()>0){
            int currentNode = pq.peek()[1];
            int weight = pq.peek()[0];
            pq.remove();
            if(weight>dist[currentNode]) continue;
            for(int[] it: adjList.get(currentNode)){
                int node = it[0];
                int wei = it[1];
                if(weight + wei<dist[node]){
                    dist[node] = weight+ wei;
                    pq.add(new int[]{dist[node], node});
                }
            }
        }
        int ans =0;
        for(int i=1;i<dist.length;i++){
            if(dist[i] == (int) 1e9) return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}
