package in.Graph;

import java.util.*;

public class MinimumHeightTrees310 {
    // brute force, -> TLE
//    class Solution {
//        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//            List<List<Integer>> adjList = new ArrayList<>();
//            for(int i=0;i<=n;i++){
//                adjList.add(new ArrayList<>());
//            }
//            for(int i=0;i<n-1;i++){
//                adjList.get(edges[i][0]).add(edges[i][1]);
//                adjList.get(edges[i][1]).add(edges[i][0]);
//            }
//            Map<Integer, Integer> map = new HashMap<>();
//
//            for(int i=0;i<n;i++){
//                boolean[] visited = new boolean[n];
//                int length = dfs(i, adjList, n, visited);
//                // System.out.println("Root = " + i + ", Value = " + length);
//                map.put(i, length);
//                // System.out.println("Root = " + i + ", Value = " + length);
//            }
//            LinkedHashMap<Integer, Integer> sortedMap = map.entrySet()
//                    .stream()
//                    .sorted(Map.Entry.comparingByValue())
//                    .collect(Collectors.toMap(
//                            Map.Entry::getKey,
//                            Map.Entry::getValue,
//                            (e1, e2) -> e1,
//                            LinkedHashMap::new
//                    ));
//            Iterator<Map.Entry<Integer, Integer>> it = sortedMap.entrySet().iterator();
//
//            Map.Entry<Integer, Integer> first = it.next();
//
//            List<Integer> answer = new ArrayList<>();
//            answer.add(first.getKey());
//
//            if (it.hasNext()) {
//                Map.Entry<Integer, Integer> second = it.next();
//                // System.out.println("first-> "+ first.getValue());
//                // System.out.println("second-> "+ second.getValue());
//                if (first.getValue().equals(second.getValue())) {
//                    answer.add(second.getKey());
//                }
//            }
//
//            return answer;
//        }
//        public int dfs(int node, List<List<Integer>> adjList, int n, boolean[] visited){
//            visited[node] = true;
//            int childValue = Integer.MIN_VALUE;
//            for(int i=0;i<adjList.get(node).size();i++){
//                if(!visited[adjList.get(node).get(i)]){
//                    childValue = Math.max(dfs(adjList.get(node).get(i), adjList, n, visited)+1, childValue);
//                }
//            }
//            return childValue;
//        }
//
//    }
    // optimized solution
    class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            List<List<Integer>> adjList = new ArrayList<>();
            if(n==1) return new ArrayList<>(List.of(0));
            for(int i=0;i<n;i++){
                adjList.add(new ArrayList<>());
            }
            for(int i=0;i<n-1;i++){
                adjList.get(edges[i][0]).add(edges[i][1]);
                adjList.get(edges[i][1]).add(edges[i][0]);
            }
            Map<Integer, Integer> degreeMap = new HashMap<>();
            for(int i=0;i<n;i++){
                degreeMap.put(i, adjList.get(i).size());
            }
            Queue<Integer> q = new LinkedList<>();
            for(int i=0;i<n;i++){
                int currentDegree = degreeMap.get(i);
                if(currentDegree==1){
                    q.add(i);
                }
            }
            int remaining = n;
            while(remaining>2){
                int size = q.size();
                remaining-=size;
                for(int i=0;i<size;i++){
                    int currentDegreeNode = q.poll();
                    for(int j=0;j<adjList.get(currentDegreeNode).size();j++){
                        int newNodeDegree = degreeMap.get(adjList.get(currentDegreeNode).get(j));
                        int newNode = adjList.get(currentDegreeNode).get(j);
                        degreeMap.put(newNode, newNodeDegree-1);
                        if(newNodeDegree==2) q.offer(newNode);
                    }
                    degreeMap.put(currentDegreeNode, 0);
                }
            }
            return new ArrayList<>(q);
        }

    }
}
