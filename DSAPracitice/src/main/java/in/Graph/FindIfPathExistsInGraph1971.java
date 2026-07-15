package in.Graph;

import java.util.ArrayList;
import java.util.List;

 class FindIfPathExistsInGraph1971 {
            public boolean validPath(int n, int[][] edges, int source, int destination) {
                List<List<Integer>> adjList = new ArrayList<>();
                for(int i=0;i<n;i++){
                    adjList.add(new ArrayList<>());
                }
                for(int[] arr: edges){
                    adjList.get(arr[0]).add(arr[1]);
                    adjList.get(arr[1]).add(arr[0]);
                } // adjacency list created here
                boolean[] visited = new boolean[n+1];
                dfs(adjList, visited, source);
                if(!visited[destination]) return false;
                return true;

            }
            public void dfs(List<List<Integer>> adjList, boolean[] visited, int node){
                visited[node] = true;
                for(int neighbour: adjList.get(node)){
                    if(!visited[neighbour]) dfs(adjList, visited, neighbour);
                }
            }
        }