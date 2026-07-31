package in.Graph;

import java.util.ArrayList;
import java.util.List;

public class KeysAndRooms841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<rooms.size();i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<rooms.size();i++){
            for(int j=0;j<rooms.get(i).size();j++){
                adjList.get(i).add(rooms.get(i).get(j));
            }
        }
        boolean[] visited = new boolean[rooms.size()];
        dfs(0, adjList, visited);
        for(int i=0;i<visited.length;i++){
            if(!visited[i]) return false;
        }
        return true;
    }
    public void dfs(int source, List<List<Integer>> adjList, boolean[] visited){
        visited[source] = true;
        for(int i=0;i<adjList.get(source).size();i++){
            if(!visited[adjList.get(source).get(i)]){
                dfs(adjList.get(source).get(i), adjList, visited);
            }
        }
    }
}
