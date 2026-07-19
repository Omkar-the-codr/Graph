package in.Graph;

import java.util.*;

public class EvaluateDivision399 {
    class Edge {
        String neighbour;
        double weight;

        Edge(String neighbour, double weight) {
            this.neighbour = neighbour;
            this.weight = weight;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Edge>> graph = new HashMap<>();
        List<Double> ansList = new ArrayList<>();
        Set<String> set = new HashSet<>();
        // for(int i=0;i<equations.size();i++){
        //     adjMap.put(equations.get(i), values[i]);
        //     adjMap.put(new ArrayList<>(List.of(equations.get(i).get(1), equations.get(i).get(0))), 1/values[i]);
        //     set.add(equations.get(i).get(0));
        //     set.add(equations.get(i).get(1));

        // }
        for (int i = 0; i < equations.size(); i++) {

            String from = equations.get(i).get(0);
            String to = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(from, new ArrayList<>());
            graph.putIfAbsent(to, new ArrayList<>());

            graph.get(from).add(new Edge(to, value));
            graph.get(to).add(new Edge(from, 1.0 / value));
            set.add(from);
            set.add(to);
        }
        for(int i=0;i<queries.size();i++){
            Map<String, Boolean> visited  = new HashMap<>();
            for(int j=0;j<equations.size();j++){
                visited.put(equations.get(j).get(0), false);
                visited.put(equations.get(j).get(1), false);
            }
            double ans = dfs(queries.get(i).get(0), queries.get(i).get(1), visited, graph, set);
            ansList.add(ans);
        }
        return ansList.stream().mapToDouble(Double::doubleValue).toArray();
    }
    public double dfs(String from, String to, Map<String, Boolean> visited, Map<String, List<EvaluateDivision399.Edge>> graph, Set<String> set){
        if(!set.contains(from) || !set.contains(to)) return -1.0;
        if(from.equals(to)) return 1.0;
        visited.put(from, true);
        for (Edge edge : graph.get(from)) {
            String next = edge.neighbour;
            double weight = edge.weight;
            if(visited.get(next)==false){
                double ans = dfs(next, to, visited, graph, set);
                if(ans>0) return weight*ans;
            }
        }
        return -1.0;
    }
}
