package in.Graph;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        boolean[] visited = new boolean[numCourses+1];
        boolean[] pathVisiting = new boolean[numCourses+1];
        boolean ans = true;
        for(int i=0;i<numCourses;i++){
            if(!visited[i]) ans = ans && dfs(i, adjList, visited, pathVisiting);
        }
        return ans;
    }
    public boolean dfs(int currentCourse, List<List<Integer>> adjList, boolean[] visited, boolean[] pathVisiting){
        // if(visited[currentCourse] && pathVisiting[currentCourse]) return true;
        visited[currentCourse] = true;
        pathVisiting[currentCourse] = true;
        boolean result= true;
        for(int i=0;i<adjList.get(currentCourse).size();i++){
            if(!visited[adjList.get(currentCourse).get(i)]){
                result =result && dfs(adjList.get(currentCourse).get(i), adjList, visited, pathVisiting);
            } else if(visited[adjList.get(currentCourse).get(i)] && pathVisiting[adjList.get(currentCourse).get(i)]) return false;
        }
        pathVisiting[currentCourse] = false;
        return result;
    }
}
