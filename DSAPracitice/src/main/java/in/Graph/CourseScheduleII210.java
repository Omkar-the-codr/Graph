package in.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CourseScheduleII210 {
    Stack<Integer> list = new Stack<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==0){
            for(int i=0;i<numCourses;i++){
                list.push(i);
            }
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisiting = new boolean[numCourses];
        boolean ans = true;
        for(int i=0;i<numCourses;i++){
            if(!visited[i])
                ans = ans && dfs(i, visited, pathVisiting, adjList);
        }
        if(ans==false) return new int[]{};
        int[] answ = new int[numCourses];

        int index = 0;

        while(!list.isEmpty()){

            answ[index++] = list.pop();

        }

        return answ;
    }
    public boolean dfs(int currentCourse, boolean[] visited, boolean[] pathVisiting, List<List<Integer>> adjList){
        visited[currentCourse] = true;
        pathVisiting[currentCourse] = true;
        boolean ans = true;
        for(int i=0;i<adjList.get(currentCourse).size();i++){
            if(!visited[adjList.get(currentCourse).get(i)]){
                ans = ans && dfs(adjList.get(currentCourse).get(i), visited, pathVisiting, adjList);
                if(!ans) return false;
                // list.addAll(adjList.get(currentCourse));
            }else if(visited[adjList.get(currentCourse).get(i)] && pathVisiting[adjList.get(currentCourse).get(i)]) return false;
        }
        list.push(currentCourse);
        pathVisiting[currentCourse] = false;
        return ans;
    }
// 0 -> [1, 2]
// 1 -> [3]
// 2 -> [3]
}
