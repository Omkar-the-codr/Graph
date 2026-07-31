package in.dp;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII119 {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int row=1;row<=rowIndex+1;row++){
            ans.add(generateRow(row));
        }
        return ans.get(rowIndex);
    }
    private static List<Integer> generateRow(int row){
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1);

        for(int col = 1;col<row;col++){
            ans = ans*(row-col);
            ans = ans/col;
            ansRow.add((int)ans);
        }
        return ansRow;
    }
}
