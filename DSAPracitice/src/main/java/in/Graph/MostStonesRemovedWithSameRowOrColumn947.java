package in.Graph;

public class MostStonesRemovedWithSameRowOrColumn947 {
    public int removeStones(int[][] stones) {
        boolean[] visited = new boolean[stones.length];
        int numberOfIslands = 0;
        for(int i=0;i<stones.length;i++){
            if(!visited[i]){
                dfs(i, visited, stones);
                numberOfIslands++;
            }
        }
        return stones.length-numberOfIslands;
    }
    public void dfs(int currStone, boolean[] visited, int[][] stones){
        visited[currStone] = true;
        for(int i=0;i<stones.length;i++){
            if(!visited[i]){
                if(stones[currStone][0] == stones[i][0] || stones[currStone][1] == stones[i][1]) {
                    dfs(i, visited, stones);
                }
            }
        }
    }
}
