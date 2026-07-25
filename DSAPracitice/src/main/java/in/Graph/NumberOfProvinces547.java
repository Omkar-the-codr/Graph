package in.Graph;

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces547 {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<isConnected.length;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[0].length;j++){
                if(isConnected[i][j]==1 && j!=i){
                    if(!adjList.get(i).contains(j)) adjList.get(i).add(j);
                    if(!adjList.get(j).contains(i)) adjList.get(j).add(i);
                }
            }
        }
        int numberOfProvinces=0;
        for(int i=0;i<isConnected.length;i++){
            if(!visited[i]){
                numberOfProvinces++;
                dfs(i, visited, adjList);
            }
        }
        return numberOfProvinces;
    }
    public void dfs(int currentNode, boolean[] visited, List<List<Integer>> adjList) {
        visited[currentNode] = true;
        for (int i = 0; i < adjList.get(currentNode).size(); i++) {
            if (!visited[adjList.get(currentNode).get(i)]) {
                dfs(adjList.get(currentNode).get(i), visited, adjList);
            }
        }
    }
// 1 -> [2]
// 2 -> [1]
// 3 -> [3]
}
