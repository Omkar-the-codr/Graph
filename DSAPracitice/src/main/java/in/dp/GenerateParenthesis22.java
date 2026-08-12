package in.dp;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis22 {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generate(new StringBuilder(), 0, 0, n);
        return ans;
    }
    public void generate(StringBuilder sb, int open, int close, int size){
        if(sb.length()==2*size){
            ans.add(sb.toString());
            return;
        }
        if(open<size){
            sb.append("(");
            generate(sb, open+1, close, size);
            sb.deleteCharAt(sb.length()-1);
        }
        if(open > close && close < size){
            sb.append(")");
            generate(sb, open, close+1, size);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
