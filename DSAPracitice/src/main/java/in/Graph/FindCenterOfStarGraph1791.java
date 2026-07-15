package in.Graph;

public class FindCenterOfStarGraph1791 {
    public int findCenter(int[][] edges) {
        int[] arr = new int[edges.length+2];
        for(int[] edge: edges){
            arr[edge[0]]++;
            arr[edge[1]]++;
        }
        for(int i=1;i<arr.length;i++){
            if(arr[i]==edges.length) return i;
        }
        return -1;
    }
}
