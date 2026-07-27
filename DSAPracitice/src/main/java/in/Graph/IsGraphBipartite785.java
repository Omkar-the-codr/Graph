package in.Graph;

import java.util.ArrayList;
import java.util.List;

public class IsGraphBipartite785 {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            adjList.add(new ArrayList<>());

            for (int j = 0; j < graph[i].length; j++) {
                adjList.get(i).add(graph[i][j]);
            }
        }
        int[] colors = new int[n];
        boolean ans = true;
        for(int i=0;i<n;i++){
            if(colors[i]==0 && !dfs(adjList, colors, i, 1)){
                return false;
            }
        }
        return true;
    }
    public boolean dfs(List<List<Integer>> adjList, int[] colors, int node, int color){
        colors[node] = color;
        boolean ans = true;
        for(int i=0;i<adjList.get(node).size();i++){
            if(colors[adjList.get(node).get(i)]==0){
                ans = ans && dfs(adjList, colors, adjList.get(node).get(i), color*-1);
                if(ans==false) return false;
            }
            else if(colors[adjList.get(node).get(i)]==color){
                return false;
            }
        }
        return true;
    }
}
