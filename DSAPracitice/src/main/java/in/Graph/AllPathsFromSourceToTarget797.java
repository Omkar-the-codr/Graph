package in.Graph;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget797 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                adjList.get(i).add(graph[i][j]);
            }
        }
        boolean[] visited = new boolean[n];
        dfs(0, n-1, adjList, visited, new ArrayList<>());
        return ans;
    }
    public void dfs(int currNode, int destination, List<List<Integer>> adjList, boolean[] visited, List<Integer> result){
        if(currNode==destination){
            result.addFirst(0);
            ans.add(new ArrayList<>(result));
            result.remove(0);
            return;
        }
        visited[currNode] = true;
        for(int i=0;i<adjList.get(currNode).size();i++){
            if(!visited[adjList.get(currNode).get(i)]){
                result.add(adjList.get(currNode).get(i));
                dfs(adjList.get(currNode).get(i), destination, adjList, visited, result);
                result.remove(result.size()-1);
            }
        }
        visited[currNode] = false;

    }
}
