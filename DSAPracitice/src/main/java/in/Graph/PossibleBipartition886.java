package in.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PossibleBipartition886 {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<dislikes.length;i++){
            adjList.get(dislikes[i][0]).add(dislikes[i][1]);
            adjList.get(dislikes[i][1]).add(dislikes[i][0]);
        }
        int[] color = new int[n+1];
        Arrays.fill(color, 0);
        for(int i=1;i<=n;i++){
            if(color[i]==0 && !dfs(i, color, 1, adjList)) return false;
        }
        return true;
    }
    public boolean dfs(int currNode, int[] color, int currColor, List<List<Integer>> adjList){
        color[currNode] = currColor;
        for(int i=0;i<adjList.get(currNode).size();i++){
            if(color[adjList.get(currNode).get(i)]==0){
                if(!dfs(adjList.get(currNode).get(i), color, currColor*-1, adjList)) return false;
            }
            else if(color[adjList.get(currNode).get(i)]==currColor){
                return false;
            }
        }
        return true;
    }
}
